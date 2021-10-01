package games.cards;

/**
 * Klasse suit is onderdeel van de klasse Card
 * er bestaan 4 verschillende suits: Schoppen, Harten, Ruiten en Klaveren
 */
public class Suit {
    private String name;
    private char symbol;
    private String color;

    /**
     * Constructor van klasse suit
     */
    public Suit(String name, char symbol, String color) {
        this.name = name;
        this.symbol = symbol;
        this.color = color;
    }

    /**
     * Getter voor de naam van de cardsuit
     * @return de naam van de suit
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter voor het symbool van de cardsuit
     * @return het symbool van de suit
     */
    public char getSymbol() {
        return this.symbol;
    }

    /**
     * Getter voor de kleur van de cardsuit
     * @return de kleur van de suit
     */
    public String getColor() {
        return this.color;
    }
}

