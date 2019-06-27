package Advanced.IteratorsAndComparators.Lab;

import java.util.Iterator;
import java.util.function.Consumer;

public class Library<Book> implements Iterable<Book> {
    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }


    @Override
    public Iterator<Book> iterator() {
        return new LibraryIterator();
    }

    private final class LibraryIterator implements Iterator<Book> {
       private int counter = 0;

        @Override
        public boolean hasNext() {
            return this.counter < books.length;
        }

        @Override
        public Book next() {

            return books[this.counter++];
        }
    }

    @Override
    public void forEach(Consumer<? super Book> action) {

        for (Book book : this) {
            action.accept(book);
        }
    }
}
