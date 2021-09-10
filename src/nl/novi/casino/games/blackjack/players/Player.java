package nl.novi.casino.games.blackjack.players;

import nl.novi.casino.games.blackjack.Card;
import nl.novi.casino.games.blackjack.Deck;

import java.util.ArrayList;

import static nl.novi.casino.Main.DEBUGMODE;
import static nl.novi.casino.StringLib.*;

/**
 * Speler van het spel BlackJack gebaseerd op de interface
 */
public class Player implements Players {
    // speler heeft een naam
    private String name;

    // een speler heeft punten
    private int points;

    // een speler heeft een lege hand
    private ArrayList<Card> hand;

    // kan stay / hit / bust zijn
    boolean isStaying, isHit, isBust;

    public static void main(String[] args) {
        // test klasse player
        Player p = new Player("Anouk");
        System.out.println(p.toString());
    }

    /**
     * Constructor voor player
     * geeft speler een naam
     * maakt hand een lege arraylist die gevuld kan worden met kaarten
     * set punten naar nul
     */
    public Player(String name){
        this.name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
        this.points = 0;
        this.hand = new ArrayList<>();
    }

    /**
     * Getter for points
     * @return the points of the player
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

        // check if user is bust
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
     * Method to add point to player
     * @param pointsToAdd the points to add
     */
    @Override
    public void addPoints(int pointsToAdd) {
        this.points += pointsToAdd;
    }

    /**
     * Boolean to check if the player is Staying
     * @return true if the player is STAYING
     */
    @Override
    public boolean isStaying() {
        return this.isStaying;
    }

    /**
     * Boolean to check if the player is Bust
     * @return true if the player is BUST
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
