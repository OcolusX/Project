import java.util.Arrays;
import java.util.Optional;

public class Bookshelf {

    private Book[] books;
    private int capacity;
    private int size;

    public Bookshelf(int capacity) {
        this.capacity = capacity;
        books = new Book[capacity];
        size = 0;
    }

    public void add(Book book) {
        if(size < capacity) {
            books[size++] = book;
        }
    }

    public void sort() {
        Arrays.sort(books);
    }

    public Book getNewestBook() {
        return Arrays.stream(books).max(Book::compareTo).orElse(null);
    }

    public Book getOldestBook() {
        return Arrays.stream(books).min(Book::compareTo).orElse(null);
    }

    public void print() {
        System.out.println("Книжная полка (кол-во книг: " + size + "/" + capacity + ")");
        for(int i = 0; i < size; i++) {
            System.out.println("\t" + (i + 1) + ": " + books[i]);
        }
    }
}
