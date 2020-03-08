package entities.footballBetting;

import javax.persistence.*;
import java.io.Serializable;

//@Entity
//@Table(name = "player_statistics")
public class PlayerStatistic implements Serializable {


    private Player player;
    private Game game;
    private long playerId;
    private long gameId;
    private int scoredGoals;
    private int playerAssists;
    private int playerMinutesPlayed;

    public PlayerStatistic() {
    }

    @OneToOne
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
        this.setPlayerId(player.getId());
    }


    @OneToOne
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
        this.setGameId(game.getId());
    }

    @Id
    @Column(name = "player_id")
    public long getPlayerId() {
        return this.player.getId();
    }

    private void setPlayerId(long player_id) {
        this.playerId = player_id;
    }

    @Id
    @Column(name = "game_id")
    public long getGameId() {
        return this.game.getId();
    }

    private void setGameId(long game_id) {
        this.gameId = game_id;
    }

    @Column(name = "scored_goals")
    public int getScoredGoals() {
        return scoredGoals;
    }

    public void setScoredGoals(int scoredGoals) {
        this.scoredGoals = scoredGoals;
    }

    @Column(name = "player_assist")
    public int getPlayerAssists() {
        return playerAssists;
    }

    public void setPlayerAssists(int playerAssists) {
        this.playerAssists = playerAssists;
    }

    @Column(name = "minutes_played")
    public int getPlayerMinutesPlayed() {
        return playerMinutesPlayed;
    }

    public void setPlayerMinutesPlayed(int playerMinutesPlayed) {
        this.playerMinutesPlayed = playerMinutesPlayed;
    }
}
