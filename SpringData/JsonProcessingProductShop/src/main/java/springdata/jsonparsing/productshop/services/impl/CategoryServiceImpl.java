package springdata.jsonparsing.productshop.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdata.jsonparsing.productshop.models.dtos.categoryDtos.CategoryProductCountDto;
import springdata.jsonparsing.productshop.models.dtos.categoryDtos.CategorySeedDto;
import springdata.jsonparsing.productshop.models.entitites.Category;
import springdata.jsonparsing.productshop.models.entitites.Product;
import springdata.jsonparsing.productshop.repositories.CategoryRepository;
import springdata.jsonparsing.productshop.services.CategoryService;
import springdata.jsonparsing.productshop.utils.ValidationUtil;

import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.util.*;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedCategories(CategorySeedDto[] categorySeedDtos) {
        Arrays.stream(categorySeedDtos)
                .map(c -> this.modelMapper.map(c, Category.class))
                .forEach(c -> {
                    if(this.categoryRepository.findByName(c.getName()) == null) {
                        if(this.validationUtil.isValid(c)) {
                            this.categoryRepository.saveAndFlush(c);
                        }else  {
                            this.validationUtil.getViolations(c)
                                    .stream()
                                    .map(ConstraintViolation::getMessage)
                                    .forEach(System.out::println);
                        }
                    } else {
//                        System.out.println("Category all ready exist.");
                    }
                });
    }

    @Override
    public Set<Category> getRandomCategories() {
        Random random = new Random();

        List<Category> rndmCategories = new ArrayList<>();

        int rndmCount = random.nextInt(4) + 1;

        for (int i = 0; i < rndmCount; i++) {
            long randomId = random.nextInt((int) this.categoryRepository.count()) + 1;

            rndmCategories.add(this.categoryRepository.getOne(randomId));
        }
        return new HashSet<>(rndmCategories);
    }

    @Override
    public List<CategoryProductCountDto> getAllByProductCount() {
        List<CategoryProductCountDto> categoryProductCountDtos = new ArrayList<>();

        this.categoryRepository.findAll()
                .forEach(c -> {
                    CategoryProductCountDto categoryProductCountDto = new CategoryProductCountDto();

                    categoryProductCountDto.setCategory(c.getName());
                    categoryProductCountDto.setProductsCount(c.getProducts().size());
                    double totalRevenue = c.getProducts()
                            .stream()
                            .mapToDouble(p -> p.getPrice().doubleValue())
                            .sum();
                    double avgPrice = totalRevenue / c.getProducts().size();

                            categoryProductCountDto.setAveragePrice(avgPrice);
                            categoryProductCountDto.setTotalRevenue(totalRevenue);

                            categoryProductCountDtos.add(categoryProductCountDto);
                });


        return categoryProductCountDtos;
    }
}
