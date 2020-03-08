package OOP.WorkingWithAbstraction.PointInRectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] rectangleCordinates = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Rectangle rectangle = new Rectangle(rectangleCordinates[0],
                rectangleCordinates[1],
                rectangleCordinates[2],
                rectangleCordinates[3]);

        int count = Integer.parseInt(reader.readLine());

        while (count-- > 0) {
            int[] pointData = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            Point point = new Point(pointData[0],pointData[1]);

            System.out.println(rectangle.contains(point));
        }
    }

}
