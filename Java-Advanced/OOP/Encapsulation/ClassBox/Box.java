package OOP.Encapsulation.ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setHeight(double height) {
        validateSide(height, "Height");
        this.height = height;
    }

    private void setLength(double length) {
        validateSide(length, "Length");
        this.length = length;
    }

    private void setWidth(double width) {
        validateSide(width, "Width");
        this.width = width;

    }


    public void validateSide(double side, String sideType) {
        if (side <= 0) {
            throw new IllegalArgumentException(sideType + " cannot be zero or negative.");
        }
    }

    public double calculateSurfaceArea() {
        return 2 * this.length * this.width + 2 * this.length * this.height + 2 * this.width * this.height;
    }

    public double calculateLateralSurfaceArea() {
        return 2 * this.length * this.height + 2 * this.width * this.height;
    }

    public double calculateVolume(){
        return this.length * this.width * this.height;
    }
}
