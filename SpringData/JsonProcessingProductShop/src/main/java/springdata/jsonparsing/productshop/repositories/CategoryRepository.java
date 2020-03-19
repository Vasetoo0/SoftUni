package springdata.jsonparsing.productshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springdata.jsonparsing.productshop.models.entitites.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    Category findByName(String name);
}
