package Methods;

import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());


        System.out.println(subtract(sumFirstTwo(firstNum,secondNum),thirdNum));

    }

    static int sumFirstTwo(int first, int second){
        return first + second;
    }

    static int subtract(int fistTwoSum, int third) {
        return fistTwoSum - third;

    }
}
