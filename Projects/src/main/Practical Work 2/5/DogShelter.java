public class DogShelter {
    private Dog[] dogs;
    private int size;
    private int capacity;

    public DogShelter(int capacity) {
        this.capacity = capacity;
        size = 0;
        dogs = new Dog[capacity];
    }

    public void add(Dog dog) {
        if(size < capacity) {
            dogs[size++] = new Dog(dog.getName(), dog.getAge());
        }
    }

    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < size; i++) {
            s += dogs[i].toString() + "\n";
        }
        return s;
    }
}
