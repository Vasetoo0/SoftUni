package OOP.WorkingWithAbstraction.JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Galactic galactic = new Galactic(dimensions[0], dimensions[1]);

        String command;
        Player player = new Player();
        while (!"Let the Force be with you".equals(command = scanner.nextLine())) {
            int[] ivoCoordinates = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evilCoordinates = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            galactic.moveEvil(evilCoordinates[0], evilCoordinates[1]);
            player.collectStars(galactic, ivoCoordinates[0], ivoCoordinates[1]);

        }
        System.out.println(player.getStarSum());
    }
}
