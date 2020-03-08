package entities.footballBetting;

import entities.BaseEntity;

import javax.persistence.*;
import java.util.Set;

//@Entity
//@Table(name = "continents")
public class Continent extends BaseEntity {

    private String name;
    private Set<Country> countries;

    public Continent() {
    }

    @Column(name = "name", nullable = false, length = 15)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "continents", targetEntity = Country.class,
            fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }
}
