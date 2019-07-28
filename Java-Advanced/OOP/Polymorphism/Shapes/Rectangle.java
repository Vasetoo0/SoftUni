package OOP.Polymorphism.Shapes;

public class Rectangle extends Shape {

    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.setHeight(height);
        this.setWidth(width);
        this.calculateArea();
        this.calculatePerimeter();

    }

    private void setWidth(Double width) {
        this.width = width;
    }

    private void setHeight(Double height) {
        this.height = height;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    @Override
    protected void calculatePerimeter() {
        super.setPerimeter(2 * (this.getHeight() + this.getWidth()));
    }


    @Override
    protected void calculateArea() {
        super.setArea(this.getHeight() * this.getWidth());
    }
}
