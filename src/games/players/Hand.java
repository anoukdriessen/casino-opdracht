package games.players;

import games.cards.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Hand is de klasse die de hand van de speler beschrijft
 * een hand is een lijst met kaarten
 */
public class Hand {
    public List<Card> cardsInHand;

    /**
     * Constructor van Hand
     * maakt een lege lijst (een lege hand)
     */
    public Hand() {
        this.cardsInHand = new ArrayList<>();
    }

    /**
     * Methode om een kaart toe te voegen aan Hand
     * @param cardToAdd de kaart die toegevoegd moet worden
     */
    public void addCard(Card cardToAdd) {
        this.cardsInHand.add(cardToAdd);
    }

    /**
     * Methode om de hand waarde op te vragen
     */
    public int getValue() {
        // start bij 0
        int value = 0;

        // voor iedere kaart voeg de waarde toe aan value
        for (Card card : cardsInHand) {
            value += card.getValue();
        }

        return value;
    }

    /**
     * Methode om de kaarten in hand op te vragen
     */
    public String show() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cardsInHand) {
            sb.append(" ");
            sb.append(card.show());
            sb.append(" ");
        }
        return sb.toString();
    }
}
