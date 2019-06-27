package Advanced.Generics.GenericCountMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Box> boxes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            double num =Double.parseDouble(scanner.nextLine());

            Box<Double> box = new Box<>(num);

            boxes.add(box);


        }

        double numToCompare = Double.parseDouble(scanner.nextLine());

        System.out.println(getCount(boxes, numToCompare));
    }
    public static <T extends Comparable<T>> int getCount(List<Box> elements, T element) {

        int count = 0;

        for (Box box : elements) {
            if(box.getElement().compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }
}
