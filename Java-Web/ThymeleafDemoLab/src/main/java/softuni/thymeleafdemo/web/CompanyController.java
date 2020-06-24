package softuni.thymeleafdemo.web;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.thymeleafdemo.model.binding.CompanyAddBindingModel;
import softuni.thymeleafdemo.model.service.CompanyServiceModel;
import softuni.thymeleafdemo.model.view.CompanyViewModel;
import softuni.thymeleafdemo.service.CompanyService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;
    private final ModelMapper modelMapper;

    @Autowired
    public CompanyController(CompanyService companyService, ModelMapper modelMapper) {
        this.companyService = companyService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/add")
    public ModelAndView add(@Valid @ModelAttribute("companyAddBindingModel") CompanyAddBindingModel companyAddBindingModel,
                            BindingResult bindingResult,
                            ModelAndView modelAndView) {

        modelAndView.setViewName("company-add");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addConfirm(@Valid @ModelAttribute("companyAddBindingModel") CompanyAddBindingModel companyAddBindingModel,
                                   BindingResult bindingResult,
                                   ModelAndView modelAndView, HttpSession httpSession,
                                   RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("companyAddBindingModel", companyAddBindingModel);

            modelAndView.setViewName("redirect:add");
        } else {
            httpSession.setAttribute("lastUpdatedDB", new Date());

            this.companyService.addCompany(this.modelMapper.map(companyAddBindingModel, CompanyServiceModel.class));

            modelAndView.setViewName("redirect:all");
        }


        return modelAndView;
    }

    @GetMapping("/all")
    public ModelAndView all(ModelAndView modelAndView) {

        modelAndView.addObject("companies", this.companyService.getAll());

        modelAndView.setViewName("company-all");
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView details(@PathVariable("id") Long id, ModelAndView modelAndView) {

        modelAndView.addObject("company", this.companyService.getById(id));
        modelAndView.setViewName("company-details");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {

        this.companyService.deleteById(id);
        return "redirect:all";
    }


}
