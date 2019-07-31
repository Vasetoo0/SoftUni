package OOP.Encapsulation.FootballTeamGenerator.Validators;

public class Validator {

    public static boolean validateStat(int stat){
        return stat >= 0 && stat <= 100;
    }

    public static boolean validateName(String name) {
        return name != null && !name.trim().isEmpty();
    }
}
