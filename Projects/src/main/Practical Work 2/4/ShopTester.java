public class ShopTester {

    public static void main(String[] args) {
        Shop shop = new Shop(10);
        Computer computer = new Computer();

        computer.fill();
        shop.add(computer);

        computer.fill();
        shop.add(computer);
        Computer c = new Computer(computer.getId(), computer.getName(), computer.getDescription());

        computer.fill();
        shop.add(computer);

        shop.delete(c);
        if(shop.find(c.getId()) == null) {
            System.out.println("Not found!");
        }

    }
}
