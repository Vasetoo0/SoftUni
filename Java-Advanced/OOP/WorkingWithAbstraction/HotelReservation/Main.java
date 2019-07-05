package OOP.WorkingWithAbstraction.HotelReservation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] data = reader.readLine().split(" ");

        double pricePerDay = Double.parseDouble(data[0]);
        int days = Integer.parseInt(data[1]);
        Season season = Season.valueOf(data[2].toUpperCase());
        Discount discount = Discount.valueOf(data[3].toUpperCase());

        Reservation reservation = new Reservation(pricePerDay,days,season,discount);

        double price = PriceCalculator.calculate(reservation);

        System.out.printf("%.2f",price);

    }

}
