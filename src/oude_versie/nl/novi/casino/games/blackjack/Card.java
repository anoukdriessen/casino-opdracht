package nl.novi.casino.games.blackjack;

/**
 * Klasse Card is een kaart die gebruikt wordt bij blackjack
 * een kaart bestaat uit een suit en value
 */
public class Card {
    private CardSuit suit;
    private CardValue value;

    /**
     * Constructor van Card stelt de waardes in
     * @param suit de suit van de kaart
     * @param value de waarde van de kaart
     */
    public Card(CardSuit suit, CardValue value) {
        this.suit = suit;
        this.value = value;
    }

    /**
     * getter voor suit
     * @return de suit van de kaart
     */
    public CardSuit getSuit() {
        return suit;
    }

    /**
     * getter voor symbool van suit
     * @return het symbool van de kaart
     */
    public char getSuitSymbol() {
        return getSuit().getSymbol();
    }
    /**
     * getter voor value
     * @return de waarde van de kaart in tekst
     */
    public String getValue() {
        return value.getName();
    }

    /**
     * getter voor de punten van de kaart
     * @return de waarde van de kaart in getal
     */
    public int getPoints() {
        return value.getValue();
    }
    public String toString() {
        return getSuitSymbol() + " " + getValue();
    }
}
