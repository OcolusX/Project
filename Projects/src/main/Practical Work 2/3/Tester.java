import java.util.Scanner;

public class Tester {

    private static Circle[] circles;
    private static int number;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        circles = new Circle[number];
        for (int i = 0; i < number; i++) {
            System.out.print((i + 1) + ")\t");
            System.out.print("Центр окружности: ");
            Point point = new Point(scanner.nextDouble(), scanner.nextDouble());
            System.out.print("\tРадиус окружности: ");
            circles[i] = new Circle(point, scanner.nextDouble());
            System.out.println("");
        }

        for(Circle circle : circles) {
            System.out.println("O = " + circle.getCenter().toString() + "; R = " + circle.getRadius());
        }
    }
}
