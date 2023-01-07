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
            String oneTab = "\t";
            String twoTab = "\t\t";
            String threeTab = "\t\t\t";
            String fourTab = "\t\t\t\t";
            long count = links.chars().filter(ch -> ch == '/').count();
            if (count == 4) {
                writer.write(oneTab + links + System.lineSeparator());
            } else if (count == 5) {
                writer.write(twoTab + links + System.lineSeparator());
            } else if (count == 6) {
                writer.write(threeTab + links + System.lineSeparator());
            } else if (count == 7) {
                writer.write(fourTab + links + System.lineSeparator());
            } else {
                writer.write(links + System.lineSeparator());
            }
        }
        writer.flush();
        writer.close();

        System.out.println("Конец парсинга: " + new Date());
    }
}