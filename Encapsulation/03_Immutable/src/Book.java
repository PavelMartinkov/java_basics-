public class Book {

    private final String name;
    private final String author;
    private final int countPage;
    private final int isbn;

    public Book (String name, String author, int countPage, int isbn) {
        this.name = name;
        this.author = author;
        this.countPage = countPage;
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getCountPage() {
        return countPage;
    }

    public int getIsbn() {
        return isbn;
    }


}
