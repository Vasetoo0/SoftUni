package springdata.automapping.exercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springdata.automapping.exercise.domain.entities.Game;

@Repository
public interface GameRepository extends JpaRepository<Game,Long> {

    Game findGameByTitle(String title);

    Game findById(long id);
}
