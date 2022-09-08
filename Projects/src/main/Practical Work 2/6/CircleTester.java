public class CircleTester {

    public static void main(String[] args) {
        Circle_2 circle = new Circle_2();
        circle.setCenter(new Point());
        circle.setRadius(3);

        System.out.println("Square: " + circle.square());
        System.out.println("Length: " + circle.length());

        Circle_2 circle_2 = new Circle_2(new Point(1, 2), 3);
        if(circle.equals(circle_2)) {
            System.out.println("True!");
        } else {
            System.out.println("False!");
        }

        circle_2.setCenter(new Point());
        if(circle.equals(circle_2)) {
            System.out.println("True!");
        } else {
            System.out.println("False!");
        }
    }
}
