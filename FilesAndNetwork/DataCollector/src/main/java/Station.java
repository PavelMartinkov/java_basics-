import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class Station {

    public String name;
    public List<Line> line;
    private static String pathHtml = "data/code.html";

    public Station(String name, List<Line> line) {
        this.name = name;
        this.line = line;
    }

    public Station() {
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
            stationsName.add(new Station(element.attr("data-line") + " " + element.text(), Line.getLinesFromHtml()));
        });
        return stationsName;
    }

    @Override
    public String toString() {
        return '\n' + name;
    }
}
