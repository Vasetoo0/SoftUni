package entities.footballBetting;

import javax.persistence.*;
import java.util.Set;

//@Entity
//@Table(name = "positions")
public class Position {

    private String id;
    private String positionDescription;
    private Set<Player> players;

    public Position() {
    }

    @Id
    @Column(name = "id",length = 2,nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id.toUpperCase();
    }

    @Column(name = "position_description",nullable = false,length = 100)
    public String getPositionDescription() {
        return positionDescription;
    }

    public void setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription;
    }

    @OneToMany(mappedBy = "position", targetEntity = Player.class,
            fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
