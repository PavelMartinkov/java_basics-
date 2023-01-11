import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;

public class Main {

    private static final String URL_ADDRESS = "https://skillbox.ru/";
    private static final String PATH_LINKS = "data/allLinks.txt";

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Начало парсинга: " + new Date());
        PrintWriter writer = new PrintWriter(PATH_LINKS);
        Set<String> urls = new ForkJoinPool().invoke(new MyFork(URL_ADDRESS));
        for (String links : urls) {
            writer.write(addTab(links) + System.lineSeparator());
        }
        writer.flush();
        writer.close();
        System.out.println("Конец парсинга: " + new Date());
    }

    private static String addTab(String url) {
        String https = "https://";
        String[] links = (url.substring(url.indexOf(https) + 1)).split("/");
        long partsLinks = links.length - 3;
        char tab = '\t';
        StringBuilder builder = new StringBuilder(url);
        for (int i = 0; i < partsLinks; i++) {
            builder.insert(0, tab);
        }
        url = builder.toString();
        return url;
    }
}