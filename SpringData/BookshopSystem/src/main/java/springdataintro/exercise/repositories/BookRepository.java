package springdataintro.exercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import springdataintro.exercise.entities.Book;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findBookById(Long id);

    List<Book> findAllByReleaseDateAfter(LocalDate date);

    List<Book> findAllByReleaseDateBefore(LocalDate date);

    @Query("SELECT b FROM Book AS b WHERE concat(b.author.firstName,' ',b.author.lastName) = :name " +
            "ORDER BY b.releaseDate DESC , b.title ASC")
    List<Book> findAllByAuthorNameOrderedByReleaseDate(String name);

}
