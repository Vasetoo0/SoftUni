package softuni.thymeleafdemo.service;

import softuni.thymeleafdemo.model.service.CompanyServiceModel;

import java.util.List;

public interface CompanyService {

    void addCompany(CompanyServiceModel companyServiceModel);

    List<CompanyServiceModel> getAll();

    CompanyServiceModel getById(Long id);

    List<String> getAllNames();

    CompanyServiceModel getByName(String company);

    void deleteById(Long id);
}
