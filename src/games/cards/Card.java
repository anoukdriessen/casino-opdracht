package games.cards;

/**
 * Klasse Card is een kaart in een spel
 * kaarten worden gebruikt in het spel blackjack
 * een kaart bestaat uit een omvang en waarde
 */
public class Card {
    // de omvang van de kaart
    private Suit suit;
    // de waarde van de kaart
    private Value value;

    /**
     * Constructor van klasse Card
     * @param suit de omvang van de kaart
     * @param value de waarde van de kaart
     */
    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    /**
     * Getter voor de waarde van de kaart
     * @return de waarde als integer
     */
    public int getValue() {
        return value.getValue();
    }

    public String show() {
        return this.suit.getSymbol() + " " + this.value.getName();
    }

    /**
     * Methode om de kaart als String weer te geven
     */
    @Override
    public String toString() {
        return this.suit.getName() + " " + this.value.getName() + "\n";
    }
}

