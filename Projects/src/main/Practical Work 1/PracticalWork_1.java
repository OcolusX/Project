import java.util.Scanner;

public class PracticalWork_1 {

    private static int fact(int n) {
        int fact = 1;
        for(int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        task_7();
    }

    private static void task_3() {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;

        int[] arr = new int[scanner.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }
        double average = (double) sum / arr.length;

        System.out.println("Сумма: " + sum);
        System.out.println("Среднее арифметическое: " + average);
    }


    private static void task_4() {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int[] arr_1 = new int[scanner.nextInt()];

        int i = 0;
        do {
            arr_1[i] = scanner.nextInt();
            if (max < arr_1[i]) {
                max = arr_1[i];
            }
            sum += arr_1[i++];
        } while (i < arr_1.length);

        System.out.println("Сумма первого массива: " + sum);
        System.out.println("Максимальный элемент: " + max);

        int[] arr_2 = new int[scanner.nextInt()];
        i = 0;
        sum = 0;
        while (i < arr_2.length) {
            arr_2[i] = scanner.nextInt();
            if (min > arr_2[i]) {
                min = arr_2[i];
            }
            sum += arr_2[i++];
        }

        System.out.println("Сумма второго массива: " + sum);
        System.out.println("Минимальный элемент: " + min);

    }


    private static void task_5(String[] args) {
        for (String s : args) {
            System.out.println(s);
        }
    }

    private static void task_6() {
        for (int i = 2; i < 12; i++) {
            System.out.print(String.format("1/%d ", i));
        }
    }

    private static void task_7() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(fact(scanner.nextInt()));
    }
}
