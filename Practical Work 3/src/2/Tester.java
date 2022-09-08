import java.util.Arrays;
import java.util.Random;

public class Tester {
    private static final int number = 10;
    private static final Circle[] circles = new Circle[number];

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < number; i++) {
            circles[i] = new Circle(
                    new Point(random.nextDouble() * 21 - 10, random.nextDouble() * 21 - 10),
                    random.nextDouble() * 10
            );
            System.out.println((i + 1) + ") " + circles[i]);
        }

        System.out.println("Самая маленькая окружность: " + min());
        System.out.println("Самая большая окружность: " + max());

        System.out.println("\nСортируем...\n");
        sort();
        for (Circle circle : circles) {
            System.out.println(circle);
        }
    }

    public static Circle min() {
        return Arrays.stream(circles).min(Circle::compareTo).orElse(null);
    }

    public static Circle max() {
        return Arrays.stream(circles).max(Circle::compareTo).orElse(null);
    }

    public static void sort() {
        Arrays.sort(circles);
    }
}
