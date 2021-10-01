package games.players;

import games.BlackjackDeck;
import games.cards.Card;

/**
 * Klasse Blackjack Player is een onderdeel van het spel Blackjack
 */
public class BlackjackPlayer extends Player {
    private final static String HIT = "HIT";
    private final static String STAY = "STAY";

    private Hand hand;
    private boolean staying;

    /**
     * Constructor voor klasse Blackjack Player
     */
    public BlackjackPlayer(String name) {
        super(name);
        this.hand = new Hand();
    }

    /**
     * Methode om een actie uit te voeren op het Deck
     * @param deck het kaarten deck
     * @param moveToDo de actie om uit te voeren
     */
    public void doMove(BlackjackDeck deck, String moveToDo) {
        boolean moveIsHit = moveToDo.equalsIgnoreCase(HIT);
        System.out.print("Je koos: ");

        if (moveIsHit) {
            getCardFromDeck(deck);
            System.out.println(HIT);
        } else {
            // move is Stay
            stay();
            System.out.println(STAY);
        }
    }

    /**
     * Methode om een kaart van een deck te pakken
     */
    public void getCardFromDeck(BlackjackDeck deck) {
        this.hand.addCard(deck.getNextCard());
    }

    /**
     * Methode om de speler STAY te laten kiezen
     */
    public void stay() {
        this.staying = true;
    }

    /**
     * Methode om een of meerdere kaarten aan een hand toetevoegen
     */
    public void addCardsToHand(Card... cardsToAdd) {
        // voor iedere kaart die toegevoegd moet worden
        for (Card card : cardsToAdd) {
            this.hand.addCard(card);
        }
    }

    /**
     * Getter voor staying
     * @return player is staying
     */
    public boolean isStaying() {
        return this.staying;
    }

    /**
     * Getter voor bust
     * @return de value van de totale hand is groter dan 21
     */
    public boolean isBust() {
        return this.getPoints() > 21;
    }

    /**
     * Getter voor de handvalue van de speler
     */
    @Override
    public int getPoints() {
        return this.hand.getValue();
    }

    /**
     * to String methode voor de speler
     */
    @Override
    public String toString() {
        return this.getName() + " heeft " + this.getPoints() + " punten\n" +
                "Kaarten in hand: " + this.hand.show();
    }
}
