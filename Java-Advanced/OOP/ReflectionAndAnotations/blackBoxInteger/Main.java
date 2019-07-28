package OOP.ReflectionAndAnotations.blackBoxInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IOException,
            NoSuchMethodException,
            InvocationTargetException,
            IllegalAccessException,
            NoSuchFieldException, InstantiationException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Class<BlackBoxInt> reflection = BlackBoxInt.class;

        Constructor<BlackBoxInt> constructor = reflection.getDeclaredConstructor();

        constructor.setAccessible(true);

        BlackBoxInt blackBoxInt = constructor.newInstance();

        String input;

        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split("_");

            String command = tokens[0];

            switch (command) {
                case "add":
                    runCommand("add",reflection,blackBoxInt,Integer.parseInt(tokens[1]));
                    break;
                case "subtract":
                    runCommand("subtract",reflection,blackBoxInt,Integer.parseInt(tokens[1]));
                    break;
                case "divide":
                    runCommand("divide",reflection,blackBoxInt,Integer.parseInt(tokens[1]));
                    break;
                case "multiply":
                    runCommand("multiply",reflection,blackBoxInt,Integer.parseInt(tokens[1]));
                    break;
                case "rightShift":
                    runCommand("rightShift",reflection,blackBoxInt,Integer.parseInt(tokens[1]));
                    break;
                case "leftShift":
                    runCommand("leftShift",reflection,blackBoxInt,Integer.parseInt(tokens[1]));
                    break;
            }

            Field field = reflection.getDeclaredField("innerValue");

            field.setAccessible(true);

            System.out.println(field.get(blackBoxInt));
        }

    }

    private static void runCommand(String command, Class<BlackBoxInt> reflection,
                                   BlackBoxInt blackBoxInt, int numToOperateWith)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method operation  = reflection.getDeclaredMethod(command, int.class);
        operation.setAccessible(true);
        operation.invoke(blackBoxInt,numToOperateWith);
    }
}
