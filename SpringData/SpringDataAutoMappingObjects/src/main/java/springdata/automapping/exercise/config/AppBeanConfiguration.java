package springdata.automapping.exercise.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springdata.automapping.exercise.utils.ValidationUtil;
import springdata.automapping.exercise.utils.ValidationUtilImpl;

import javax.validation.Validation;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Configuration
public class AppBeanConfiguration {

    @Bean
    public BufferedReader reader(){
        return new BufferedReader(new InputStreamReader(System.in));
    }

    @Bean
    public ValidationUtil validationUtil(){
        return new ValidationUtilImpl();
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }



}
