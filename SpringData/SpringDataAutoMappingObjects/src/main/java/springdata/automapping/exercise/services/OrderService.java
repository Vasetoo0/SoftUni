package springdata.automapping.exercise.services;

import springdata.automapping.exercise.domain.dtos.gameDtos.GameOrderDto;

public interface OrderService {

   void addItem(GameOrderDto gameOrderDto);

   void removeItem(GameOrderDto gameOrderDto);

   void buyItem();


}
