package springdata.jsonparsing.productshop.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springdata.jsonparsing.productshop.models.dtos.productDtos.ProductCountDto;
import springdata.jsonparsing.productshop.models.dtos.productDtos.ProductNamePriceDto;
import springdata.jsonparsing.productshop.models.dtos.productDtos.ProductSoldDto;
import springdata.jsonparsing.productshop.models.dtos.userDtos.UserCountDto;
import springdata.jsonparsing.productshop.models.dtos.userDtos.UserProductsSoldDto;
import springdata.jsonparsing.productshop.models.dtos.userDtos.UserSeedDto;
import springdata.jsonparsing.productshop.models.dtos.userDtos.UserSoldItemsDto;
import springdata.jsonparsing.productshop.models.entitites.Product;
import springdata.jsonparsing.productshop.models.entitites.User;
import springdata.jsonparsing.productshop.repositories.UserRepository;
import springdata.jsonparsing.productshop.services.UserService;
import springdata.jsonparsing.productshop.utils.ValidationUtil;

import javax.validation.ConstraintViolation;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedUsers(UserSeedDto[] userSeedDtos) {
        Arrays.stream(userSeedDtos)
                .map(u -> this.modelMapper.map(u, User.class))
                .forEach(u -> {
                    if (this.userRepository
                            .findByFirstNameAndLastName(u.getFirstName(), u.getLastName()) == null) {

                        if (this.validationUtil.isValid(u)) {
                            this.userRepository.saveAndFlush(u);
                        } else {
                            this.validationUtil.getViolations(u)
                                    .stream()
                                    .map(ConstraintViolation::getMessage)
                                    .forEach(System.out::println);
                        }
                    } else {
//                        System.out.println("User already exist.");
                    }
                });
    }

    @Override
    public User getRandomUser() {
        Random random = new Random();

        long randomId = random.nextInt((int) this.userRepository.count()) + 1;

        return this.userRepository.getOne(randomId);
    }

    @Override
    public List<UserSoldItemsDto> getAllWithSoldItems() {
        List<UserSoldItemsDto> userSoldItemsDtos = new ArrayList<>();
        this.userRepository.findAll()
                .forEach(u -> {
                    Set<ProductSoldDto> productSoldDtos = u.getProductsSold().stream()
                            .filter(p -> p.getBuyer() != null)
                            .map(p -> this.modelMapper.map(p, ProductSoldDto.class))
                            .collect(Collectors.toSet());


                    UserSoldItemsDto userSoldItemsDto = this.modelMapper
                            .map(u, UserSoldItemsDto.class);

                    userSoldItemsDto
                            .setSoldProducts(productSoldDtos);

                    if (userSoldItemsDto.getSoldProducts().size() > 0) {
                        userSoldItemsDtos.add(userSoldItemsDto);
                    }
                });

        return userSoldItemsDtos
                .stream()
                .sorted(Comparator.comparing(UserSoldItemsDto::getLastName))
                .collect(Collectors.toList());
    }

    @Override
    public UserCountDto getAllCountWithProductsSold() {
        UserCountDto userCountDto = new UserCountDto();

        Set<UserProductsSoldDto> userProductsSoldDtos = new HashSet<>();

        this.userRepository.findAll()
                .forEach(u -> {
                    if(checkIfUserHaveSoldProducts(u)) {

                        Set<ProductNamePriceDto> productNamePriceDtos = new HashSet<>();

                        u.getProductsSold()
                                .forEach(p -> {
                                    if (p.getBuyer() != null) {
                                        ProductNamePriceDto productNamePriceDto = this.modelMapper
                                                .map(p, ProductNamePriceDto.class);

                                        productNamePriceDtos.add(productNamePriceDto);
                                    }

                                });

                        ProductCountDto productCountDto = new ProductCountDto();
                        productCountDto.setCount((int) u.getProductsSold()
                                .stream()
                                .filter(p -> p.getBuyer() != null)
                                .count());

                        productCountDto.setProducts(productNamePriceDtos);

                        UserProductsSoldDto userProductsSoldDto = this.modelMapper.map(u, UserProductsSoldDto.class);

                        userProductsSoldDto.setSoldProducts(productCountDto);

                        userProductsSoldDtos.add(userProductsSoldDto);
                    }
                });
        userCountDto.setUsersCount(userProductsSoldDtos.size());
        userCountDto.setUsers(userProductsSoldDtos);

        return userCountDto;
    }

    private boolean checkIfUserHaveSoldProducts(User u) {
        boolean haveSoldProduct = false;
        for (Product product : u.getProductsSold()) {
            if(product.getBuyer() != null) {
                haveSoldProduct = true;
                break;
            }
        }
        return haveSoldProduct;
    }
}
