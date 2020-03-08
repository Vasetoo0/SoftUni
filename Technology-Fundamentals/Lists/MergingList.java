package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstRowList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> secondRowList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

//        System.out.println(String.join(" ", newList(firstRowList, secondRowList)));
            List<Integer> newRowList = new ArrayList<>();

            int minLength = Math.min(firstRowList.size(), secondRowList.size());

        for (int i = 0; i < minLength; i++) {

            newRowList.add(firstRowList.get(i));
            newRowList.add(secondRowList.get(i));
    }

        if (firstRowList.size() > secondRowList.size()) {
            newRowList.addAll(firstRowList
                    .subList(minLength, firstRowList.size()));
        } else {
            newRowList.addAll(secondRowList
                    .subList(minLength, secondRowList.size()));
        }

        System.out.println(newRowList.toString().replaceAll("[\\[,\\]]", ""));

//    static List<String> newList(List<Integer> first, List<Integer> second) {
//
//
//        boolean isBiggerRow = first.size() > second.size();
//        boolean isEqual = first.size() == second.size();
//
//        if (isBiggerRow) {
//
//            for (int i = 0; i < second.size(); i++) {
//
//                newRowList.add(String.valueOf(first.get(i)));
//                newRowList.add(String.valueOf(second.get(i)));
//
//            }
//        } else {
//
//            for (int i = 0; i < first.size(); i++) {
//
//                newRowList.add(String.valueOf(first.get(i)));
//                newRowList.add(String.valueOf(second.get(i)));
//
//            }
//        }
//
//        if (isBiggerRow) {
//
//            int count = first.size() - second.size();
//
//            for (int i = 0; i < count; i++) {
//                newRowList.add(String.valueOf(first.get(second.size() + i)));
//            }
//            return newRowList;
//
//        } else if (isEqual) {
//
//            return newRowList;
//        } else {
//
//            int count = second.size() - first.size();
//
//            for (int i = 0; i < count; i++) {
//                newRowList.add(String.valueOf(second.get(first.size() + i)));
//            }
//            return newRowList;
//        }


    }
}
