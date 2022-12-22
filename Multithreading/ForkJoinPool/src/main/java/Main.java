import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;

public class Main {

    private static final String URL_ADDRESS = "https://skillbox.ru/";
    private static final String PATH_LINKS = "data/links.txt";


    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Начало парсинга: " + new Date());
        PrintWriter writer = new PrintWriter(PATH_LINKS);
        Set<String> urls = new ForkJoinPool().invoke(new MyFork(URL_ADDRESS));
        for (String links : urls) {
            writer.write(links + System.lineSeparator());
        }
        writer.flush();
        writer.close();

        System.out.println("Конец парсинга: " + new Date());
    }
}


