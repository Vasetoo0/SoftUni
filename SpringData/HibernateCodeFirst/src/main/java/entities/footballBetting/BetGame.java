package entities.footballBetting;

import javax.persistence.*;
import java.io.Serializable;

//@Entity
//@Table(name = "bet_games")
public class BetGame implements Serializable {

    private Game game;
    private Bet bet;
    private long gameId;
    private long betId;
    private ResultPrediction resultPrediction;

    public BetGame() {
    }

    @OneToOne
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
        this.setGameId(game.getId());
    }

    @OneToOne
    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
        this.setBetId(bet.getId());
    }

    @Id
    @Column(name = "game_id")
    public long getGameId() {
        return gameId;
    }

    private void setGameId(long gameId) {
        this.gameId = gameId;
    }

    @Id
    @Column(name = "bet_id")
    public long getBetId() {
        return betId;
    }

    private void setBetId(long betId) {
        this.betId = betId;
    }

    @OneToOne
    public ResultPrediction getResultPrediction() {
        return resultPrediction;
    }

    public void setResultPrediction(ResultPrediction resultPrediction) {
        this.resultPrediction = resultPrediction;
    }
}
