package games.cards;

import java.util.Collections;
import java.util.Stack;

/**
 * Klasse blackjack deck is onderdeel van het spel Blackjack
 */
public class BlackjackDeck {
    // stack werkt als een soort wachtrij
    private Stack<Card> cards;

    // er zijn 4 cardsuits
    private final static Suit DIAMONDS = new Suit("ruiten", '\u2666', "rood");
    private final static Suit SPADES = new Suit("schoppen", '\u2660', "zwart");
    private final static Suit HEARTS = new Suit("harten", '\u2665', "rood");
    private final static Suit CLUBS = new Suit("klaveren", '\u2663', "zwart");

    public static void main(String[] args) {
        BlackjackDeck deck = new BlackjackDeck();
        System.out.println(deck);
        deck.shuffle();
        System.out.println(deck);
    }
    /**
     * Constructor voor het Deck
     * maak de suits en values aan en vul deze in de deck
     */
    public BlackjackDeck() {
        Suit[] cardSuits = new Suit[] {
                DIAMONDS, SPADES, HEARTS, CLUBS
        };

        Value[] cardValues = new Value[] {
                new Value("twee", 2),
                new Value("drie", 3),
                new Value("vier", 4),
                new Value("vijf", 5),
                new Value("zes", 6),
                new Value("zeven", 7),
                new Value("acht", 8),
                new Value("negen", 9),
                new Value("tien", 10),
                new Value("boer", 10),
                new Value("koningin", 10),
                new Value("koning", 10),
        };

        cards = new Stack<>();
        // vul het kaartendeck
        for (Suit suit : cardSuits) {
            // voor ieder cardsuit
            for (Value value : cardValues) {
                // voor iedere waarde
                // voeg een kaart toe aan deck
                cards.add(new Card(suit, value));
            }
        }
    }

    /**
     * Methode om het deck te schudden
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Methode om te controleren of het deck empty is
     */
    public boolean isEmpty() {
        return this.cards.isEmpty();
    }

    /**
     * Methode om een nieuwe kaart van de stapel te pakken
     */
    public Card getNextCard() {
        return cards.pop();
    }

    /**
     * Methode om het deck te printen
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : this.cards) {
            sb.append(card);
        }
        return sb.toString();
    }
}
