package softuni.workshop.data.repositories;

import com.sun.xml.bind.v2.TODO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.workshop.data.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);

}
