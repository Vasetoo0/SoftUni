package OOP.WorkingWithAbstraction.HotelReservation;

public enum Season {
    AUTUMN(1),
    SPRING(2),
    WINTER(3),
    SUMMER(4);

   private int multiplier;

    public int getMultiplier() {
        return multiplier;
    }

    Season(int multiplier) {
        this.multiplier = multiplier;
    }
}
