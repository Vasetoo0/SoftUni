package springdataintro.exercise.services.interfaces;

import org.springframework.stereotype.Service;
import springdataintro.exercise.entities.Author;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
public interface AuthorService {

    void seedAuthors() throws IOException;

    int getAllAuthorsCount();

    Author getAuthorById(long id);

    List<Author> getAllAuthorsOrderedByBookCount();

}
