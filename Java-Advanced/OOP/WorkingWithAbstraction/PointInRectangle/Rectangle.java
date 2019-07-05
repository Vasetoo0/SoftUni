package OOP.WorkingWithAbstraction.PointInRectangle;

public class Rectangle {
    private int bottomLeftX;
    private int bottomLeftY;
    private int topRightX;
    private int topRightY;

    public Rectangle(int bottomLeftX, int bottomLeftY, int topRigthX, int topRigthY) {
        this.bottomLeftX = bottomLeftX;
        this.bottomLeftY = bottomLeftY;
        this.topRightX = topRigthX;
        this.topRightY = topRigthY;
    }

    public boolean contains(Point point) {
        return point.getX() >= this.bottomLeftX &&
                point.getX() <= this.topRightX &&
                point.getY() >= this.bottomLeftY &&
                point.getY() <= this.topRightY;
    }




}
