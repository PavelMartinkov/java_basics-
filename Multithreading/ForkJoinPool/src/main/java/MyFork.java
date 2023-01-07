import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RecursiveTask;

public class MyFork extends RecursiveTask<Set<String>> {

    private String urlSite;
    private static Set<String> linksSet = ConcurrentHashMap.newKeySet();
    private static Set<MyFork> uniqueLinks = ConcurrentHashMap.newKeySet();

    public MyFork(String urlSite) {
        this.urlSite = urlSite;
    }

    @Override
    protected Set<String> compute() {
        try {
            Thread.sleep(150);
            Document document = Jsoup.connect(urlSite).ignoreHttpErrors(true).get();
            Elements elements = document.select("a[href]");
            for (Element element : elements) {
                String link = element.attr("href");
                if (link.endsWith(".pdf") || link.endsWith(".jpg") || link.endsWith(".png")) {
                    continue;
                }
                if (!link.contains("#") && !link.contains("?") && !link.contains("&") && !link.contains("tel:") &&
                        link.startsWith("https://skillbox.ru/") && !linksSet.contains(link)) {
                    linksSet.add(link);
                    System.out.println(link);
                    MyFork myFork = new MyFork(link);
                    myFork.fork();
                    uniqueLinks.add(myFork);
                    linksSet.addAll(myFork.join());
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return new TreeSet<>(linksSet);
    }
}