public class Card {

    private final int value;
    private final Suit suit;

    public Card(int value, Suit suit) {
        this.value = value < 2 || value > 14 ? 2 : value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return value + "" + suit;
    }
}
