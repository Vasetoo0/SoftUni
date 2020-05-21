package softuni.workshop.service.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.workshop.data.dtos.EmployeeRootDto;
import softuni.workshop.data.entities.Employee;
import softuni.workshop.data.repositories.EmployeeRepository;
import softuni.workshop.service.services.EmployeeService;
import softuni.workshop.service.services.ProjectService;
import softuni.workshop.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ProjectService projectService;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ProjectService projectService, ModelMapper modelMapper, XmlParser xmlParser) {
        this.employeeRepository = employeeRepository;
        this.projectService = projectService;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }


    @Override
    public void importEmployees() throws JAXBException, FileNotFoundException {
        EmployeeRootDto employeeRootDto =
                this.xmlParser
                .unmarshalFromFile("src/main/resources/files/xmls/employees.xml",EmployeeRootDto.class);

        employeeRootDto.getEmployees()
                .forEach(e -> {
                    Employee employee = this.modelMapper.map(e,Employee.class);

                    employee.setProject(this.projectService.getByName(e.getProjectDto().getName()));

                    this.employeeRepository.saveAndFlush(employee);
                });
    }

    @Override
    public boolean areImported() {
       return this.employeeRepository.count() > 0;
    }

    @Override
    public String readEmployeesXmlFile() throws IOException {
        StringBuilder sb = new StringBuilder();
        Files.readAllLines(Path.of("src/main/resources/files/xmls/employees.xml"))
                .forEach(l -> {
                    sb.append(l)
                            .append(System.lineSeparator());
                });
        return sb.toString();
    }

    @Override
    public String exportEmployeesWithAgeAbove() {
       StringBuilder sb = new StringBuilder();
       this.employeeRepository.findAllByAgeAfter(25)
               .forEach(e -> {
                   sb.append(String.format("Name: %s %s\n" +
                           "    Age:%d\n" +
                           "    Project name: %s\n",
                           e.getFirstName(),e.getLastName(),
                           e.getAge(),e.getProject().getName()));
               });
        return sb.toString();
    }
}
