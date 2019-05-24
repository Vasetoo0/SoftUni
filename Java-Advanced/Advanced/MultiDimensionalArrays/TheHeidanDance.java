package Advanced.MultiDimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class TheHeidanDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] fieldMatrix = new String[15][15];



        double heiganLife = 3000000;
        int playerLife = 18500;
        int nextTurnDamage = 0;
        int playerRow = 7;
        int playerCol = 7;
        String lastSpell = "";

        double playerDamage = Double.parseDouble(scanner.nextLine());

        while (playerLife > 0) {
            for (int row = 0; row < 15; row++) {
                for (int col = 0; col < 15; col++) {
                    fieldMatrix[row][col] = "0";
                }

            }


            heiganLife -= playerDamage;
            if (nextTurnDamage > 0) {
                playerLife -= nextTurnDamage;
                nextTurnDamage = 0;
                if (playerLife <= 0) {
                    break;
                }
            }
            if (heiganLife <= 0) {
                break;
            }

            String[] spellData = scanner.nextLine().split(" ");

            String spell = spellData[0];
            int spellRow = Integer.parseInt(spellData[1]);
            int spellCol = Integer.parseInt(spellData[2]);

            if (isOnAngle(fieldMatrix, spellRow, spellCol)) {

                if (spellRow == 0 && spellCol == 0) {
                    for (int row = 0; row < 2; row++) {
                        for (int col = 0; col < 2; col++) {

                            fieldMatrix[row][col] = "d";
                        }
                    }
                } else if (spellRow == 14 && spellCol == 0) {
                    for (int row = 13; row < 15; row++) {
                        for (int col = 0; col < 2; col++) {

                            fieldMatrix[row][col] = "d";
                        }
                    }
                } else if (spellRow == 14 && spellCol == 14) {
                    for (int row = 13; row < 15; row++) {
                        for (int col = 13; col < 15; col++) {

                            fieldMatrix[row][col] = "d";
                        }
                    }
                } else if (spellRow == 0 && spellCol == 14) {
                    for (int row = 0; row < 2; row++) {
                        for (int col = 13; col < 15; col++) {

                            fieldMatrix[row][col] = "d";
                        }
                    }
                }
            } else if (onBorder(fieldMatrix, spellRow, spellCol)) {
                if (spellRow == 0) {
                    for (int row = 0; row < 2; row++) {
                        for (int col = spellCol - 1; col < spellCol + 2; col++) {

                            fieldMatrix[row][col] = "d";
                        }
                    }
                } else if (spellRow == 14) {
                    for (int row = 13; row < 15; row++) {
                        for (int col = spellCol - 1; col < spellCol + 2; col++) {

                            fieldMatrix[row][col] = "d";
                        }
                    }
                } else if (spellCol == 0) {
                    for (int row = spellRow - 1; row < spellRow + 2; row++) {
                        for (int col = 0; col < 2; col++) {

                            fieldMatrix[row][col] = "d";
                        }
                    }
                } else if (spellCol == 14) {
                    for (int row = spellRow - 1; row < spellRow + 2; row++) {
                        for (int col = 13; col < 15; col++) {

                            fieldMatrix[row][col] = "d";
                        }
                    }
                }
            } else {
                for (int row = spellRow - 1; row < spellRow + 2; row++) {
                    for (int col = spellCol - 1; col < spellCol + 2; col++) {

                        fieldMatrix[row][col] = "d";
                    }
                }
            }

            if (fieldMatrix[playerRow][playerCol].equals("d")) {


                    if (playerRow - 1 >= 0 && !fieldMatrix[playerRow - 1][playerCol].equals("d")) {
                        playerRow -= 1;

                    } else if (playerCol + 1 < 15 && !fieldMatrix[playerRow][playerCol + 1].equals("d")) {
                        playerCol += 1;
                    } else if (playerRow + 1 < 15 && !fieldMatrix[playerRow + 1][playerCol].equals("d")) {
                        playerRow += 1;
                    } else if(playerCol - 1 >= 0 && !fieldMatrix[playerRow][playerCol - 1].equals("d")) {
                        playerCol -= 1;
                    } else {
                        if(spell.equals("Cloud")) {
                            playerLife -= 3500;
                            nextTurnDamage = 3500;
                        } else if(spell.equals("Eruption")) {
                            playerLife -= 6000;
                        }
                        lastSpell = spell;
                    }
                }
            }


        if(heiganLife > 0) {

            System.out.printf("Heigan: %.2f%n", heiganLife);
        } else  {
            System.out.println("Heigan: Defeated!");

        }
        if(lastSpell.equals("Cloud") && playerLife <= 0) {
            System.out.println("Player: Killed by Plague Cloud");
        }else if(lastSpell.equals("Eruption") && playerLife <= 0) {
            System.out.println("Player: Killed by " + lastSpell);
        } else if (playerLife > 0) {
            System.out.println("Player: " + playerLife);
        }
        System.out.println("Final position: " + playerRow + ", " + playerCol);
    }

    private static boolean isInField(int playerRow, int playerCol) {
        return playerRow + 1 < 15
                && playerRow - 1 >= 0
                 && playerCol + 1 < 15
                && playerCol - 1 >= 0;
    }

    private static boolean isOnAngle(String[][] fieldMatrix, int spellRow, int spellCol) {
        return spellRow == 0
                && spellCol == 0
                || spellRow == 14
                && spellCol == 0
                || spellRow == 14
                && spellCol == 14
                || spellRow == 0
                && spellCol == 14;
    }

    private static boolean onBorder(String[][] fieldMatrix, int spellRow, int spellCol) {
        return spellRow == 0
                || spellRow == 14
                || spellCol == 0
                || spellCol == 14;
    }

}
