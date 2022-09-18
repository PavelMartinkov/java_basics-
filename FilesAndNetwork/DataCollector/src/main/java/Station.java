import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class Station {

    public String name;
    public static List<Line> line = new ArrayList<>();

    private static String pathHtml = "data/code.html";

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Line> getLine() {
        return line;
    }

    public static List<Station> getStationsFromHtml() {
        String htmlFile = Main.parseFile(pathHtml);
        Document doc = Jsoup.parse(htmlFile);
        List<Station> stationsName = new ArrayList<>();
        Elements stations = doc.select(".js-metro-stations");
        stations.forEach(element -> {
            stationsName.add(new Station(element.attr("data-line=") + element.text()));
        });
        return stationsName;
    }
}
