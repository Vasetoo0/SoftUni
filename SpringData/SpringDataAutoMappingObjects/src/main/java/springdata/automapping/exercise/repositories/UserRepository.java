package springdata.automapping.exercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springdata.automapping.exercise.domain.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findUserByEmailAndPassword(String email,String password);
}
