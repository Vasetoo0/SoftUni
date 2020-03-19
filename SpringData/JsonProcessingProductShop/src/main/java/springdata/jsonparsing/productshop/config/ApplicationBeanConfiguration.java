package springdata.jsonparsing.productshop.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springdata.jsonparsing.productshop.utils.FileUtil;
import springdata.jsonparsing.productshop.utils.FileUtilImpl;
import springdata.jsonparsing.productshop.utils.ValidationUtil;
import springdata.jsonparsing.productshop.utils.ValidationUtilImpl;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public Gson gson(){
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public ValidationUtil validationUtil(){
        return new ValidationUtilImpl();
    }

    @Bean
    public FileUtil fileUtil(){
        return new FileUtilImpl();
    }

}
