import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class Poker {

    private static final int NUMBER_CARDS = 52; // Кол-во карт в колоде
    private static final List<Card> deck = new LinkedList<>();

    public static void main(String[] args) {
        // Инициализация колоды (по 13 карт каждой масти)
        Suit[] suits = Suit.values();
        int numberValues = NUMBER_CARDS / suits.length; // по 13 карт на каждую масть
        for (int i = 0; i < NUMBER_CARDS; i++) {
            deck.add(new Card(i % numberValues + 2, suits[i / numberValues]));
        }


        System.out.println("Введите кол-во игроков:");
        Scanner scanner = new Scanner(System.in);
        int n;
        while ((n = scanner.nextInt()) > 10 || n < 2) {
            System.out.println("В игре должно быть не менее 2 и не более 10 игроков!\nВведите кол-во игроков ещё раз:");
        }

        Player[] players = new Player[n];
        numberValues = NUMBER_CARDS;
        int randomCard;
        for (int j = 0; j < n; j++) {
            players[j] = new Player();
            System.out.println("Игрок " + (j + 1) + ":");
            for (int i = 0; i < Player.NUMBER_CARDS; i++) {
                randomCard = (int)(Math.random() * (numberValues--));
                Card card = deck.remove(randomCard);
                players[j].addCard(card);
                System.out.println("\t" + card);
            }
        }
    }

}
