package Advanced.Generics.GenericSwapMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Box> boxes = new ArrayList<>();
        while (n-- != 0) {
            int num =Integer.parseInt(scanner.nextLine());

            Box<Integer> box = new Box<>(num);

            boxes.add(box);
        }

        int firstIndex = scanner.nextInt();
        int secondIndex = scanner.nextInt();

        swap(boxes, firstIndex, secondIndex);

        for (Box box : boxes) {
            System.out.println(box.toString());
        }

    }

    public static <T> void swap(List<T> list, int firstIndex, int secondIndex) {

            T firstElement = list.get(firstIndex);
            list.set(firstIndex, list.get(secondIndex));
            list.set(secondIndex, firstElement);

    }
}
