package softuni.workshop.service.services.impl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.workshop.data.dtos.CompanyRootDto;
import softuni.workshop.data.entities.Company;
import softuni.workshop.data.repositories.CompanyRepository;
import softuni.workshop.service.services.CompanyService;
import softuni.workshop.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository, ModelMapper modelMapper, XmlParser xmlParser) {
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public void importCompanies() throws JAXBException, FileNotFoundException {
        CompanyRootDto companyRootDto = this.xmlParser
                        .unmarshalFromFile("src/main/resources/files/xmls/companies.xml", CompanyRootDto.class);

        companyRootDto.getCompanies().forEach(c -> {
            this.companyRepository.saveAndFlush(this.modelMapper.map(c, Company.class));
        });
    }

    @Override
    public boolean areImported() {
        return this.companyRepository.count() > 0;
    }

    @Override
    public String readCompaniesXmlFile() throws IOException {
        StringBuilder sb = new StringBuilder();
        Files.readAllLines(Path.of("src/main/resources/files/xmls/companies.xml"))
                .forEach(l -> {
                    sb.append(l)
                            .append(System.lineSeparator());
                });
        return sb.toString();
    }

    @Override
    public Company getByName(String name) {
        return this.companyRepository.findByName(name);
    }
}
