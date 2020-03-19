package springdata.jsonparsing.productshop.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdata.jsonparsing.productshop.models.dtos.productDtos.ProductByPriceDto;
import springdata.jsonparsing.productshop.models.dtos.productDtos.ProductSeedDto;
import springdata.jsonparsing.productshop.models.entitites.Product;
import springdata.jsonparsing.productshop.models.entitites.User;
import springdata.jsonparsing.productshop.repositories.ProductRepository;
import springdata.jsonparsing.productshop.services.CategoryService;
import springdata.jsonparsing.productshop.services.ProductService;
import springdata.jsonparsing.productshop.services.UserService;
import springdata.jsonparsing.productshop.utils.ValidationUtil;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final UserService userService;
    private final CategoryService categoryService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, ValidationUtil validationUtil, UserService userService, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedProducts(ProductSeedDto[] productSeedDtos)  {
        Arrays.stream(productSeedDtos)
                .forEach(p -> {
                    Product product = this.modelMapper.map(p, Product.class);

                    User user = this.userService.getRandomUser();

                    product.setSeller(this.userService.getRandomUser());

                    Random random = new Random();

                    if(random.nextInt(2) == 1) {
                        product.setBuyer(this.userService.getRandomUser());
                    }

                    product.setCategories(this.categoryService.getRandomCategories());

                    if(this.productRepository.findByName(product.getName()) == null) {
                        if(this.validationUtil.isValid(product)) {
                            this.productRepository.saveAndFlush(product);
                        }else {
                            this.validationUtil.getViolations(product)
                                    .stream()
                                    .map(ConstraintViolation::getMessage)
                                    .forEach(System.out::println);
                        }
                    } else {
//                        System.out.println("Product all ready exist!");
                    }
                });
    }

    @Override
    public List<ProductByPriceDto> getAllByPriceBetweenAndNoBuyer() {
        List<ProductByPriceDto> productByPriceDtos = new ArrayList<>();

         this.productRepository
                .findAllByPriceBetweenAndBuyerIsNull(new BigDecimal("500"),new BigDecimal("1000"))
                .forEach(p -> {
                    ProductByPriceDto productByPriceDto = this.modelMapper.map(p,ProductByPriceDto.class);

                    productByPriceDto.setSeller(String.format("%s %s",
                            p.getSeller().getFirstName(),
                            p.getSeller().getLastName()));

                    productByPriceDtos.add(productByPriceDto);
                });

         return productByPriceDtos;

    }
}
