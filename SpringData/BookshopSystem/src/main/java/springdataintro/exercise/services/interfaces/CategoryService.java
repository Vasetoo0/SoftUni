package springdataintro.exercise.services.interfaces;

import org.springframework.stereotype.Service;
import springdataintro.exercise.entities.Category;

import java.io.IOException;

@Service
public interface CategoryService {

    void seedCategories() throws IOException;

    int getAllCategoriesCount();

    Category getCategoryById(Long id);
}
