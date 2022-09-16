import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Main {

    public static String pathHtml = "data/code.html";
    public static String pathJsonAndCsv = "archive/data/data/";
    public static String pathMapSpb = "data/mapSpb.json";

    public static void main(String[] args) {
        System.out.println(getLines());
        System.out.println(getStations());
        System.out.println(getJsonFileFromAllFolders());
        System.out.println(getCsvFileFromAllFolders());
        System.out.println(writeJsonFile());
    }

    public static String parseFile(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line -> builder.append(line + "\n"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder.toString();
    }


    private static Elements getLines() {
        String htmlFile = parseFile(pathHtml);
        Document doc = Jsoup.parse(htmlFile);
        System.out.println("Список линий московского метро:" + "\n");
        Elements lines = doc.select(".js-metro-line");
        lines.forEach(line -> {
            System.out.println(line.attr("data-line") + " " + line.text());
        });
        return new Elements();
    }

    private static Elements getStations() {
        String htmlFile = parseFile(pathHtml);
        Document doc = Jsoup.parse(htmlFile);
        System.out.println("Список станций московского метро:" + "\n");
        Elements stations = doc.select(".js-metro-stations");
        stations.forEach(element -> {
            System.out.println(element.attr("data-line") + " линия:" + " " + element.text());
        });
        return new Elements();
    }

    private static String getJsonFileFromAllFolders() {
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

    private static String getCsvFileFromAllFolders() {
        StringBuilder builder = new StringBuilder();
        try {
            Files.walk(Paths.get(pathJsonAndCsv), FileVisitOption.FOLLOW_LINKS)
                    .forEach(file -> {
                        if (file.toFile().isFile() && file.toFile().getPath().endsWith(".csv")) {
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
            List<String> pathMetroSpb = Files.readAllLines(Paths.get("C:/Users/Asus/.ssh/java_basics/ExceptionsDebuggingAndTesting/homework_2/SPBMetro/src/main/resources/map.json"));
            Files.write(Paths.get(pathMapSpb), (pathMetroSpb));
            List<String> lines = Files.readAllLines(Paths.get(pathMapSpb));
            for (int i = 0; i < lines.size(); i++) {
                System.out.println(lines.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
