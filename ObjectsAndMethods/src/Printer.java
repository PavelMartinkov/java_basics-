public class Printer {
    private String queue = "";
    private int totalPendingPages  = 0;
    private int totalPrintedPages  = 0;


    public void append (String text) {
        append(text, "Коммуникации");
    }

    public void append (String text, String name) {
        append(text, name, 2);
    }

    public void append (String text, String name, int pages) {
        queue = queue + "\n" + name + ": " + text + " - " + pages + " стр. ";
        totalPendingPages = totalPendingPages + pages;
    }

    public void clear() {
        queue = "";
        totalPendingPages = 0;
    }

    public void print (String title) {
        System.out.println(title);
        if (queue.isEmpty()) {
            System.out.println();
            System.out.println("Документов не обнаружено");
        } else {
            System.out.println(queue);
            totalPrintedPages = totalPrintedPages + totalPendingPages;
            clear();
        }
    }

    public int getPendingPagesCount () {
        return totalPendingPages;
    }

    public int allTimePrintedPages () {
        return totalPrintedPages;
    }
}