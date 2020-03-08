package entities.footballBetting;

import entities.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

//@Entity
//@Table(name = "bets")
public class Bet extends BaseEntity {

    private double betMoney;
    private LocalDateTime dateAndTimeOfBet;
    private User user;

    public Bet() {
    }

    @Column(name = "bet_money",nullable = false)
    public double getBetMoney() {
        return betMoney;
    }

    public void setBetMoney(double betMoney) {
        this.betMoney = betMoney;
    }

    @Column(name = "date_and_time_of_bet",nullable = false)
    public LocalDateTime getDateAndTimeOfBet() {
        return dateAndTimeOfBet;
    }

    public void setDateAndTimeOfBet(LocalDateTime dateAndTimeOfBet) {
        this.dateAndTimeOfBet = dateAndTimeOfBet;
    }

    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
