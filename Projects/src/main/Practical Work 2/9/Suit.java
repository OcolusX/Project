public enum Suit {
    HEART("\u2665"),
    DIAMOND("\u2666"),
    CLUB("\u2663"),
    SPADE("\u2660");

    private final String symbol;

    private Suit(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
