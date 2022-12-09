import java.util.Date;
import java.util.concurrent.ForkJoinPool;

public class Main {

    private static final String URL_ADDRESS = "https://skillbox.ru/";
    private static final String PARENT_URL_ADDRESS = "/skillbox.ru/";

    public static void main(String[] args) {
        System.out.println("Начало парсинга: " + new Date());
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new MyFork(URL_ADDRESS, PARENT_URL_ADDRESS));
        System.out.println("Конец парсинга: " + new Date());
    }
}


