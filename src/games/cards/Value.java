package games.cards;

/**
 * Klasse value is een onderdeel van Card
 * de waarde bestaat uit een numerieke en waarde als tekst
 */
public class Value {
    private String name;
    private int value;

    /**
     * Constructor voor de klasse waarde
     */
    public Value(String name, int value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Getter voor de tekst naam van de waarde
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter voor de numerieke waarde
     */
    public int getValue() {
        return this.value;
    }
}
