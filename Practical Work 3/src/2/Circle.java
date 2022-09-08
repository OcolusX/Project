public class Circle implements Comparable<Circle> {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public double square() {
        return radius * radius * Math.PI;
    }

    public double length() {
        return 2 * radius * Math.PI;
    }

    @Override
    public int compareTo(Circle o) {
        return Double.compare(radius, o.radius);
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
    public String toString() {
        return String.format("r = %.2f, O%s", radius, center.toString());
    }
}
