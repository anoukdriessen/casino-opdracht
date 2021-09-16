package nl.novi.casino.games.blackjack;

import java.util.Collections;
import java.util.Stack;

import static nl.novi.casino.Main.DEBUGMODE;
import static nl.novi.casino.StringLib.*;

/**
 * Klasse Deck is het kaartspel dat gebruikt wordt voor Blackjack
 */
public class Deck {
    private Stack<Card> cards;

    /**
     * Constructor van Deck maakt de mogelijke kaarten aan
     * Er zijn vier mogelijke cardsuits
     * DIAMONDS / SPADES / HEARTS / CLUBS
     * Iedere kaart heeft een waarde
     */
    public Deck() {
        // maak cardsuits aan
        CardSuit[] cardSuits = new CardSuit[4];
        // vul de cardsuits
        int color = 0;
        for (int i = 0; i < cardSuits.length; i++) {
            cardSuits[i] = new CardSuit(CARDSUITS[i], UNI_SUITS[i], COLORS[color]);
            if (i == 1) {
                color++;
            }
        }
        // maak cardvalues aan
        CardValue[] cardValues = new CardValue[12];
        // vul de cardvalues
        for (int i = 0; i < cardValues.length; i++) {
            cardValues[i] = new CardValue(CARDS[i], VALUES[i]);
        }

        // kaarten deck aanmaken
        cards = new Stack<>();
        // voor iedere suit
        for (CardSuit cs : cardSuits) {
            // voor iedere waarde
            for (CardValue cv : cardValues) {
                // maak een kaart aan en voeg die toe aan de stack
                cards.add(new Card(cs, cv));
            }
        }

        if (DEBUGMODE) {
//            for(CardSuit cs : cardSuits) { System.out.println(cs); }
//            for(CardValue cv : cardValues) { System.out.println(cv); }
//            for (Card c : cards) { System.out.println(c); }
        }
    }

    /**
     * Methode die de deck van kaarten shud
     * met hulp van de Collections.shuffle methode
     */
    public void shuffle() {
//        if (DEBUGMODE) {
//            System.out.println("Voor: ");
//            for (int i = 0; i <= 5; i++) {
//                System.out.println(this.cards.get(i));
//            }
//        }
        Collections.shuffle(this.cards);
//        if (DEBUGMODE) {
//            System.out.println("Na: ");
//            for (int i = 0; i <= 5; i++) {
//                System.out.println(this.cards.get(i));
//            }
//        }
        System.out.println(SHUFFELED);
    }

    /**
     * Methode om kaart van stapel te pakken
     * @return de kaart
     */
    public Card getCard() {
        Card toGive = this.cards.pop();
//        if (DEBUGMODE) {
//            System.out.println(toGive);
//        }
        return toGive;
    }

    @Override
    public String toString() {
        return "Deck met " + this.cards.size() + " kaarten";
    }
}
