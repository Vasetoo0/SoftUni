package Advanced.DefiningClasses.BankAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<BankAccount> accounts = new ArrayList<>();

        String input;

        while (!"End".equals(input = reader.readLine())) {

            BankAccount bankAccount = new BankAccount();

            String[] data = input.split("\\s+");

            if (data.length == 1) {
                accounts.add(bankAccount);
                System.out.printf("Account ID%d created%n", bankAccount.getId());

            } else if (data.length == 2) {

                double interestRate = Double.parseDouble(data[1]);
                BankAccount.setInterestRate(interestRate);

            } else {
                if ("Deposit".equals(data[0])) {
                    int idToDeposit = Integer.parseInt(data[1]) - 1;
                    if (idToDeposit >= accounts.size()) {
                        System.out.println("Account does not exist");
                    } else {

                        int amount = Integer.parseInt(data[2]);
                        accounts.get(idToDeposit).deposit(amount);
                        System.out.println(String.format("Deposited %d to ID%d", amount,
                                accounts.get(idToDeposit).getId()));
                    }

                } else {
                    int idToMatch = Integer.parseInt(data[1]) - 1;
                    if (idToMatch >= accounts.size()) {
                        System.out.println("Account does not exist");
                    } else {
                        int years = Integer.parseInt(data[2]);
                        double interest = accounts.get(idToMatch).getInterest(years);

                        System.out.printf("%.2f%n", interest);

                    }
                }
            }
        }
    }
}
