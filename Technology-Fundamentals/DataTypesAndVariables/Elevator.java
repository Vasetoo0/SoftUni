package DataTypesAndVariables;

import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleCount = Integer.parseInt(scanner.nextLine());
        int capacity = Integer.parseInt(scanner.nextLine());

//        int courses = (int)Math.ceil((double) peopleCount / capacity);


        int courses = peopleCount / capacity;

        if (peopleCount % capacity != 0) {
            courses++;
        }
        System.out.println(courses);

    }
}
