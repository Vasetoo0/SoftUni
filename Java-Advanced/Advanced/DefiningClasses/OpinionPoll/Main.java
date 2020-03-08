package Advanced.DefiningClasses.OpinionPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        int count = Integer.parseInt(reader.readLine());

        List<OpinionPoll> polls = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String[] data = reader.readLine().split("\\s+");

            int years = Integer.parseInt(data[1]);
            if(years > 30) {
                OpinionPoll opinionPoll = new OpinionPoll(data[0], years);

                polls.add(opinionPoll);
            }
        }
        polls.stream()
                .sorted(Comparator.comparing(OpinionPoll::getName))
                .forEach(p -> {
                    System.out.println(String.format("%s - %s",p.getName(),p.getAge()));
                });
    }

}
