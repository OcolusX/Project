import java.util.Arrays;
import java.util.Random;

public class RandomArray {
    public static void main(String[] args) {
        math();
    }

    public static void random() {
        Random random = new Random();
        double[] arr = new double[10];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = random.nextDouble();
            System.out.printf("%.3f ", arr[i]);
        }
        Arrays.sort(arr);
        System.out.println("\nСортируем...");
        for (double v : arr) {
            System.out.printf("%.3f ", v);
        }
    }

    public static void math() {
        double[] arr = new double[10];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Math.random();
            System.out.printf("%.3f ", arr[i]);
        }
        Arrays.sort(arr);
        System.out.println("\nСортируем...");
        for (double v : arr) {
            System.out.printf("%.3f ", v);
        }
    }
}

