public class Shop {

    private Computer[] computers;
    private int index;
    private int capacity;

    public Shop(int capacity) {
        this.capacity = capacity;
        computers = new Computer[capacity];
        index = 0;
    }

    public void add(Computer computer) {
        if (index < capacity) {
            computers[index] = new Computer(computer.getId(), computer.getName(), computer.getDescription());
            for(int i = index + 1; i < capacity; i++) {
                if(computers[i] == null) {
                    index = i;
                    return;
                }
            }
            index = capacity;
        }
    }

    public void delete(Computer computer) {
        for (int i = 0; i < capacity; i++) {
            if (computers[i].equals(computer)) {
                computers[i] = null;
                index = i;
                return;
            }
        }
    }

    public void delete(int id) {
        for (int i = 0; i < capacity; i++) {
            if(computers[i].getId() == id) {
                computers[i] = null;
                index = i;
            }
        }
    }

    public Computer find(int id) {
        for(Computer computer : computers) {
            if(computer != null && computer.getId() == id) {
                return computer;
            }
        }
        return null;
    }
}
