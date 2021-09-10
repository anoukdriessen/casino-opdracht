package nl.novi.casino.games.blackjack.players;

import nl.novi.casino.games.blackjack.Card;
import nl.novi.casino.games.blackjack.Deck;

import java.util.ArrayList;

import static nl.novi.casino.Main.DEBUGMODE;
import static nl.novi.casino.StringLib.*;

/**
 * Dealer van het spel BlackJack gebaseerd op de interface
 */
public class Dealer implements Players {
    // dealer heeft de naam Dealer
    private String name;

    // dealer heeft punten
    private int points;

    // dealer heeft een lege hand
    private ArrayList<Card> hand;

    // kan stay / hit / bust zijn
    boolean isStaying, isHit, isBust;

    public static void main(String[] args) {
        // test klasse dealer
        Dealer d = new Dealer();
        System.out.println(d.toString());
    }

    /**
     * Constructor voor dealer
     * maakt hand een lege arraylist die gevuld kan worden met kaarten
     * set punten naar nul
     */
    public Dealer(){
        this.name = DEALER.charAt(0) + DEALER.substring(1).toLowerCase();
        this.points = 0;
        this.hand = new ArrayList<>();
    }

    /**
     * Getter for points
     * @return the points of the dealer
     */
    @Override
    public int getPoints() {
        return this.points;
    }

    /**
     * Method to preform a move
     * Move = hit / stay
     * @param deck the deck to preform a move on
     * @param move the move to do
     */
    @Override
    public void performMove(Deck deck, String move) {
        this.isStaying = false;
        this.isHit = false;

        if (move.equalsIgnoreCase(HIT)) {
            this.isHit = true;

            // preform hit on deck
        } else if (move.equalsIgnoreCase(STAY)) {
            this.isStaying = true;

            // preform stay, do nothing
        }

        // check if dealer is bust
    }

    /**
     * Method add Cards to Hand
     * @param cards the cards to add to hand
     */
    @Override
    public void addCardsToHand(Card[] cards) {
        for (int i = 0; i < cards.length; i++) {
            System.out.println(ADDCARDTODECK);
            hand.add(cards[i]);

            if (DEBUGMODE) {
                System.out.println("CARD " + i + " " + cards[i]);
            }
        }
    }

    /**
     * Method to add point to dealer
     * @param pointsToAdd the points to add
     */
    @Override
    public void addPoints(int pointsToAdd) {
        this.points += pointsToAdd;
    }

    /**
     * Boolean to check if dealer is Staying
     * @return true if dealer is STAYING
     */
    @Override
    public boolean isStaying() {
        return this.isStaying;
    }

    /**
     * Boolean to check if dealer is Bust
     * @return true if dealer is BUST
     */
    @Override
    public boolean isBust() {
        return this.isBust;
    }

    /**
     * Getter for the hand value
     * @return the hand value as integer
     */
    @Override
    public int getHandValue() {
        // voor iedere kaart in hand
        // tel de punten op
        // retourneer de punten
        return 0;
    }

    /**
     * Getter for the Cards in the hand
     * @return the cards as a String
     */
    @Override
    public String showHand() {
        if (this.hand.isEmpty()) {
            return EMPTYHAND;
        } else {
            StringBuilder out = new StringBuilder();
            // voor iedere kaart in hand
            for (Card c : this.hand) {
                out.append(c.toString());
            }
            // retourneer de output
            return out.toString();
        }
    }

    @Override
    public String toString() {
        return this.name + " " + this.points + POINTS + showHand();
    }
}
