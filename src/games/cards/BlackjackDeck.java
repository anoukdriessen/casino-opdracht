package games.cards;

import java.util.Collections;
import java.util.Stack;

/**
 * Klasse blackjack deck is onderdeel van het spel Blackjack
 */
public abstract class BlackjackDeck {
    // stack werkt als een soort wachtrij
    protected Stack<Card> cards;

    // er zijn 4 cardsuits
    private final static Suit DIAMONDS = new Suit("ruiten", '\u2666', "rood");
    private final static Suit SPADES = new Suit("schoppen", '\u2660', "zwart");
    private final static Suit HEARTS = new Suit("harten", '\u2665', "rood");
    private final static Suit CLUBS = new Suit("klaveren", '\u2663', "zwart");

    protected final Suit[] cardSuits = new Suit[] {
            DIAMONDS, SPADES, HEARTS, CLUBS
    };
    protected final Value[] cardValues = new Value[] {
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

    /**
     * Constructor voor het Deck
     * maak een stack aan
     */
    public BlackjackDeck() {
        cards = new Stack<>();
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
