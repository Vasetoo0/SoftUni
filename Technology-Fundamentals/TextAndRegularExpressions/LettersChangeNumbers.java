package TextAndRegularExpressions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> sequences = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());


        double wholeSum = 0;

        for (int i = 0; i < sequences.size(); i++) {
            double number = 0;

            String sequence = sequences.get(i);

            Pattern beforeUpperPattern = Pattern.compile("[A-Z][0-9]+");
            Pattern numberPattern = Pattern.compile("[0-9]+");
            Pattern afterUpperPattern = Pattern.compile("[0-9]+[A-Z]");
            Matcher beforeUpperMatcher = beforeUpperPattern.matcher(sequence);
            Matcher numberMatcher = numberPattern.matcher(sequence);
            Matcher afterUpperMatcher = afterUpperPattern.matcher(sequence);

            if(numberMatcher.find()) {
                number = Double.parseDouble(numberMatcher.group());

            }

            if(beforeUpperMatcher.find()) {
                number /= sequence.charAt(0) - 64;
            } else {
                number *= sequence.charAt(0) - 96;
            }

            if(afterUpperMatcher.find()) {
                number -= sequence.charAt(sequence.length()-1) - 64;
            } else {

                number += sequence.charAt(sequence.length()-1) - 96;
            }

            wholeSum += number;

        }
        System.out.printf("%.2f", wholeSum);
    }
}
