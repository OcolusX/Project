import java.util.Date;

public class Book implements Comparable<Book> {

    private String name;
    private String author;
    private int year;
    private String ISBN;

    public Book(String name, String author, int year, String ISBN) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.ISBN = ISBN;
    }

    @Override
    public int compareTo(Book book) {
        return Integer.compare(this.year, book.year);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return author + " \"" + name + "\" " + year + "г. (ISBN: " + ISBN + ");";
    }
}
