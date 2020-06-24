package softuni.thymeleafdemo.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.thymeleafdemo.model.entity.Company;
import softuni.thymeleafdemo.model.service.CompanyServiceModel;
import softuni.thymeleafdemo.repository.CompanyRepository;
import softuni.thymeleafdemo.service.CompanyService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final ModelMapper modelMapper;
    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(ModelMapper modelMapper, CompanyRepository companyRepository) {
        this.modelMapper = modelMapper;
        this.companyRepository = companyRepository;
    }

    @Override
    public void addCompany(CompanyServiceModel companyServiceModel) {

        Company company = this.modelMapper.map(companyServiceModel, Company.class);

        this.companyRepository.saveAndFlush(company);

    }

    @Override
    public List<CompanyServiceModel> getAll() {
        return this.companyRepository.findAll()
                .stream()
                .map(c -> this.modelMapper.map(c, CompanyServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public CompanyServiceModel getById(Long id) {

        return this.companyRepository.findById(id)
                .map(c -> this.modelMapper.map(c, CompanyServiceModel.class))
                .orElse(null);
    }

    @Override
    public List<String> getAllNames() {
        return this.companyRepository.findAll()
                .stream()
                .map(Company::getName)
                .collect(Collectors.toList());
    }

    @Override
    public CompanyServiceModel getByName(String company) {
        return this.modelMapper.map(this.companyRepository.findByName(company), CompanyServiceModel.class);
    }

    @Override
    public void deleteById(Long id) {
        this.companyRepository.deleteById(id);
    }
}
