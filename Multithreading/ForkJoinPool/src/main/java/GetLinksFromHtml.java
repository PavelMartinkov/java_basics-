//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.select.Elements;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.HashSet;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class GetLinksFromHtml {
//
//    private HashSet<String> linksSet = new HashSet<>();
//    private final String URL = "https://skillbox.ru";
//
//    public static String parseFile(String path) {
//        StringBuilder builder = new StringBuilder();
//        try {
//            List<String> links = Files.readAllLines(Paths.get(path));
//            links.forEach(link -> builder.append(link + "\n"));
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return builder.toString();
//    }
//
//    public void parseHtml(String link) {
//        String htmlFile = parseFile(link);
//        Document document = Jsoup.parse(htmlFile);
//        String regex = "https?:\\/\\/[^,\\s]+";
//        Elements elements = document.select("a[href]");
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(htmlFile);
//        while (matcher.find()) {
//            elements.forEach(element -> {
//                linksSet.add(element.absUrl("href"));
//                System.out.println(element.text("href"));
//            });
//        }
//
//}
