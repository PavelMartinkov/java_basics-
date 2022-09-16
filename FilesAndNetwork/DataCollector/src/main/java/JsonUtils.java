import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.PrintWriter;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;

public class JsonUtils {

    public static String pathJsonAndCsv = "archive/data/data/";
    public static String pathFromPreviousProjectMapJson = "C:/Users/Asus/.ssh/java_basics/ExceptionsDebuggingAndTesting/homework_2/SPBMetro/src/main/resources/map.json";
    public static String pathMapSpbJson = "data/mapSpb.json";
    public static String pathStationsJson = "data/stations.json";

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

    public static String writeJsonFile() {
        try {
            List<String> pathMetroSpb = Files.readAllLines(Paths.get(pathFromPreviousProjectMapJson));
            Files.write(Paths.get(pathMapSpbJson), (pathMetroSpb));
            List<String> lines = Files.readAllLines(Paths.get(pathMapSpbJson));
            for (int i = 0; i < lines.size(); i++) {
                System.out.println(lines.get(i));
            }
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
