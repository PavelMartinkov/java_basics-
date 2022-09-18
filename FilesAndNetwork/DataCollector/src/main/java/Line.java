import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class Line {

    public String number;
    public String name;
    public static List<Station> station = new ArrayList<>();

    private static String pathHtml = "data/code.html";

    public Line(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public List<Station> getStation() {
        return station;
    }

    public static List<Line> getLinesFromHtml() {
        String htmlFile = Main.parseFile(pathHtml);
        Document doc = Jsoup.parse(htmlFile);
        List<Line> linesName = new ArrayList<>();
        Elements lines = doc.select(".js-metro-line");
        lines.forEach(line -> {
            linesName.add(new Line(line.attr("data-line="),line.text()));
        });
        return linesName;
    }
}
