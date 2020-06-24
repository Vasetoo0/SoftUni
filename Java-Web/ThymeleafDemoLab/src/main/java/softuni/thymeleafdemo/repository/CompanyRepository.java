package softuni.thymeleafdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.thymeleafdemo.model.entity.Company;
import softuni.thymeleafdemo.model.service.CompanyServiceModel;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findByName(String company);

}
