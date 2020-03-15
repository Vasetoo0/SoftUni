package springdata.automapping.exercise.services;

import org.springframework.stereotype.Service;
import springdata.automapping.exercise.domain.dtos.gameDtos.*;

import java.util.List;

@Service
public interface GameService {

    void addGame(GameAddDto gameAddDto);

    void editGame(GameEditDto gameEditDto);

    GameEditDto getGameForEdit(long id);

    void deleteGame(long id);

    List<GameViewDto> viewAllGames();

    GameDetailsViewDto viewDetailsForGame(String title);

    GameOrderDto getGameForOrder(String title);
}
