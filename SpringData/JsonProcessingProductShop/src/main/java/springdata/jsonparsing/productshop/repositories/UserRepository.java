package springdata.jsonparsing.productshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import springdata.jsonparsing.productshop.models.entitites.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByFirstNameAndLastName(String firstName,String lastName);

//    @Query("select u from User as u join u.productsSold as p " +
//            "where p.buyer is not null " +
//            "order by u.lastName, u.firstName")
//    List<User> findAllHavingProductsSold();
}
