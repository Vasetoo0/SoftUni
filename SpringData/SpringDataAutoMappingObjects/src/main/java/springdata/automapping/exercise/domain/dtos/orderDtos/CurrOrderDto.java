package springdata.automapping.exercise.domain.dtos.orderDtos;

import springdata.automapping.exercise.domain.entities.Game;
import springdata.automapping.exercise.domain.entities.User;

import java.util.HashSet;
import java.util.Set;

public class CurrOrderDto {

    private long id;
    private User user;
    private Set<Game> games;

    public CurrOrderDto() {
        this.games = new HashSet<>();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
