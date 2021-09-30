package nl.novi.casino.games.blackjack;

/**
 * Klasse cardvalue is de waarde van iedere kaart in het deck kaarten
 * Iedere waarde heeft een naam en numerieke waarde
 */
public class CardValue {
    private String name;
    private int value;

    /**
     * Constructor voor de cardValue
     * stelt de naam van de waarde en de numerieke waarde in
     */
    public CardValue(String name, int value) {
        this.name = name;
        this.value = value;
    }

    /**
     * getter voor de naam van de waarde
     */
    public String getName() {
        return name;
    }

    /**
     * getter voor de numerieke waarde
     */
    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getName() + " " + getValue();
    }
}
