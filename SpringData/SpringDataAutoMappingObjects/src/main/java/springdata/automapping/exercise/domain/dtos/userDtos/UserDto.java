package springdata.automapping.exercise.domain.dtos.userDtos;

import springdata.automapping.exercise.domain.entities.Game;
import springdata.automapping.exercise.domain.entities.Order;
import springdata.automapping.exercise.domain.entities.Role;

import java.util.Set;

public class UserDto {

    private long id;
    private String email;
    private String password;
    private String fullName;
    private Role role;
    private Set<Game> games;
    private Set<Order> orders;

    public UserDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
