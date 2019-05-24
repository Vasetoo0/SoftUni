package Advanced.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(";");

        String[] robots = new String[input.length];
        int[] processTime = new int[input.length];
        int[] workingTime = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            String[] robotsData = input[i].split("-");
            String robot = robotsData[0];
            int time =Integer.parseInt(robotsData[1]);
            robots[i] = robot;
            processTime[i] = time;
        }

        String startTime = scanner.nextLine();

        ArrayDeque<String> products = new ArrayDeque<>();

        String upCommingProduct;

        while (!"End".equals(upCommingProduct = scanner.nextLine())) {
            products.offer(upCommingProduct);
        }

        String[] timeData = startTime.split(":");
        int hours = Integer.parseInt(timeData[0]);
        int minutes = Integer.parseInt(timeData[1]);
        int seconds = Integer.parseInt(timeData[2]);

//        LocalTime time = LocalTime.of(hours, minutes, seconds);


        int beginSeconds = hours * 3600 +  minutes * 60 + seconds;

        while (!products.isEmpty()) {
            beginSeconds++;

//            time = time.plusSeconds(1);

            String product = products.poll();
            boolean isAssigned = false;

            for (int i = 0; i < robots.length; i++) {
                if(workingTime[i] == 0 && !isAssigned) {
                    workingTime[i] = processTime[i];
                    isAssigned = true;
                    printRobotData(robots[i], product, beginSeconds);
                }
                if(workingTime[i] > 0) {
                    workingTime[i]--;
                }
            }
            if(!isAssigned) {
                products.offer(product);
            }
        }

    }

    private static void printRobotData(String robot, String product,int beginSeconds) {
        long s = beginSeconds % 60;
        long m = (beginSeconds / 60) % 60;
        long h = (beginSeconds / (60 * 60)) % 24;

        System.out.println(robot + " - " + product + String.format(" [%02d:%02d:%02d]", h, m, s));

//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
//
//        System.out.println(robot + " - " + product + " [" + time.format(formatter) + "]");

    }

}
