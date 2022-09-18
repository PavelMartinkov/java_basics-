import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.PrintWriter;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class JsonUtils {

    public static String pathJsonAndCsv = "archive/data/data/";
    public static String pathStationsJson = "data/stations.json";
    public static String pathMapJson = "data/map.json";

//    public static List<Station> stations;
//    public static List<Line> lines;

//    public static Station station;
//    public static Line line;

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
            PrintWriter writer = new PrintWriter(pathMapJson);

            JSONArray array = new JSONArray();

            LinkedHashMap<String, List> item = new LinkedHashMap<>();



            for (int i = 0; i < Station.line.size(); i ++) {
                for (int j = 0; j < Line.station.size(); j++) {

                    System.out.println(Line.station.get(j).getLine());
                    System.out.println(Station.line.get(i).getNumber());

                    if (Line.station.get(j).getLine().equals(Station.line.get(i).getNumber())) {
                            array.add(Line.station.get(j).getName());
                        }
//                        item.put(Line.getLinesFromHtml().get(i),Station.getStationsFromHtml());
                    }

                }

//            array.add(item);


//            for (int i = 0; i < Lines.getLinesFromHtml().size(); i++) {
//                for (int j = 0; j < Stations.getStationsFromHtml().size(); j++) {
//                    if(stations.getLines().get(j).equals(lines.getNumber())) {
//                        item.put(String.valueOf(lines.getNumber()), stations.getLines());
////                    item.put(Lines.getLinesFromHtml().get(i), Collections.singletonList(Stations.getStationsFromHtml().get(j)));
//                }
//                    }
//                }
//            array.add(item);


            JSONObject json = new JSONObject();
                json.put("stations", array);


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
}
