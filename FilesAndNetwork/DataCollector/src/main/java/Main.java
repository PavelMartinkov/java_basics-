import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static String parseFile(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line -> builder.append(line + "\n"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите номер действия: " + "\n");
        System.out.println(1 + " Получить список линий");
        System.out.println(2 + " Получить список станций");
        System.out.println(3 + " Найти все json-файлы в папке");
        System.out.println(4 + " Найти все csv-файлы в папке");
        System.out.println(5 + " Создать файл stations.json");
        System.out.println(6 + " Создать файл map.json");
        while (true) {
            int input = scanner.nextInt();
            if (input == 1) {
                System.out.println(Line.getLinesFromHtml());
            } else if (input == 2) {
                System.out.println(Station.getStationsFromHtml());
            } else if (input == 3) {
                System.out.println(JsonUtils.getJsonFileFromAllFolders());
            } else if (input == 4) {
                System.out.println(CsvUtils.getCsvFileFromAllFolders());
            } else if (input == 5) {
                System.out.println(JsonUtils.createStationsJson());
                System.out.println("Файл создан в папке data/stations.json");
            } else if (input == 6) {
//                JsonUtils jsonUtils = new JsonUtils();
//                jsonUtils.createMapJson();
                System.out.println(JsonUtils.createMapJson());
                System.out.println("Файл создан в папке data/map.json");
            } else {
                System.out.println("Введено не верное значение");
                continue;
            }
        }
    }
}


