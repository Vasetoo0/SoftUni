package entities.footballBetting;

import entities.BaseEntity;

import javax.persistence.*;
import java.util.Set;

//@Entity
//@Table(name = "countries")
public class Country {

    private String id;
    private String name;
    private Set<Continent> continents;
    private Set<Town> towns;

    public Country() {
    }

    @Id
    @Column(name = "id", nullable = false, length = 3)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id.toUpperCase();
    }

    @Column(name = "name", length = 50, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany
    @JoinTable(name = "countries_continents",
    joinColumns = @JoinColumn(name = "country_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "continent_id",referencedColumnName = "id"))
    public Set<Continent> getContinents() {
        return continents;
    }

    public void setContinents(Set<Continent> continents) {
        this.continents = continents;
    }

    @OneToMany(mappedBy = "country", targetEntity = Town.class,
            fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<Town> getTowns() {
        return towns;
    }

    public void setTowns(Set<Town> towns) {
        this.towns = towns;
    }
}
