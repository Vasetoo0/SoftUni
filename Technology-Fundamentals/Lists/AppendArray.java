package Lists;


import java.util.*;

public class AppendArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.asList(scanner.nextLine().split("[|]"));

        Collections.reverse(input);

        String reverseInput = "";

        for (int i = 0; i < input.size(); i++) {
            reverseInput += input.get(i) + " ";
        }

        String[] numbers = reverseInput.split(" +");

        System.out.println(String.join(" ", numbers).trim());



    }
}
