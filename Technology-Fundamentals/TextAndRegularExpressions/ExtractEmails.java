package TextAndRegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile(
                "\\b(?<! \\.|-|_)([A-Za-z0-9]+)[\\.\\-\\_]*[a-z]*[\\.\\-\\_]*[A-Za-z0-9]*@" +
                        "[A-Za-z0-9]+[\\.\\-]*[a-z]*[\\.\\-]*[a-z]*[\\.]+[a-z]+[\\.]*[a-z]+(?!\\.{2}|-|_)\\b");
        Matcher emails = pattern.matcher(text);

        while (emails.find()) {
            System.out.println(emails.group());
        }
    }
}
