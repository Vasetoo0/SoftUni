package Advanced.SetsAndMaps;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstSetSize = scanner.nextInt();
        int secondSetSize = scanner.nextInt();
        scanner.nextLine();

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        Set<Integer> repetingNums = new LinkedHashSet<>();

        for (int i = 0; i < firstSetSize; i++) {
            firstSet.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int i = 0; i < secondSetSize; i++) {
            secondSet.add(Integer.parseInt(scanner.nextLine()));
        }

        if(firstSetSize > secondSetSize) {
            for (Integer integer : firstSet) {
                for (Integer integer1 : secondSet) {
                    if(integer.equals(integer1)) {
                        repetingNums.add(integer);
                    }
                }
            }
        } else if(firstSetSize < secondSetSize) {
            for (Integer integer : secondSet) {
                for (Integer integer1 : firstSet) {
                    if(integer.equals(integer1)) {
                        repetingNums.add(integer);
                    }
                }
            }
        } else {
            for (Integer integer : firstSet) {
                for (Integer integer1 : secondSet) {
                    if(integer.equals(integer1)) {
                        repetingNums.add(integer);
                    }
                }
            }
        }

        repetingNums.forEach(n -> System.out.print(n + " "));
    }

}
