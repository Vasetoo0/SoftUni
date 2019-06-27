package Advanced.IteratorsAndComparators.Lab;

import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.title = title;
        this.year = year;
        this.authors = Arrays.asList(authors);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Book book) {

        if(this.title.compareTo(book.getTitle()) == 0) {
            return this.year - book.getYear();
        }
        return this.title.compareTo(book.getTitle());
    }

    @Override
    public String toString() {
        return this.getTitle();
    }
}
