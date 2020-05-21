package softuni.workshop.service.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.workshop.data.dtos.ProjectRootDto;
import softuni.workshop.data.entities.Project;
import softuni.workshop.data.repositories.ProjectRepository;
import softuni.workshop.service.services.CompanyService;
import softuni.workshop.service.services.ProjectService;
import softuni.workshop.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final CompanyService companyService;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, CompanyService companyService, ModelMapper modelMapper, XmlParser xmlParser) {
        this.projectRepository = projectRepository;
        this.companyService = companyService;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public void importProjects() throws JAXBException, FileNotFoundException {
        ProjectRootDto projectRootDto =
                this.xmlParser
                        .unmarshalFromFile("src/main/resources/files/xmls/projects.xml",ProjectRootDto.class);

        projectRootDto.getProjects()
                .forEach(p -> {
                    Project project = this.modelMapper.map(p,Project.class);

                    project.setCompany(this.companyService.getByName(p.getCompany().getName()));

                    this.projectRepository.saveAndFlush(project);
                });
    }

    @Override
    public boolean areImported() {
       return this.projectRepository.count() > 0;
    }

    @Override
    public String readProjectsXmlFile() throws IOException {
        StringBuilder sb = new StringBuilder();
        Files.readAllLines(Path.of("src/main/resources/files/xmls/projects.xml"))
                .forEach(l -> {
                    sb.append(l)
                            .append(System.lineSeparator());
                });
        return sb.toString();
    }

    @Override
    public String exportFinishedProjects(){
        StringBuilder sb = new StringBuilder();

        this.projectRepository.findAllByFinishedTrue()
                .forEach(p -> {
                    sb.append(String.format("Project Name: %s\n" +
                            "   Description: %s\n" +
                            "   %.2f\n",
                            p.getName(),
                            p.getDescription(),
                            p.getPayment()));
                });
        return sb.toString();
    }

    @Override
    public Project getByName(String name) {
        return this.projectRepository.findByName(name);
    }
}
