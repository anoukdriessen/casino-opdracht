package games.blackjack;

import games.cards.LowBlackjackDeck;
import games.cards.SimpleBlackjackDeck;

/**
 * Klasse LowDeck Blackjack is een variant die we ‘LowDeckBlackjack’ noemen
 * waarbij wordt gespeeld met een kaartendeck
 * bestaande uit alle kaarten met waardes tussen 2 en 6 uit drie losse decks.
 */
public class LowDeckBlackjackGame extends BlackJackGame {

    public LowDeckBlackjackGame(int number, String name, String uitleg) {
        super(number, name, uitleg);

        // maak een nieuw deck
        super.deck = new LowBlackjackDeck();
    }
}
