import java.util.Scanner;

public class DogTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DogShelter shelter = new DogShelter(10);
        Dog dog = new Dog(scanner.next(), scanner.nextInt());
        shelter.add(dog);

        dog.setName(scanner.next());
        dog.setAge(scanner.nextInt());
        shelter.add(dog);

        System.out.println(shelter.toString());
    }
}
