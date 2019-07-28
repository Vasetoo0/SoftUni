package OOP.ReflectionAndAnotations.barracksWars.core.factories;

import OOP.ReflectionAndAnotations.barracksWars.interfaces.Unit;
import OOP.ReflectionAndAnotations.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "OOP.ReflectionAndAnotations.barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) {
        Unit unit = null;
        try {
            Class clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);
            Constructor constructor = clazz.getConstructor();
            unit = (Unit) constructor.newInstance();
        } catch (ClassNotFoundException |
                NoSuchMethodException |
                IllegalAccessException |
                InstantiationException |
                InvocationTargetException e) {
            e.printStackTrace();
        }
        return unit;
    }
}
