package springdata.automapping.exercise.services;

import org.springframework.stereotype.Service;
import springdata.automapping.exercise.domain.dtos.orderDtos.CurrOrderDto;
import springdata.automapping.exercise.domain.dtos.userDtos.UserLoginDto;
import springdata.automapping.exercise.domain.dtos.userDtos.UserRegisterDto;
import springdata.automapping.exercise.domain.entities.Game;
import springdata.automapping.exercise.domain.entities.Order;

import java.util.Set;

@Service
public interface UserService {

    void registerUser(UserRegisterDto userRegisterDto);

    void loginUser(UserLoginDto userLoginDto);

    void logout();

    boolean isUserLoggedIn();

    boolean isLoggedUserAdmin();

    void addGamesToUser(Set<Game> games);

    void addOrderToUser(Order order);

    void viewAllCurrUserGames();
}
