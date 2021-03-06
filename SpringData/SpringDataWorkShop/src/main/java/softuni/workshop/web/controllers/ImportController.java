package softuni.workshop.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.workshop.service.services.CompanyService;
import softuni.workshop.service.services.EmployeeService;
import softuni.workshop.service.services.ProjectService;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
@RequestMapping("import")
public class ImportController extends BaseController {

    private final CompanyService companyService;
    private final EmployeeService employeeService;
    private final ProjectService projectService;

    @Autowired
    public ImportController(CompanyService companyService, EmployeeService employeeService, ProjectService projectService) {
        this.companyService = companyService;
        this.employeeService = employeeService;
        this.projectService = projectService;
    }

    @GetMapping("/xml")
    public ModelAndView xmls() {
        ModelAndView modelAndView = new ModelAndView("xml/import-xml");
        boolean[] areImported = new boolean[] {
                this.companyService.areImported(),
                this.projectService.areImported(),
                this.employeeService.areImported()
        };
        modelAndView.addObject("areImported", areImported);
        return modelAndView;
    }

    @GetMapping("/companies")
    public ModelAndView companies() throws IOException {
        ModelAndView modelAndView = new ModelAndView("xml/import-companies");
        String companies = this.companyService.readCompaniesXmlFile();
        modelAndView.addObject("companies",companies);
        return modelAndView;
    }

    @PostMapping("/companies")
    public ModelAndView importCompanies() throws JAXBException, FileNotFoundException {
        this.companyService.importCompanies();

        return super.redirect("/import/xml");
    }

    @GetMapping("/employees")
    public ModelAndView employees() throws IOException {
        ModelAndView modelAndView = new ModelAndView("xml/import-employees");
        String employees = this.employeeService.readEmployeesXmlFile();
        modelAndView.addObject("employees",employees);
        return modelAndView;
    }

    @PostMapping("/employees")
    public ModelAndView importEmployees() throws JAXBException, FileNotFoundException {
        this.employeeService.importEmployees();

        return super.redirect("/import/xml");
    }

    @GetMapping("/projects")
    public ModelAndView projects() throws IOException {
        ModelAndView modelAndView = new ModelAndView("xml/import-projects");
        String projects = this.projectService.readProjectsXmlFile();
        modelAndView.addObject("projects",projects);
        return modelAndView;
    }

    @PostMapping("/projects")
    public ModelAndView importProjects() throws JAXBException, FileNotFoundException {
        this.projectService.importProjects();

        return super.redirect("/import/xml");
    }

}
