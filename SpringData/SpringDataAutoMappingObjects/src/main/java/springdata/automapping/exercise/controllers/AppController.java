package springdata.automapping.exercise.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springdata.automapping.exercise.domain.dtos.gameDtos.GameAddDto;
import springdata.automapping.exercise.domain.dtos.gameDtos.GameDetailsViewDto;
import springdata.automapping.exercise.domain.dtos.gameDtos.GameEditDto;
import springdata.automapping.exercise.domain.dtos.gameDtos.GameOrderDto;
import springdata.automapping.exercise.domain.dtos.userDtos.UserLoginDto;
import springdata.automapping.exercise.domain.dtos.userDtos.UserRegisterDto;
import springdata.automapping.exercise.services.GameService;
import springdata.automapping.exercise.services.OrderService;
import springdata.automapping.exercise.services.UserService;
import springdata.automapping.exercise.utils.ValidationUtil;

import javax.validation.ConstraintViolation;
import java.io.BufferedReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static springdata.automapping.exercise.constants.GlobalConstants.*;

@Component
public class AppController implements CommandLineRunner {

    private final BufferedReader reader;
    private final ValidationUtil validationUtil;
    private final UserService userService;
    private final GameService gameService;
    private final OrderService orderService;

    @Autowired
    public AppController(BufferedReader reader, ValidationUtil validationUtil, UserService userService, GameService gameService, OrderService orderService) {
        this.reader = reader;
        this.validationUtil = validationUtil;
        this.userService = userService;
        this.gameService = gameService;
        this.orderService = orderService;
    }

    @Override
    public void run(String... args) throws Exception {

        while (true) {
            System.out.println("Enter input: ");
            String[] input = reader.readLine().split("\\|");

            switch (input[0]) {
                case "RegisterUser":

                    if (!input[2].equals(input[3])) {
                        System.out.println("Password do not match!");
                        break;
                    }

                    UserRegisterDto userRegisterDto =
                            new UserRegisterDto(input[1], input[2], input[4]);

                    if (this.validationUtil.isValid(userRegisterDto)) {

                        this.userService.registerUser(userRegisterDto);

                        System.out.printf("Successful registration of user with email: %s!%n", input[1]);
                    } else {
                        this.validationUtil
                                .getViolations(userRegisterDto)
                                .stream()
                                .map(ConstraintViolation::getMessage)
                                .forEach(System.out::println);
                    }

                    break;
                case "LoginUser":
                    UserLoginDto userLoginDto = new UserLoginDto(input[1], input[2]);

                    this.userService.loginUser(userLoginDto);

                    break;
                case "Logout":
                    this.userService.logout();
                    break;
                case "AddGame":
                    GameAddDto gameAddDto = new GameAddDto(
                            input[1],
                            new BigDecimal(input[2]),
                            Double.parseDouble(input[3]),
                            input[4],
                            input[5],
                            input[6],
                            LocalDate.parse(input[7], DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                    );

                    if (validationUtil.isValid(gameAddDto)) {
                        if (isLoggedAsAdmin()) {
                            this.gameService.addGame(gameAddDto);
                            System.out.printf("Game %s successfully added!%n", input[1]);
                        } else {
                            System.out.println(LOGIN_AS_ADMIN);
                        }
                    } else {
                        validationUtil.getViolations(gameAddDto)
                                .stream()
                                .map(ConstraintViolation::getMessage)
                                .forEach(System.out::println);
                    }
                    break;
                case "EditGame":
                    if (isLoggedAsAdmin()) {
                        GameEditDto gameEditDto = this.gameService.getGameForEdit(Long.parseLong(input[1]));

                        if (gameEditDto == null) {
                            System.out.printf("Game with %s id dont exist!%n", input[1]);
                        } else {

                            for (int i = 2; i < input.length; i++) {
                                String[] values = input[i].split("=");

                                switch (values[0]) {
                                    case "title":
                                        gameEditDto.setTitle(values[1]);
                                        break;
                                    case "price":
                                        gameEditDto.setPrice(new BigDecimal(values[1]));
                                        break;
                                    case "size":
                                        gameEditDto.setSize(Double.parseDouble(values[1]));
                                        break;
                                    case "trailer":
                                        gameEditDto.setTrailer(values[1]);
                                        break;
                                    case "thubnailURL":
                                        gameEditDto.setThubnailURL(values[1]);
                                        break;
                                    case "description":
                                        gameEditDto.setDescription(values[1]);
                                        break;
                                    case "releaseDate":
                                        gameEditDto
                                                .setReleaseDate
                                                        (LocalDate.parse(input[7], DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                                        break;
                                }
                            }

                            if (this.validationUtil.isValid(gameEditDto)) {
                                this.gameService.editGame(gameEditDto);
                            } else {
                                this.validationUtil.getViolations(gameEditDto)
                                        .stream()
                                        .map(ConstraintViolation::getMessage)
                                        .forEach(System.out::println);
                            }

                            System.out.printf("Game %s successfully edited!%n", gameEditDto.getTitle());
                        }
                    } else {
                        System.out.println(LOGIN_AS_ADMIN);
                    }
                    break;
                case "DeleteGame":
                    if (isLoggedAsAdmin()) {
                        this.gameService.deleteGame(Long.parseLong(input[1]));
                    } else {
                        System.out.println(LOGIN_AS_ADMIN);
                    }
                    break;
                case "AllGames":
                    if (this.userService.isUserLoggedIn()) {
                        this.gameService.viewAllGames()
                                .forEach(g -> {
                                    System.out.printf("%s %s%n",
                                            g.getTitle(),
                                            g.getPrice());
                                });
                    } else {
                        System.out.println(NEED_LOGIN);
                    }
                    break;
                case "DetailGame":
                    if (this.userService.isUserLoggedIn()) {
                        GameDetailsViewDto gameDetailsViewDto = this.gameService.viewDetailsForGame(input[1]);
                        System.out.println("Title: " + gameDetailsViewDto.getTitle());
                        System.out.println("Price: " + gameDetailsViewDto.getPrice());
                        System.out.println("Description: " + gameDetailsViewDto.getDescription());
                        System.out.println("Release date: " + gameDetailsViewDto.getReleaseDate());
                    } else {
                        System.out.println(NEED_LOGIN);
                    }
                    break;
                case "OwnedGames":
                    if (this.userService.isUserLoggedIn()) {
                        this.userService.viewAllCurrUserGames();
                    } else {
                        System.out.println(NEED_LOGIN);
                    }
                    break;
                case "AddItem":
                    if (this.userService.isUserLoggedIn()) {
                        GameOrderDto gameOrderDto = this.gameService.getGameForOrder(input[1]);
                        if (gameOrderDto == null) {
                            System.out.println(GAME_NOT_EXIST);
                        } else {
                            this.orderService.addItem(gameOrderDto);
                            System.out.printf("%s added to cart!%n",gameOrderDto.getTitle());
                        }
                    } else {
                        System.out.println(NEED_LOGIN);
                    }
                    break;
                case "RemoveItem":
                    if(this.userService.isUserLoggedIn()) {
                        GameOrderDto gameOrderDto = this.gameService.getGameForOrder(input[1]);
                        if(gameOrderDto == null){
                            System.out.println(GAME_NOT_EXIST);
                        } else {
                            this.orderService.removeItem(gameOrderDto);
                            System.out.printf("%s removed from cart!%n",gameOrderDto.getTitle());
                        }
                    } else {
                        System.out.println(NEED_LOGIN);
                    }
                    break;
                case "BuyItem":
                    if(this.userService.isUserLoggedIn()){
                        this.orderService.buyItem();
                    } else {
                        System.out.println(NEED_LOGIN);
                    }
                    break;
                case "End":
                    return;

            }
        }
    }

    private boolean isLoggedAsAdmin() {
        return this.userService.isUserLoggedIn() && this.userService.isLoggedUserAdmin();
    }
}
