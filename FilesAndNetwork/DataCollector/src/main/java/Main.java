import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите номер действия: " + "\n");
        System.out.println(1 + " Найти все json-файлы в папке");
        System.out.println(2 + " Найти все csv-файлы в папке");
        System.out.println(3 + " Создать файл stations.json");
        System.out.println(4 + " Создать файл map.json");
        while (true) {
            int input = scanner.nextInt();
            if (input == 1) {
                System.out.println(GetJsonAndCsvFiles.getJsonFileFromAllFolders());
            } else if (input == 2) {
                System.out.println(GetJsonAndCsvFiles.getCsvFileFromAllFolders());
            } else if (input == 3) {
                Parsing parsing = new Parsing();
                parsing.parseHtml("data/code.html");
                parsing.parseJsonFile("jsonFiles/dates-2.json");
                parsing.parseJsonFile("jsonFiles/depths-1.json");
                parsing.parseJsonFile("jsonFiles/depths-3.json");
                parsing.parseCsvFile("csvFiles/dates-1.csv");
                parsing.parseCsvFile("csvFiles/dates-3.csv");
                parsing.parseCsvFile("csvFiles/depths-2.csv");
                System.out.println(parsing.createStationsJson());
                System.out.println("Файл создан в папке data/stations.json");
            } else if (input == 4) {
                Parsing parsing = new Parsing();
                parsing.parseHtml("data/code.html");
                System.out.println(parsing.createMapJson());
                System.out.println("Файл создан в папке data/map.json");
            } else {
                System.out.println("Введено не верное значение");
            }
        }
    }
}


