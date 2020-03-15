package springdata.automapping.exercise.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdata.automapping.exercise.domain.dtos.orderDtos.CurrOrderDto;
import springdata.automapping.exercise.domain.dtos.userDtos.UserDto;
import springdata.automapping.exercise.domain.dtos.userDtos.UserLoginDto;
import springdata.automapping.exercise.domain.dtos.userDtos.UserRegisterDto;
import springdata.automapping.exercise.domain.entities.Game;
import springdata.automapping.exercise.domain.entities.Order;
import springdata.automapping.exercise.domain.entities.Role;
import springdata.automapping.exercise.domain.entities.User;
import springdata.automapping.exercise.repositories.UserRepository;
import springdata.automapping.exercise.services.UserService;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private UserDto userDto;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {
        User user = this.modelMapper
                .map(userRegisterDto, User.class);

        user.setRole(this.userRepository.count() == 0 ? Role.ADMIN : Role.USER);

        this.userRepository.saveAndFlush(user);
    }

    @Override
    public void loginUser(UserLoginDto userLoginDto) {
        User user = this.userRepository
                .findUserByEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword());

        if (user == null) {
            System.out.println("Incorrect email / password!");
        } else {
            if (this.userDto == null) {

                this.userDto = this.modelMapper
                        .map(user, UserDto.class);
                System.out.printf("Successful login user with email: %s%n", user.getEmail());
            } else {
                System.out.println("We already have logged user! Logout first!");
            }
        }
    }

    @Override
    public void logout() {
        if(this.userDto == null) {
            System.out.println("No one is logged in!");
        } else {
            String email = this.userDto.getEmail();
            this.userDto = null;
            System.out.printf("User with email %s successfully logged out!%n",email);
        }
    }

    @Override
    public boolean isUserLoggedIn() {
        return this.userDto != null;
    }

    @Override
    public boolean isLoggedUserAdmin() {
        return this.userDto.getRole() == Role.ADMIN;
    }

    @Override
    public void addOrderToUser(Order order) {
        this.userDto.getOrders().add(order);

        User user = this.modelMapper.map(userDto,User.class);

        this.userRepository.saveAndFlush(user);
    }

    @Override
    public void viewAllCurrUserGames() {
        for (Game game : this.userDto.getGames()) {
            System.out.println(game.getTitle());
        }
    }

    @Override
    public void addGamesToUser(Set<Game> games) {
        this.userDto.setGames(games);

        User user = this.modelMapper.map(userDto,User.class);

        this.userRepository.saveAndFlush(user);
    }


}
