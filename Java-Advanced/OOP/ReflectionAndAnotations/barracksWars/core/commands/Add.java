package OOP.ReflectionAndAnotations.barracksWars.core.commands;

import OOP.ReflectionAndAnotations.barracksWars.core.Annotations.Inject;
import OOP.ReflectionAndAnotations.barracksWars.interfaces.Repository;
import OOP.ReflectionAndAnotations.barracksWars.interfaces.Unit;
import OOP.ReflectionAndAnotations.barracksWars.interfaces.UnitFactory;

public class Add extends Command {

    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    protected Add(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];
        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);
        return unitType + " added!";
    }
}
