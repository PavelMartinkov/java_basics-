public class Main {

    public static void main(String[] args) {
        System.out.println(ParseHtml.getLines());
        System.out.println(ParseHtml.getStations());
        System.out.println(JsonUtils.getJsonFileFromAllFolders());
        System.out.println(CsvUtils.getCsvFileFromAllFolders());
        System.out.println(JsonUtils.writeJsonFile());
        System.out.println(JsonUtils.createStationsJson());
    }
}
