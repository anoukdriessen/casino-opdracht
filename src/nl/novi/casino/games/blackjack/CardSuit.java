package nl.novi.casino.games.blackjack;

/**
 * Klasse cardsuit is de vormgeving van de kaart
 * Er zijn vier mogelijke opties
 * DIAMONDS / SPADES / HEARTS / CLUBS
 */
public class CardSuit {
    private final String name;
    private final char symbol;
    private final String color;

    /**
     * Consturctor voor Cardsuit
     * stelt de naam, het symbool en de kleur van de kaart in
     * @param name de naam van de CardSuit
     * @param symbol het symbool van de CardSuit
     * @param color de kleur van de CardSuit
     */
    public CardSuit(String name, char symbol, String color) {
        this.name = name;
        this.symbol = symbol;
        this.color = color;
    }

    /**
     * Getter voor de naam van de CardSuit
     */
    public String getName() {
        return name;
    }

    /**
     * Getter voor het symbool van de CardSuit
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * Getter voor de kleur van de CardSuit
     */
    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return getName() + " " + getSymbol() + " " + getColor();
    }
}
