import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.PrintWriter;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class JsonUtils {

    public static final String pathJsonAndCsv = "archive/data/data/";
    public static final String pathStationsJson = "data/stations.json";
    public static final String pathMapJson = "data/map.json";

    public static String getJsonFileFromAllFolders() {
        StringBuilder builder = new StringBuilder();
        try {
            Files.walk(Paths.get(pathJsonAndCsv), FileVisitOption.FOLLOW_LINKS)
                    .forEach(file -> {
                        if (file.toFile().isFile() && file.toFile().getPath().endsWith(".json")) {
                            System.out.println(file.getFileName());
                            try {
                                List<String> lines = Files.readAllLines(file);
                                for (int i = 0; i < lines.size(); i++) {
                                    builder.append(lines.get(i)).append("\n");
                                }
                                System.out.println(builder);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static String createMapJson() {
        try {
            Line line = new Line();
            Station station = new Station();

            PrintWriter writer = new PrintWriter(pathMapJson);

            JSONArray array = new JSONArray();

            LinkedHashMap<List, List> item = new LinkedHashMap<>();
            item.put(Line.getLinesFromHtml(),Station.getStationsFromHtml());

            for (int i = 0; i < line.lines.size(); i++) {
                for (int j = 0; j < station.stations.size(); j++) {
                    if(station.stations.get(j).getLine().equals(line.lines.get(i).getNumber())) {
                        array.add(station.stations.get(j).getName());
                    }
//                    if (line.lines.get(i).getName().equals(station.stations.get(j).getLine())) {
//                        array.add(line.lines.get(i).getName());
//                    }
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

    public static String createStationsJson() {
        try {
            PrintWriter writer = new PrintWriter(pathStationsJson);

            LinkedHashMap<String, String> item = new LinkedHashMap<>();
            item.put("name", "Название станции");
            item.put("line", "Название линии");
            item.put("date", "Дата открытия в формате 19.01.2005");
            item.put("depth", "Глубина станции в виде числа");
            item.put("hasConnection", "Есть ли станции переход");

            JSONArray array = new JSONArray();
            array.add(item);

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

    public static void parseJsonFile () {
        try {
            JSONParser parser = new JSONParser();

            JSONObject jsonData = (JSONObject) parser.parse(getJsonFileFromAllFolders());

            JSONArray stationsArray = (JSONArray) jsonData.get("stations");
            parseStations(stationsArray);

            JSONObject linesObject = (JSONObject) jsonData.get("lines");
            parseLines(linesObject);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseStations(JSONArray stationsArray) {
        stationsArray.forEach(stationsObject -> {
        JSONObject stationsJsonObject = (JSONObject) stationsObject;
            Map<Object, Object> stationsFromJson = new TreeMap<>();
            stationsFromJson.put(stationsJsonObject.get("station"), stationsJsonObject.get("line"));
        });
    }

    private static void parseLines(JSONObject linesObject) {
       //допишется позже
    }
}
