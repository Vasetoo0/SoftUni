package Advanced.DefiningClasses.RawData;

public class Tires {
   private int tire1Age;
   private double tire1Presure;
   private int tire2Age;
   private double tire2Presure;
   private int tire3Age;
   private double tire3Presure;
   private int tire4Age;
   private double tire4Presure;

    public Tires(double tire1Presure, double tire2Presure, double tire3Presure, double tire4Presure) {
        this.tire1Presure = tire1Presure;
        this.tire2Presure = tire2Presure;
        this.tire3Presure = tire3Presure;
        this.tire4Presure = tire4Presure;
    }

    public double getAverage() {
        return (tire1Presure + tire2Presure + tire3Presure + tire4Presure) / 4;
    }
}
