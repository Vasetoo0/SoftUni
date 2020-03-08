package OOP.ReflectionAndAnotations.harvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Class<RichSoilLand> reflection = RichSoilLand.class;

        String input;

        while (!"HARVEST".equals(input = bufferedReader.readLine())) {
            printNeededFields(input, reflection);
        }

    }

    private static void printNeededFields(String fieldNeeded, Class<RichSoilLand> reflection) {
        switch (fieldNeeded) {
            case "protected":
                Arrays.stream(reflection.getDeclaredFields())
                        .filter(f -> Modifier.isProtected(f.getModifiers()))
                        .forEach(f -> System.out.println(Modifier.toString(f.getModifiers()) +
                                " " + f.getType().getSimpleName() +
                                " " + f.getName()));
                break;
            case "private":
                Arrays.stream(reflection.getDeclaredFields())
                        .filter(f -> Modifier.isPrivate(f.getModifiers()))
                        .forEach(f -> System.out.println(Modifier.toString(f.getModifiers()) +
                                " " + f.getType().getSimpleName() +
                                " " + f.getName()));
                break;
            case "public":
                Arrays.stream(reflection.getDeclaredFields())
                        .filter(f -> Modifier.isPublic(f.getModifiers()))
                        .forEach(f -> System.out.println(Modifier.toString(f.getModifiers()) +
                                " " + f.getType().getSimpleName() +
                                " " + f.getName()));
                break;
            default:
                Arrays.stream(reflection.getDeclaredFields())
                        .forEach(f -> System.out.println(Modifier.toString(f.getModifiers()) +
                                " " + f.getType().getSimpleName() +
                                " " + f.getName()));
                break;
        }
    }
}
