package OOP.WorkingWithAbstraction.HotelReservation;

public class PriceCalculator {

    public static double calculate(Reservation reservation) {

        double price = reservation.getPricePerDay()*reservation.getNumberOfDays()*reservation.getSeason().getMultiplier();

        price = price - (price * reservation.getDiscount().getDiscount());

        return price;
    }




}
