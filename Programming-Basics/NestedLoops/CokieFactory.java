package nestedLoops;

import java.util.Scanner;

public class CokieFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int partitions = Integer.parseInt(scanner.nextLine());


        for (int i = 1; i <= partitions; i++) {
            int flour = 0;
            int eggs = 0;
            int sugar = 0;

            String ingredient = scanner.nextLine();
            if (ingredient.equals("Bake!")) {
                System.out.println("The batter should contain flour, eggs and sugar!");
                ingredient = scanner.nextLine();
            }


            while (!ingredient.equals("Bake!")) {
                if (ingredient.equals("flour")) {
                    flour++;
                }
                if (ingredient.equals("eggs")) {
                    eggs++;
                }
                if (ingredient.equals("sugar")) {
                    sugar++;
                }
                ingredient = scanner.nextLine();
                if (ingredient.equals("Bake!") && (flour == 0 || eggs == 0 || sugar == 0)) {
                    System.out.println("The batter should contain flour, eggs and sugar!");
                    ingredient = scanner.nextLine();

                }

            }


            System.out.printf("Baking batch number %d...%n", i);


        }


    }
}
