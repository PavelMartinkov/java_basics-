import com.fasterxml.jackson.databind.ObjectMapper;
import core.Line;
import core.Station;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Parsing {

    private static final String PATH_MAP_JSON = "data/map.json";
    private static final String PATH_STATIONS_JSON = "data/stations.json";

    public final List<Line> line;
    public final List<Station> station;
    public Map<String, String> stationMapOfDate = new LinkedHashMap<>();
    public Map<String, String> stationMapOfDepth = new LinkedHashMap<>();

    private static final String TAG_NAME = "name";
    private static final String TAG_DATE = "date";
    private static final String TAG_DEPTH = "depth";
    private static final String TAG_STATION_NAME = "station_name";
    private static final String TAG_DEPTH_METERS = "depth_meters";

    public String hasConnection = "";

    public Parsing() {
        line = new ArrayList<>();
        station = new ArrayList<>();
    }

    private String parseFile(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line -> builder.append(line + "\n"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public void parseHtml(String link) {
        String htmlFile = parseFile(link);
        Document document = Jsoup.parse(htmlFile);
        Elements elementsOfLine = document.select(".js-metro-line");
        elementsOfLine.forEach(element -> {
            line.add(new Line(element.attr("data-line"), " " + element.text()));
        });
        String regex = "[0-9\\.]";
        Elements elementsOfStation = document.select(".single-station");
        elementsOfStation.forEach(element -> {
            station.add(new Station(element.text().replaceAll(regex, "").trim(), element.parent().attr("data-line")));
        });
        Elements elementsOfConnection = document.select(".t-icon-metroln");
        elementsOfConnection.forEach(element -> {
            hasConnection += element.attr("title") + "\n";
        });
    }

    public String createMapJson() {
        try {
            PrintWriter writer = new PrintWriter(PATH_MAP_JSON);

            LinkedHashMap<String, List> item = new LinkedHashMap<>();
            for (int i = 0; i < line.size(); i++) {
                ArrayList<String> arrayOfStation = new ArrayList<>();
                for (int j = 0; j < station.size(); j++) {
                    if (station.get(j).getLineNumber().equals(line.get(i).getNumber())) {
                        arrayOfStation.add(station.get(j).getName());
                    }
                    item.put(line.get(i).getNumber(), arrayOfStation);
                }
            }
            JSONObject json = new JSONObject();
            json.put("stations", item);

            ObjectMapper mapper = new ObjectMapper();
            String format = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(json);

            writer.write(format);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String createStationsJson() {
        try {
            PrintWriter writer = new PrintWriter(PATH_STATIONS_JSON);

            JSONArray array = new JSONArray();

            for (int i = 0; i < station.size(); i++) {
                LinkedHashMap<String, String> item = new LinkedHashMap<>();
                item.put("name", station.get(i).getName());
                for (int j = 0; j < line.size(); j++) {
                    if (line.get(j).getNumber().equals(station.get(i).getLineNumber())) {
                        item.put("line", line.get(j).getName().trim());
                        break;
                    }
                }
                if (stationMapOfDate.containsKey(station.get(i).getName())) {
                    item.put("date", stationMapOfDate.get(station.get(i).getName()));
                }
                if (stationMapOfDepth.containsKey(station.get(i).getName())) {
                    item.put("depth", stationMapOfDepth.get(station.get(i).getName()));
                }
                if (hasConnection.contains(station.get(i).getName())) {
                    item.put("hasConnection", "true");
                } else {
                    item.put("hasConnection", "false");
                }
                array.add(item);
            }

            JSONObject json = new JSONObject();
            json.put("stations", array);

            ObjectMapper mapper = new ObjectMapper();
            String format = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(mapper.readTree(String.valueOf(json)));

            writer.write(format);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public void parseJsonFile(String path) {
        JSONParser parser = new JSONParser();
        try {
            JSONArray jsonArray = (JSONArray) parser.parse(parseFile(path));
            for (Object object : jsonArray) {
                JSONObject jsonObject = (JSONObject) object;
                String name = (String) jsonObject.get(TAG_NAME);
                String station_name = (String) jsonObject.get(TAG_STATION_NAME);
                String date = (String) jsonObject.get(TAG_DATE);
                String depth = String.valueOf(jsonObject.get(TAG_DEPTH));
                String depth_meters = String.valueOf(jsonObject.get(TAG_DEPTH_METERS));

                if (path.contains("dates-2.json")) {
                    stationMapOfDate.put(name, date);
                } else if (path.contains("depths-1.json")) {
                    stationMapOfDepth.put(name, depth);
                } else if (path.contains("depths-3.json")) {
                    stationMapOfDepth.put(station_name, depth_meters);
                }
            }
        } catch (Exception e) {
            System.out.println("Parsing error " + e);
        }
    }

    public void parseCsvFile(String path) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            for (String line : lines) {
                String[] fragments = line.split(",");
                String regexDate = "[0-9]{2}[\\.][0-9]{2}[\\.][0-9]{4}";
                if (path.contains("dates-1.csv") || path.contains("dates-3.csv")) {
                    if (fragments.length != 2) {
                        System.out.println("Неверное количество фрагментов: " + line);
                        continue;
                    }
                    while (fragments[1].matches(regexDate)) {
                        stationMapOfDate.put(fragments[0], fragments[1]);
                        break;
                    }
                } else {
                    stationMapOfDepth.put(fragments[0], fragments[1]);
                }
            }
        } catch (Exception e) {
            System.out.println("Parsing error " + e);
        }
    }
}
