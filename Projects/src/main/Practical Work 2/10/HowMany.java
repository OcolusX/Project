import java.util.Scanner;

public class HowMany {
    public static void main(String[] args) {
        Scanner s;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Кол-во слов: " + scanner.nextLine().split("\\s").length);
    }
}
