public class Main3 {

    public static void main(String[] args) {
        Printer pavel = new Printer();
        pavel.append("Привет, как дела?");
        pavel.append("Что нового?", "Коммуникации");
        pavel.append("Что делаешь?", "Коммуникации", 15);
        pavel.print("Документы:");
        int totalPendingPages = pavel.getPendingPagesCount();
        System.out.println("Количество ожидаемых страниц: " + totalPendingPages);
        pavel.clear();
        System.out.println();
        pavel.print("Документы:");
        totalPendingPages = pavel.getPendingPagesCount();
        System.out.println("Количество ожидаемых страниц: " + totalPendingPages);
        int totalPrintedPages = pavel.allTimePrintedPages();
        System.out.println("Суммарное количество распечатанных страниц за все время: " + totalPrintedPages);
    }
}
