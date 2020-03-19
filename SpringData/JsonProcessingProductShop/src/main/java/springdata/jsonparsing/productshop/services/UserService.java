package springdata.jsonparsing.productshop.services;

import org.springframework.stereotype.Service;
import springdata.jsonparsing.productshop.models.dtos.userDtos.UserCountDto;
import springdata.jsonparsing.productshop.models.dtos.userDtos.UserSeedDto;
import springdata.jsonparsing.productshop.models.dtos.userDtos.UserSoldItemsDto;
import springdata.jsonparsing.productshop.models.entitites.User;

import java.util.List;

@Service
public interface UserService {

    void seedUsers(UserSeedDto[] userSeedDtos);

    User getRandomUser();

    List<UserSoldItemsDto> getAllWithSoldItems();

    UserCountDto getAllCountWithProductsSold();
}
