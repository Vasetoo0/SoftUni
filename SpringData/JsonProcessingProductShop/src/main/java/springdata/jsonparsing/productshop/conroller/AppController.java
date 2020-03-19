package springdata.jsonparsing.productshop.conroller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springdata.jsonparsing.productshop.models.dtos.categoryDtos.CategoryProductCountDto;
import springdata.jsonparsing.productshop.models.dtos.categoryDtos.CategorySeedDto;
import springdata.jsonparsing.productshop.models.dtos.productDtos.ProductByPriceDto;
import springdata.jsonparsing.productshop.models.dtos.productDtos.ProductSeedDto;
import springdata.jsonparsing.productshop.models.dtos.userDtos.UserCountDto;
import springdata.jsonparsing.productshop.models.dtos.userDtos.UserProductsSoldDto;
import springdata.jsonparsing.productshop.models.dtos.userDtos.UserSeedDto;
import springdata.jsonparsing.productshop.models.dtos.userDtos.UserSoldItemsDto;
import springdata.jsonparsing.productshop.services.CategoryService;
import springdata.jsonparsing.productshop.services.ProductService;
import springdata.jsonparsing.productshop.services.UserService;
import springdata.jsonparsing.productshop.utils.FileUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import static springdata.jsonparsing.productshop.constants.GlobalConstants.*;

@Component
public class AppController implements CommandLineRunner {

    private final Gson gson;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;
    private final FileUtil fileUtil;

    @Autowired
    public AppController(Gson gson, UserService userService, CategoryService categoryService, ProductService productService, FileUtil fileUtil) {
        this.gson = gson;
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
        this.fileUtil = fileUtil;
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedCategories();
        this.seedUsers();
        this.seedProducts();

        //Query1.
        writeAllProductsInPriceRangeAndNoBuyer();

        //Query2.
        writeAllUsersHavingItemsSold();

        //Query3.
        writeAllCategoriesByProductCount();

        //Query4.
        writeAllUsersCountWithProducts();

    }

    private void writeAllUsersCountWithProducts() throws IOException {
        UserCountDto userCountDto = this.userService.getAllCountWithProductsSold();


        this.fileUtil.write(this.gson.toJson(userCountDto),
                "src/main/resources/files/outputExercises/outputEx4.json");
    }

    private void writeAllCategoriesByProductCount() throws IOException {
        List<CategoryProductCountDto> categoryProductCountDtos = this.categoryService.getAllByProductCount();

        this.fileUtil.write(this.gson.toJson(categoryProductCountDtos),
                "src/main/resources/files/outputExercises/outputEx3.json");
    }

    private void writeAllUsersHavingItemsSold() throws IOException {
        List<UserSoldItemsDto> userSoldItemsDtos = this.userService.getAllWithSoldItems();

        this.fileUtil.write(this.gson.toJson(userSoldItemsDtos),
                "src/main/resources/files/outputExercises/outputEx2.json");
    }

    private void writeAllProductsInPriceRangeAndNoBuyer() throws IOException {
        List<ProductByPriceDto> productByPriceDtos = this.productService.getAllByPriceBetweenAndNoBuyer();

        this.fileUtil.write(this.gson.toJson(productByPriceDtos),
                "src/main/resources/files/outputExercises/outputEx1.json");
    }

    private void seedProducts() throws FileNotFoundException {
        ProductSeedDto[] productSeedDtos = this.gson
                .fromJson(new FileReader(PRODUCTS_FILE_PATH), ProductSeedDto[].class);

        this.productService.seedProducts(productSeedDtos);
    }

    private void seedUsers() throws FileNotFoundException {
        UserSeedDto[] userSeedDtos = this.gson
                .fromJson(new FileReader(USERS_FILE_PATH), UserSeedDto[].class);

        this.userService.seedUsers(userSeedDtos);
    }

    private void seedCategories() throws FileNotFoundException {
        CategorySeedDto[] categorySeedDtos = this.gson
                .fromJson(new FileReader(CATEGORIES_FILE_PATH), CategorySeedDto[].class);

        this.categoryService.seedCategories(categorySeedDtos);
    }
}
