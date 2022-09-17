import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ParseHtml {

    public static String pathHtml = "data/code.html";

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


    public static List<String> getLines() {
        String htmlFile = parseFile(pathHtml);
        Document doc = Jsoup.parse(htmlFile);
//        System.out.println("Список линий московского метро:" + "\n");
        List<String> linesName = new ArrayList<>();
        Elements lines = doc.select(".js-metro-line");
        lines.forEach(line -> {
            linesName.add(line.attr("data-line=") + line.text());
        });
        return linesName;
    }

    public static List<String> getStations() {
        String htmlFile = parseFile(pathHtml);
        Document doc = Jsoup.parse(htmlFile);
//        System.out.println("Список станций московского метро:" + "\n");
        List<String> stationsName = new ArrayList<>();
        Elements stations = doc.select(".js-metro-stations");
        stations.forEach(element -> {
            stationsName.add(element.attr("data-line=") + element.text());
        });
        return stationsName;
    }
}
