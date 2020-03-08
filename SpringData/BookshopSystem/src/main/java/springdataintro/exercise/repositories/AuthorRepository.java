package springdataintro.exercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import springdataintro.exercise.entities.Author;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

    Author findByLastName(String lastName);

    @Query("SELECT a FROM Author AS a ORDER BY a.books.size DESC")
    List<Author> findAllAuthorsOrderByBooksCounts();

}
