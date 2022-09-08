public class TestBall {

    public static void main(String[] args) {
        Ball ball = new Ball(1, 1);
        System.out.println("Начальные коор-ты: " + ball.toString());

        ball.move(2, 1);
        System.out.println("После смещения: " + ball.toString());
    }
}
