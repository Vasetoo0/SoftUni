package entities.footballBetting;

import entities.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

//@Entity
//@Table(name = "teams")
public class Team extends BaseEntity {

    private String name;
    private byte[] logo;
    private String initial;
    private Color primaryKitColor;
    private Color secondaryKitColor;
    private Town town;
    private Double budget;
    private Set<Player> players;

    public Team() {
    }

    @Column(name = "name", nullable = false, length = 70, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "logo", nullable = false, unique = true)
    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    @Column(name = "initial", nullable = false, length = 3, unique = true)
    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial.toUpperCase();
    }

    @OneToOne
    @JoinColumn(name = "primary_color_id", referencedColumnName = "id")
    public Color getPrimaryKitColor() {
        return primaryKitColor;
    }

    public void setPrimaryKitColor(Color primaryKitColor) {
        this.primaryKitColor = primaryKitColor;
    }

    @OneToOne
    @JoinColumn(name = "secondary_color_id", referencedColumnName = "id")
    public Color getSecondaryKitColor() {
        return secondaryKitColor;
    }

    public void setSecondaryKitColor(Color secondaryKitColor) {
        this.secondaryKitColor = secondaryKitColor;
    }

    @ManyToOne
    @JoinColumn(name = "town_id", referencedColumnName = "id")
    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    @Column(name = "budget", nullable = false)
    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    @OneToMany(mappedBy = "team", targetEntity = Player.class,
            fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
