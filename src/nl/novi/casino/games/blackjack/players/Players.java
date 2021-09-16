package nl.novi.casino.games.blackjack.players;

import nl.novi.casino.games.blackjack.Card;
import nl.novi.casino.games.blackjack.Deck;

/**
 * Players Interface
 * there are two types of players:
 * - player
 * - dealer
 *
 * they both get points
 * preform moves
 * have an empty hand
 * get cards in hand
 * get points
 * can STAY
 * can HIT
 *
 * we can get the hand value
 * and show hand
 */
public interface Players {
    /**
     * Getter for points
     * @return the points of the player
     */
    public int getPoints();

    /**
     * Method to preform a move
     * @param deck the deck to preform a move on
     * @param move the move to do
     */
    public void performMove(Deck deck, String move);

    /**
     * Method add Card to Hand
     * @param card the card to add to hand
     */
    public void addCardToHand(Card card);

    /**
     * Method to add point to player
     * @param pointsToAdd the points to add
     */
    public void addPoints(int pointsToAdd);

    /**
     * Boolean to check if the player is Staying
     * @return true if the player is STAYING
     */
    public boolean isStaying();

    /**
     * Boolean to check if the player is Bust
     * @return true if the player is BUST
     */
    public boolean isBust();

    /**
     * Getter for the hand value
     * @return the hand value as integer
     */
    public int getHandValue();

    /**
     * Getter for the Cards in the hand
     * @return the cards as a String
     */
    public String showHand();
}

