package whileLoops;

import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double coins = Double.parseDouble(scanner.nextLine());

        double lv = Math.floor(coins);
        int stotinki = (int) Math.round((coins - lv) * 100);

        int coinsCount = 0;

        while (lv > 0) {
            if (lv >= 2) {
                coinsCount++;
                lv -= 2;
            } else if (lv >= 1) {
                coinsCount++;
                lv -= 1;
            }
        }

        while (stotinki > 0.0) {
            if (stotinki >= 50) {
                coinsCount++;
                stotinki -= 50;
            } else if (stotinki >= 20) {
                coinsCount++;
                stotinki -= 20;
            } else if (stotinki >= 10) {
                coinsCount++;
                stotinki -= 10;
            } else if (stotinki >= 05) {
                coinsCount++;
                stotinki -= 05;
            } else if (stotinki >= 02) {
                coinsCount++;
                stotinki -= 02;
            } else if (stotinki >= 01) {
                coinsCount++;
                stotinki -= 0.01;
            }
        }

        System.out.println(coinsCount);

    }
}
