package OOP.Encapsulation.FootballTeamGenerator;

import OOP.Encapsulation.FootballTeamGenerator.Validators.Validator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    public String getName() {
        return this.name;
    }

    private void setShooting(int shooting) {
        this.validateStat(shooting,"Shooting");
        this.shooting = shooting;
    }

    private void setPassing(int passing) {
        this.validateStat(passing,"Passing");
        this.passing = passing;
    }

    private void setDribble(int dribble) {
        this.validateStat(dribble, "Dribble");
        this.dribble = dribble;
    }

    private void setSprint(int sprint) {
        this.validateStat(sprint, "Sprint");
        this.sprint = sprint;
    }

    private void setEndurance(int endurance) {
        this.validateStat(endurance, "Endurance");
        this.endurance = endurance;
    }

    private void setName(String name) {
        if(Validator.validateName(name)) {
           this.name = name;
        } else {
            throw new IllegalArgumentException("A name should not be empty.");
        }

    }

    private void validateStat(int stat, String name) {
        if(!Validator.validateStat(stat)) {
            throw new IllegalArgumentException(name + " should be between 0 and 100.");
        }
    }

    public double overallSkillLevel() {
        return (double)(this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / 5;
    }

}
