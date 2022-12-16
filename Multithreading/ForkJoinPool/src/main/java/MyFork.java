import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RecursiveTask;

public class MyFork extends RecursiveTask<HashSet<String>> {

    private String urlSite;
    private static Set<String> linksSet = ConcurrentHashMap.newKeySet();

    public MyFork(String urlSite) {
        this.urlSite = urlSite;
    }

    public String getUrlSite() {
        return urlSite;
    }

    public void setUrlSite(String urlSite) {
        this.urlSite = urlSite;
    }

    public Set<String> getLinksSet() {
        return linksSet;
    }

    public void setLinksSet(Set<String> linksSet) {
        this.linksSet = linksSet;
    }

    @Override
    protected HashSet<String> compute() {
        HashSet<MyFork> uniqueLinks = new HashSet<>();
        HashSet<String> stringLink = new HashSet<>();
        try {
            Thread.sleep(150);
            Document document = Jsoup.connect(urlSite).get();
            Elements elements = document.select("a[href]");
            for (Element element : elements) {
                String link = element.attr("abs:href");
                if (link.endsWith(".pdf") || link.endsWith(".jpg") || link.endsWith(".png")) {
                    continue;
                }
                if (!link.contains("#") && !linksSet.contains(link) && link.contains(urlSite)) {
                    linksSet.add(link);
                    System.out.println(link);
                } else {
                    if (!link.contains("tel:") && link.startsWith("http://skillbox.ru") || link.startsWith("https://skillbox.ru")) {
                        MyFork myFork = new MyFork(link);
                        myFork.fork();
                        uniqueLinks.add(myFork);
                    }
                }
            }
            for (MyFork myFork : uniqueLinks) {
                stringLink.addAll(myFork.join());
            }
//            uniqueLinks.forEach(ForkJoinTask::join);
        } catch (Exception ex) {
//            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        return stringLink;
    }
}
