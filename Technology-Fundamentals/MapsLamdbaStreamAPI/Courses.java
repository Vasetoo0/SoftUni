package MapsLamdbaStreamAPI;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> courses = new LinkedHashMap<>();

        String input = "";

        while (!"end".equals(input = scanner.nextLine())) {

            String[] data = input.split(" : ");

            String course = data[0];
            String studentName = data[1];



            if (!courses.containsKey(course)) {
                courses.put(course, new ArrayList<>());
                courses.get(course).add(studentName);
            } else {
                courses.get(course).add(studentName);
            }
        }

        courses.entrySet().stream()
                .sorted((v1,v2) -> Integer.compare(v2.getValue().size(),v1.getValue().size()))
                .forEach((e) -> {
                    System.out.println(String.format("%s: %s", e.getKey(), e.getValue().size()));
                    Collections.sort(e.getValue());
                    for (int i = 0; i < e.getValue().size(); i++) {
                        System.out.println(String.format("-- %s",e.getValue().get(i)));
                    }
                });
    }

}
