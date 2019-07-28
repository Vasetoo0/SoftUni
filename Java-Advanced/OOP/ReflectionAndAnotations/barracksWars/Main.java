package OOP.ReflectionAndAnotations.barracksWars;

import OOP.ReflectionAndAnotations.barracksWars.core.Engine;
import OOP.ReflectionAndAnotations.barracksWars.core.commands.CommandInterpreterImpl;
import OOP.ReflectionAndAnotations.barracksWars.core.factories.UnitFactoryImpl;
import OOP.ReflectionAndAnotations.barracksWars.data.UnitRepository;
import OOP.ReflectionAndAnotations.barracksWars.interfaces.CommandInterpreter;
import OOP.ReflectionAndAnotations.barracksWars.interfaces.Repository;
import OOP.ReflectionAndAnotations.barracksWars.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        CommandInterpreter commandInterpreter = new CommandInterpreterImpl(repository,unitFactory);

        Runnable engine = new Engine(commandInterpreter);
        engine.run();
    }
}
