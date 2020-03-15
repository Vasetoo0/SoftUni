package springdata.automapping.exercise.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdata.automapping.exercise.domain.dtos.gameDtos.*;
import springdata.automapping.exercise.domain.entities.Game;
import springdata.automapping.exercise.repositories.GameRepository;
import springdata.automapping.exercise.services.GameService;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

@Service
public class GameServiceImpl implements GameService  {

    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;
    private final EntityManager entityManager;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper, EntityManager entityManager) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
        this.entityManager = entityManager;
    }

    @Override
    public void addGame(GameAddDto gameAddDto) {
        if(!isGameExist(gameAddDto)){
            Game game = this.modelMapper
                    .map(gameAddDto,Game.class);

            this.gameRepository.saveAndFlush(game);
        } else {
            System.out.println("Game already exist!");
        }
    }

    @Override
    public void editGame(GameEditDto gameEditDto) {
        Game game = this.modelMapper
                .map(gameEditDto,Game.class);

        this.gameRepository.saveAndFlush(game);
    }

    @Override
    public GameEditDto getGameForEdit(long id) {
        if(this.gameRepository.findById(id) == null) {
            return null;
        } else {
            return this.modelMapper
                    .map(this.gameRepository.findById(id),GameEditDto.class);
        }
    }

    @Override
    public void deleteGame(long id) {
        Game game = this.gameRepository.findById(id);
        if(game == null) {
            System.out.println("Game dont exist!");
        } else {
            String gameName = game.getTitle();
            this.gameRepository.delete(game);
            System.out.printf("Game %s deleted successfully!%n",gameName);
        }
    }

    @Override
    public List<GameViewDto> viewAllGames() {
        List<Game> games = this.gameRepository.findAll();
        return Arrays.asList(modelMapper.map(games, GameViewDto[].class));
    }

    @Override
    public GameDetailsViewDto viewDetailsForGame(String title) {
        Game game = this.gameRepository.findGameByTitle(title);

        return this.modelMapper
                .map(game,GameDetailsViewDto.class);
    }

    @Override
    public GameOrderDto getGameForOrder(String title) {
        if(this.gameRepository.findGameByTitle(title) == null) {
            return null;
        } else {
            return this.modelMapper
                    .map(this.gameRepository.findGameByTitle(title),GameOrderDto.class);
        }
    }

    private boolean isGameExist(GameAddDto gameAddDto) {
        return this.gameRepository.findGameByTitle(gameAddDto.getTitle()) != null;
    }
}
