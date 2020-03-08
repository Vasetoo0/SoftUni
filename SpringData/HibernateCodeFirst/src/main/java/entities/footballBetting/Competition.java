package entities.footballBetting;

import entities.BaseEntity;

import javax.persistence.*;
import java.util.Set;

//@Entity
//@Table(name = "competitions")
public class Competition extends BaseEntity {

    private String name;
    private CompetitionType type;
    private Set<Game> games;


    public Competition() {
    }

    @Column(name = "name",nullable = false,length = 50,unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne
    @JoinColumn(name = "competition_type_id",referencedColumnName = "id")
    public CompetitionType getType() {
        return type;
    }

    public void setType(CompetitionType type) {
        this.type = type;
    }

    @OneToMany(mappedBy = "competition",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
