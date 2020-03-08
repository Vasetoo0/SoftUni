package whileLoops;

import java.util.Scanner;

public class OldBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String bookNeed = scanner.nextLine();
        int capacity = Integer.parseInt(scanner.nextLine());

        int bookCount = 0;

        while (bookCount < capacity) {
            String bookName = scanner.nextLine();
            if (bookNeed.equals(bookName)) {
                System.out.printf("You checked %d books and found it.", bookCount);
                break;
            }

            bookCount++;
        }

        if (bookCount == capacity) {
            System.out.println("The book you search is not here!");
            System.out.printf("You checked %d books.", capacity);
        }


    }
}
