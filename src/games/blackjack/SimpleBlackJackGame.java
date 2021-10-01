package games.blackjack;

import games.cards.SimpleBlackjackDeck;

public class SimpleBlackJackGame extends BlackJackGame{

    public SimpleBlackJackGame(int number, String name, String uitleg) {
        super(number, name, uitleg);

        // maak een nieuw deck
         super.deck = new SimpleBlackjackDeck();
    }
}
