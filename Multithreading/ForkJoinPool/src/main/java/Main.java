import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashSet;
import java.util.concurrent.ForkJoinPool;

public class Main {

    private static final String URL_ADDRESS = "https://skillbox.ru/";
    private static final String PATH_LINKS = "data/links.txt";


    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Начало парсинга: " + new Date());
        PrintWriter writer = new PrintWriter(PATH_LINKS);
        HashSet<String> urls = new ForkJoinPool().invoke(new MyFork(URL_ADDRESS));
        for (String links : urls) {
            writer.write(links);
        }
        writer.flush();
        writer.close();
//        ForkJoinPool pool = new ForkJoinPool();
//        pool.invoke(new MyFork(URL_ADDRESS));
        System.out.println("Конец парсинга: " + new Date());
    }
}


