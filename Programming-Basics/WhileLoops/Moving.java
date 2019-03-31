package whileLoops;

import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int lenght = Integer.parseInt(scanner.nextLine());
        int hight = Integer.parseInt(scanner.nextLine());

        int freeSpace = width * lenght * hight;



        int boxCount = 1;
        int boxSum = 0;

        while (boxSum < freeSpace) {


            String  input = scanner.nextLine();
            if ("Done".equals(input)) {
                System.out.printf("%d Cubic meters left.", freeSpace - boxSum);
                break;
            }
              boxCount = Integer.parseInt(input);
              boxSum += boxCount;

              if(boxSum >= freeSpace) {
                  System.out.printf("No more free space! You need %d Cubic meters more.", boxSum - freeSpace);
              }
        }



    }
}
