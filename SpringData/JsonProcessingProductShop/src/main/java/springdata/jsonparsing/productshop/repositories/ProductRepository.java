package springdata.jsonparsing.productshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import springdata.jsonparsing.productshop.models.dtos.categoryDtos.CategoryProductCountDto;
import springdata.jsonparsing.productshop.models.entitites.Product;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Product findByName(String name);

    List<Product> findAllByPriceBetweenAndBuyerIsNull(BigDecimal minRange,BigDecimal maxRange);
}
