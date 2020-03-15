package springdata.automapping.exercise.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdata.automapping.exercise.domain.dtos.gameDtos.GameOrderDto;
import springdata.automapping.exercise.domain.dtos.orderDtos.CurrOrderDto;
import springdata.automapping.exercise.domain.entities.Game;
import springdata.automapping.exercise.domain.entities.Order;
import springdata.automapping.exercise.repositories.OrderRepository;
import springdata.automapping.exercise.services.OrderService;
import springdata.automapping.exercise.services.UserService;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private CurrOrderDto currOrderDto;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, UserService userService, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addItem(GameOrderDto gameOrderDto) {
        Game game = this.modelMapper.map(gameOrderDto,Game.class);

        if(this.currOrderDto == null){
            this.currOrderDto = new CurrOrderDto();
        }

       this.currOrderDto.getGames().add(game);

    }

    @Override
    public void removeItem(GameOrderDto gameOrderDto) {
        if(this.currOrderDto.getGames().size() > 0) {

            this.currOrderDto.getGames().removeIf(game -> game.getId() == gameOrderDto.getId());
        } else {
            System.out.println("No games to remove!");
        }
    }

    @Override
    public void buyItem() {
        Order order = this.modelMapper
                .map(currOrderDto,Order.class);

        this.userService.addGamesToUser(order.getGames());

        this.userService.addOrderToUser(order);

        this.orderRepository.saveAndFlush(order);

        System.out.println("Successfully bought games:");

        order.getGames().forEach(g -> {
            System.out.println("-" + g.getTitle());
        });

        this.currOrderDto = null;
    }
}
