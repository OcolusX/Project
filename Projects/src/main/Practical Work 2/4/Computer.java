import java.util.Objects;
import java.util.Scanner;

public class Computer implements ComputerFilling {
    private int id;
    private String name;
    private String description;

    public Computer(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Computer() {
        return;
    }

    @Override
    public void fill() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("id: ");
        id = scanner.nextInt();
        System.out.print("name: ");
        name = scanner.next();
        System.out.print("description: ");
        description = scanner.next();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return id == computer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
