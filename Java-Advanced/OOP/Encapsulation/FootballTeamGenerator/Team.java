package OOP.Encapsulation.FootballTeamGenerator;

import OOP.Encapsulation.FootballTeamGenerator.Validators.Validator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
            this.setName(name);
            this.players = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if(Validator.validateName(name)) {

            this.name = name;
        } else {
            throw new IllegalArgumentException("A name should not be empty.");
        }
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String name) {
        boolean havePlayer = false;
        Player playerToRemove = null;
        for (Player player : this.players) {
            if(player.getName().equals(name)) {
                havePlayer = true;
                playerToRemove = player;
                break;
            }
        }
        if(havePlayer) {
            this.players.remove(playerToRemove);
        } else {
            throw new IllegalArgumentException("Player " + name + " is not in " + this.getName() + " team.");
        }
    }

    public double getRating(){
        double rating = 0;

        if(players.size() != 0) {
            for (Player player : this.players) {
                rating += player.overallSkillLevel();
            }
            rating /= this.players.size();
        }
        return rating;
    }


}
