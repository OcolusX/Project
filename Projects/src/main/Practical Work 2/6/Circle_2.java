import java.util.Objects;

public class Circle_2 {
    private Point center;
    private double radius;

    public Circle_2(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Circle_2() {
        center = new Point();
        radius = 0.0;
    }

    public double square() {
        return radius * radius * Math.PI;
    }

    public double length() {
        return 2 * radius * Math.PI;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle_2 circle_2 = (Circle_2) o;
        return Double.compare(circle_2.radius, radius) == 0 && Objects.equals(center, circle_2.center);
    }   
}
