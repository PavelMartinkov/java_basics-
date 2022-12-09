import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.concurrent.RecursiveTask;

public class MyFork extends RecursiveTask<HashSet<MyFork>> {

    private String urlSite;
    private String urlParent;
    private HashSet<String> linksSet = new HashSet<>();

    private static final String PATH_LINKS = "data/links.txt";

    public MyFork(String urlSite, String parentUrl) {
        this.urlSite = urlSite;
        this.urlParent = parentUrl;
    }

    @Override
    protected HashSet<MyFork> compute() {
        HashSet<MyFork> uniqueLinks = new HashSet<>();
        try {
            PrintWriter writer = new PrintWriter(PATH_LINKS);
            Thread.sleep(150);
            Document document = Jsoup.connect(urlSite).ignoreHttpErrors(true).get();
            Elements elements = document.select("a[href]");
            if (!elements.isEmpty()) {
                for (Element element : elements) {
                    String link = element.attr("abs:href");
                    if (!link.contains("#") && !linksSet.contains(link) && link.contains(urlParent)) {
                        linksSet.add(link);
                        System.out.println(link);
//                        writer.write(link);
                    } else {
                        MyFork myFork = new MyFork(urlSite, urlParent);
                        myFork.fork();
                        uniqueLinks.add(myFork);
                        writer.write(link);
                        myFork.join();
                    }
                }
            }
            writer.flush();
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return uniqueLinks;
    }
}
