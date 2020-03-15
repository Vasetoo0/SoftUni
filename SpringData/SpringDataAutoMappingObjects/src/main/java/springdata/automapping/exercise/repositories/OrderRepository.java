package springdata.automapping.exercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springdata.automapping.exercise.domain.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
