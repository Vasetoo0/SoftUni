package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> lessons = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String input = "";

        while (!"course start".equalsIgnoreCase(input = scanner.nextLine())) {

            String[] data = input.split("[:]");

            String command = data[0];
            String lessonTitle = data[1];

            switch (command) {
                case "Add":
                    if(!lessonDoExist(lessons, lessonTitle)) {
                        lessons.add(lessonTitle);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(data[2]);
                    if(!lessonDoExist(lessons, lessonTitle)) {
                        lessons.add(index, lessonTitle);
                    }
                    break;
                case "Remove":
                    if(lessonDoExist(lessons, lessonTitle)) {
                        lessons.remove(lessonTitle);
                    }
                    break;
                case "Swap":
                    String lessonToSwap = data[2];
                    int swapIndex = lessons.indexOf(lessonToSwap);
                    if(lessonDoExist(lessons, lessonTitle) && lessonDoExist(lessons, lessonToSwap)) {
                        if (lessonDoExist(lessons, String.format("%s-Exercise", lessonTitle))) {
                            lessons.set(lessons.indexOf(lessonTitle), lessonToSwap);
                            lessons.set(swapIndex, lessonTitle);
                            lessons.add(swapIndex + 1, String.format("%s-Exercise", lessonTitle));
                            lessons.remove(lessons.size()-1);
                        } else if (lessonDoExist(lessons, String.format("%s-Exercise", lessonToSwap))) {
                            lessons.set(lessons.indexOf(lessonTitle), lessonToSwap);
                            lessons.add(lessons.indexOf(lessonToSwap) + 1, String.format("%s-Exercise", lessonToSwap));
                            lessons.remove(lessons.size()-1);
                            lessons.remove(lessons.size()-1);
                            lessons.add(swapIndex + 1, lessonTitle);
                        } else {
                            lessons.set(lessons.indexOf(lessonTitle), lessonToSwap);
                            lessons.set(swapIndex, lessonTitle);
                        }
                    }
                    break;
                case "Exercise":
                    if(lessonDoExist(lessons, lessonTitle) &&
                            !lessonDoExist(lessons, String.format("%s-Exercise", lessonTitle))) {
                        lessons.add(lessons.indexOf(lessonTitle) + 1, String.format("%s-Exercise", lessonTitle));
                    } else if (!lessonDoExist(lessons, lessonTitle)) {
                        lessons.add(lessonTitle);
                        lessons.add(String.format("%s-Exercise", lessonTitle));
                    }
                    break;
            }
        }

        for (int i = 0; i < lessons.size(); i++) {
            System.out.printf("%d.%s%n",i+1, lessons.get(i));
        }
    }

    private static boolean lessonDoExist(List<String> lessons, String lessonTitle) {

        for (int i = 0; i < lessons.size(); i++) {
            if (lessons.get(i).equalsIgnoreCase(lessonTitle)) {
                return true;
            }
        }
        return false;
    }
}
