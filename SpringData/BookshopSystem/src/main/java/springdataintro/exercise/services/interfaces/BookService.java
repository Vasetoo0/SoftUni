package springdataintro.exercise.services.interfaces;

import org.springframework.stereotype.Service;
import springdataintro.exercise.entities.Book;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

@Service
public interface BookService {

    void seedBooks() throws IOException, ParseException;

    List<Book> getAllBooksAfterYear(LocalDate date);

    List<Book> getAllBooksBeforeYear(LocalDate date);

    List<Book> getAllBooksFRomAuthorOrderedByReleaseDate(String name);
}
