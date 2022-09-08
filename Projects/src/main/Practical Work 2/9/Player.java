public class Player {

    public static int NUMBER_CARDS = 5;
    private final Card[] cards = new Card[NUMBER_CARDS];
    private int current_cards = 0;

    public void addCard(Card card) {
        if (current_cards < NUMBER_CARDS) {
            cards[current_cards++] = card;
        }
    }
}
