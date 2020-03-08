package springdataintro.exercise.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdataintro.exercise.constants.GlobalConstants;
import springdataintro.exercise.entities.Category;
import springdataintro.exercise.repositories.CategoryRepository;
import springdataintro.exercise.services.interfaces.CategoryService;
import springdataintro.exercise.utils.FileUtil;

import java.io.IOException;

import static springdataintro.exercise.constants.GlobalConstants.CATEGORY_FILE_PATH;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final FileUtil fileUtil;
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(FileUtil fileUtil, CategoryRepository categoryRepository) {
        this.fileUtil = fileUtil;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategories() throws IOException {
        String[] categories = fileUtil.readFileContent(CATEGORY_FILE_PATH);

        for (String category : categories) {

            if (categoryNotExist(category)) {
                this.categoryRepository.saveAndFlush(new Category(category));
            }
        }
    }

    @Override
    public int getAllCategoriesCount() {
        return (int) this.categoryRepository.count();
    }

    @Override
    public Category getCategoryById(Long id) {
        return this.categoryRepository.getOne(id);
    }

    private boolean categoryNotExist(String cat) {
        return this.categoryRepository.findByName(cat) == null;
    }
}
