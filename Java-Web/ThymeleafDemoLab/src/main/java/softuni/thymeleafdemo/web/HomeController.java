package softuni.thymeleafdemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Date;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView, HttpSession httpSession) {

        if (httpSession.getAttribute("lastUpdatedDB") == null) {
            httpSession.setAttribute("lastUpdatedDB", "Not updated yet :)");
        }
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
