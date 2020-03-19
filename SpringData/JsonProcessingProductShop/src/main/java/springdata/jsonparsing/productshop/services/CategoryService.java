package springdata.jsonparsing.productshop.services;


import springdata.jsonparsing.productshop.models.dtos.categoryDtos.CategoryProductCountDto;
import springdata.jsonparsing.productshop.models.dtos.categoryDtos.CategorySeedDto;
import springdata.jsonparsing.productshop.models.entitites.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {

    void seedCategories(CategorySeedDto[] categorySeedDtos);

    Set<Category> getRandomCategories();

    List<CategoryProductCountDto> getAllByProductCount();
}
