package softuni.thymeleafdemo.web;

import org.dom4j.rule.Mode;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.thymeleafdemo.model.binding.EmployeeAddBindingModel;
import softuni.thymeleafdemo.model.service.EmployeeServiceModel;
import softuni.thymeleafdemo.service.CompanyService;
import softuni.thymeleafdemo.service.EmployeeService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final ModelMapper modelMapper;
    private final CompanyService companyService;
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(ModelMapper modelMapper, CompanyService companyService, EmployeeService employeeService) {
        this.modelMapper = modelMapper;
        this.companyService = companyService;
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public ModelAndView add(@Valid @ModelAttribute("employeeAddBindingModel") EmployeeAddBindingModel employeeAddBindingModel,
                            BindingResult bindingResult,
                            ModelAndView modelAndView) {

        modelAndView.addObject("companies", this.companyService.getAllNames());
        modelAndView.setViewName("employee-add");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addConfirm(@Valid @ModelAttribute("employeeAddBindingModel") EmployeeAddBindingModel employeeAddBindingModel,
                                   BindingResult bindingResult,
                                   ModelAndView modelAndView, HttpSession httpSession,
                                   RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("employeeAddBindingModel", employeeAddBindingModel);

            modelAndView.setViewName("redirect:add");
        } else {

            EmployeeServiceModel employee = this.modelMapper.map(employeeAddBindingModel, EmployeeServiceModel.class);

            employee.setCompany(this.companyService.getByName(employeeAddBindingModel.getCompany()));

            this.employeeService.addEmployee(employee);

            httpSession.setAttribute("lastUpdatedDB", new Date());

            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }

    @GetMapping("/all")
    public ModelAndView all(ModelAndView modelAndView) {

        modelAndView.addObject("employees", this.employeeService.getAll());

        modelAndView.setViewName("employee-all");
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView all(@PathVariable("id") Long id, ModelAndView modelAndView) {

        modelAndView.addObject("employee", this.employeeService.getById(id));

        modelAndView.setViewName("employee-details");
        return modelAndView;
    }

    @Transactional
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id, ModelAndView modelAndView) {
        this.employeeService.deleteById(id);

        modelAndView.setViewName("redirect:all");
        return modelAndView;
    }


}
