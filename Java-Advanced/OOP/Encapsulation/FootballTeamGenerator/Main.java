package OOP.Encapsulation.FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String,Team> teams = new HashMap<>();

        String input;

        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split(";");

            String teamName = tokens[1];
            try {

                switch (tokens[0]) {
                    case "Team":
                        Team team = new Team(teamName);
                        teams.put(teamName, team);
                        break;
                    case "Add":
                        if(teams.containsKey(teamName)) {
                            Player player = new Player(
                                    tokens[2],
                                    Integer.parseInt(tokens[3]),
                                    Integer.parseInt(tokens[4]),
                                    Integer.parseInt(tokens[5]),
                                    Integer.parseInt(tokens[6]),
                                    Integer.parseInt(tokens[7])
                                    );
                            teams.get(teamName).addPlayer(player);
                        } else {
                            System.out.println("Team " + teamName + " does not exist.");
                        }
                        break;
                    case "Remove":
                        if(teams.containsKey(teamName)) {
                            teams.get(teamName).removePlayer(tokens[2]);
                        } else {
                            System.out.println("Team " + teamName + " does not exist.");
                        }
                        break;
                    case "Rating":
                        if(teams.containsKey(teamName)) {
                            System.out.println(teamName + " - " + (int)Math.round(teams.get(teamName).getRating()));
                        } else {
                            System.out.println("Team " + teamName + " does not exist.");
                        }
                        break;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
