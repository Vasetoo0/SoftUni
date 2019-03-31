package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class LadyBug {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());

        int[] ladyBugStartIndex = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[] ladyBugField = new int[fieldSize];

        for (int i = 0; i < ladyBugStartIndex.length; i++) {
            if(ladyBugStartIndex[i] >= 0 && ladyBugStartIndex[i] < ladyBugField.length) {
                ladyBugField[ladyBugStartIndex[i]] = 1;
            }
        }

        String input = scanner.nextLine();

        while (!"end".equalsIgnoreCase(input)) {

            String[] command = input.split(" ");

            int indexOfLadyBug = Integer.parseInt(command[0]);
            String direction = command[1];
            int flightLength = Integer.parseInt(command[2]);

            if (indexOfLadyBug >= ladyBugField.length || indexOfLadyBug < 0) {

                input = scanner.nextLine();
                continue;
            }
            if (ladyBugField[indexOfLadyBug] == 0) {
                input = scanner.nextLine();

                continue;
            }

            ladyBugField[indexOfLadyBug] = 0;

            int cerrentFligth = flightLength;

            if ("right".equalsIgnoreCase(direction)) {

                while (indexOfLadyBug + cerrentFligth < ladyBugField.length && indexOfLadyBug + cerrentFligth >= 0) {
                    if (ladyBugField[indexOfLadyBug + cerrentFligth] == 0) {
                        ladyBugField[indexOfLadyBug + cerrentFligth] = 1;
                        break;
                    } else {
                        cerrentFligth += flightLength;
                    }
                }

//                if(ladyBugField[indexOfLadyBug] == ladyBugField[indexOfLadyBug+flightLength]) {
//                    if (flightLength < 0) {
//                        for (int i = indexOfLadyBug+flightLength; i >= 0; i--) {
//
//                            if(ladyBugField[indexOfLadyBug] != ladyBugField[i] ) {
//                                ladyBugField[i] = ladyBugField[indexOfLadyBug];
//                            }
//                        }
//                    } else {
//
//                        boolean isEqualToAll = false;
//
//                        for (int j = indexOfLadyBug; j < ladyBugField.length; j++) {
//                            if (ladyBugField[indexOfLadyBug] == ladyBugField[j]) {
//                                isEqualToAll = true;
//                            } else {
//                                isEqualToAll = false;
//                            }
//                        }
//
//                        for (int i = indexOfLadyBug+flightLength; i < ladyBugField.length; i++) {
//
//                            if(ladyBugField[indexOfLadyBug] != ladyBugField[i] ) {
//                                ladyBugField[i] = ladyBugField[indexOfLadyBug];
//                                ladyBugField[indexOfLadyBug] = 0;
//                            }
//                        }
//
//                        if (isEqualToAll) {
//                            ladyBugField[indexOfLadyBug] = 0;
//                        }
//                    }
//                } else {
//                     ladyBugField[indexOfLadyBug+flightLength] = ladyBugField[indexOfLadyBug];
//                    ladyBugField[indexOfLadyBug] = 0;
//                }
            } else if ("left".equalsIgnoreCase(direction)) {

                while (indexOfLadyBug - cerrentFligth < ladyBugField.length && indexOfLadyBug - cerrentFligth >= 0) {
                    if (ladyBugField[indexOfLadyBug - cerrentFligth] == 0) {
                        ladyBugField[indexOfLadyBug - cerrentFligth] = 1;
                        break;
                    } else {
                        cerrentFligth += flightLength;
                    }
                }
//
//                if(ladyBugField[indexOfLadyBug] == ladyBugField[indexOfLadyBug-flightLength]) {
//                    if (flightLength < 0) {
//                        for (int i = indexOfLadyBug+Math.abs(flightLength); i < ladyBugField.length; i++) {
//
//                            if(ladyBugField[indexOfLadyBug] != ladyBugField[i] ) {
//                                ladyBugField[i] = ladyBugField[indexOfLadyBug];
//                            }
//                        }
//                    } else {
//                        boolean isEqualToAll = false;
//
//                        for (int j = indexOfLadyBug; j >= 0; j--) {
//                            if (ladyBugField[indexOfLadyBug] == ladyBugField[j]) {
//                                isEqualToAll = true;
//                            } else {
//                                isEqualToAll = false;
//                            }
//                        }
//
//                        for (int i = indexOfLadyBug-flightLength; i >= 0; i--) {
//
//                            if(ladyBugField[indexOfLadyBug] != ladyBugField[i] ) {
//                                ladyBugField[i] = ladyBugField[indexOfLadyBug];
//                                ladyBugField[indexOfLadyBug] = 0;
//                            }
//                        }
//
//                        if (isEqualToAll) {
//                            ladyBugField[indexOfLadyBug] = 0;
//                        }
//                    }
//                } else {
//                    ladyBugField[indexOfLadyBug-flightLength] = ladyBugField[indexOfLadyBug];
//                    ladyBugField[indexOfLadyBug] = 0;
//                }
            }

            input = scanner.nextLine();

        }

        for (int i = 0; i < ladyBugField.length; i++) {

            System.out.print(ladyBugField[i] + " ");
        }
    }
}
