import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        JFrame frame = new JFrame("Калькулятор");
        frame.add(calculator.getPanel());
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
