package springdata.automapping.exercise.domain.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    private User user;
    private Set<Game> games;

    public Order() {
    }

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "buyer_id",referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.REFRESH)
    @JoinTable(name = "orders_ordered_games",
            joinColumns = @JoinColumn(name = "order_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "ordered_game_id",referencedColumnName = "id"))
    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
