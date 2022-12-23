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
                if (!link.contains("#") && !linksSet.contains(link) && !link.contains("tel:")
                        && link.startsWith("https://skillbox.ru/")) {
                    String[] url = link.split("/");
                    if (url.length == 4) {
                        linksSet.add('\t' + link);
                        System.out.println('\t' + link);
                        MyFork myFork = new MyFork('\t' + link);
                        myFork.fork();
                        uniqueLinks.add(myFork);
                    } else if (url.length == 5) {
                        linksSet.add("\t\t" + link);
                        System.out.println("\t\t" + link);
                        MyFork myFork = new MyFork("\t\t" + link);
                        myFork.fork();
                        uniqueLinks.add(myFork);
                    } else if (url.length == 6) {
                        linksSet.add("\t\t\t" + link);
                        System.out.println("\t\t\t" + link);
                        MyFork myFork = new MyFork("\t\t\t" + link);
                        myFork.fork();
                        uniqueLinks.add(myFork);
                    } else {
                        linksSet.add(link);
                        System.out.println(link);
                        MyFork myFork = new MyFork(link);
                        myFork.fork();
                        uniqueLinks.add(myFork);
                    }
                }
            }
            for (MyFork myFork : uniqueLinks) {
                linksSet.addAll(myFork.join());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return new TreeSet<>(linksSet);
    }
}
