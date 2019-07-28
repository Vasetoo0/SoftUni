package OOP.ReflectionAndAnotations.barracksWars.core.commands;

import OOP.ReflectionAndAnotations.barracksWars.core.Annotations.Inject;
import OOP.ReflectionAndAnotations.barracksWars.interfaces.Repository;

public class Report extends Command {
    @Inject
    private Repository repository;

    protected Report(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
