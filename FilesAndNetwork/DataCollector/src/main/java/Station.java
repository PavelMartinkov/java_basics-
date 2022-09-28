import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class Station {

    public String name;
    public Line line;
    private static String pathHtml = "data/code.html";
    public List<Station> stations = new ArrayList<>();

    public Station(String name) {
        this.name = name;
    }

    public Station() {
    }

    public String getName() {
        return name;
    }

    public Line getLine() {
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

    @Override
    public String toString() {
        return name;
    }

}
