package OOP.ReflectionAndAnotations.barracksWars.core.commands;

import OOP.ReflectionAndAnotations.barracksWars.core.Annotations.Inject;
import OOP.ReflectionAndAnotations.barracksWars.interfaces.CommandInterpreter;
import OOP.ReflectionAndAnotations.barracksWars.interfaces.Executable;
import OOP.ReflectionAndAnotations.barracksWars.interfaces.Repository;
import OOP.ReflectionAndAnotations.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {
    private static final String COMMAND_PACKAGE_PATH = "OOP.ReflectionAndAnotations.barracksWars.core.commands.";

    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        Executable executable = null;
        commandName = Character.toUpperCase(commandName.charAt(0)) + commandName.substring(1);
        Class clazz = null;
        try {
            clazz = Class.forName(COMMAND_PACKAGE_PATH + commandName);
            Constructor constr = clazz.getDeclaredConstructor(String[].class);
            constr.setAccessible(true);
            executable = (Executable) constr.newInstance((Object) data);
            this.injectFields(executable);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return executable;
    }

    private void injectFields(Executable executable) {
        Field[] fields = executable.getClass().getDeclaredFields();
        Field[] currentFields = this.getClass().getDeclaredFields();

        for (Field field : fields) {
            if(field.isAnnotationPresent(Inject.class)) {
                for (Field currentField : currentFields) {
                    if(field.getName().equals(currentField.getName())) {
                        try {
                            field.setAccessible(true);
                            field.set(executable,currentField.get(this));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
