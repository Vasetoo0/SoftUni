package ObjectsAndClasses.ArticlesPartTwo;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Article> articles = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] articleDetails = scanner.nextLine().split(", ");

            Article article = new Article(articleDetails[0], articleDetails[1],articleDetails[2]);

            articles.add(article);
        }

        String command = scanner.nextLine().toLowerCase();

        switch (command) {
            case "title":
                articles.stream()
                        .sorted((a1,a2) -> a1.getTitle().compareTo(a2.getTitle()))
                        .forEach(System.out::println);


                break;
            case "content":
                articles.stream()
                        .sorted((a1,a2) -> a1.getContent().compareTo(a2.getContent()))
                        .forEach(System.out::println);

                break;
            case "author":
                articles.stream()
                        .sorted((a1,a2) -> a1.getAuthor().compareTo(a2.getAuthor()))
                        .forEach(System.out::println);
                break;
        }

    }

}
