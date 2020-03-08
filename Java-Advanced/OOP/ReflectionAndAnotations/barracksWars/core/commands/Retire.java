package OOP.ReflectionAndAnotations.barracksWars.core.commands;

import OOP.ReflectionAndAnotations.barracksWars.core.Annotations.Inject;
import OOP.ReflectionAndAnotations.barracksWars.interfaces.Repository;

public class Retire extends Command {

    @Inject
    private Repository repository;

    protected Retire(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];
        try {
            this.repository.removeUnit(unitType);
        } catch (IllegalArgumentException ex) {
            return ex.getMessage();
        }
        return unitType + " retired!";
    }
}
