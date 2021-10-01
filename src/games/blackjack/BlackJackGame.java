package games.blackjack;

import games.Game;
import games.cards.BlackjackDeck;
import games.players.BlackjackPlayer;
import games.players.BlackjackDealer;

import java.util.Scanner;

/**
 * Klasse BlackJackGame is de tweede opdracht / spel van het casino
 * het is een bekend casino spel, ook wel bekend als 21e
 */
public class BlackJackGame extends Game {
    private final static String HIT = "hit";
    private final static String STAY = "stay";

    private BlackjackDeck deck;
    private BlackjackPlayer player;
    private BlackjackDealer dealer;

    public BlackJackGame(int number, String name, String uitleg) {
        super(number, name, uitleg);
        // maak een nieuw deck
         this.deck = new BlackjackDeck();
    }

    /**
     * Methode om het spel te spelen
     */
    @Override
    public void playGame(Scanner input) {
        System.out.println("We gaan " + super.getName() + " spelen");
        startGame();

        player = new BlackjackPlayer("PLAYER");
        dealer = new BlackjackDealer("DEALER");

        // shuffel het deck
        this.deck.shuffle();

        // geef dealer een kaart
        this.dealer.addCardsToHand(deck.getNextCard());
        // geef speler twee kaart
        this.player.addCardsToHand(deck.getNextCard(), deck.getNextCard());

        while(isRunning()){
            playRound(input);
        }
    }

    public void playRound(Scanner input) {
        showCurrentState();

        boolean dealerIsBust = this.dealer.isBust();
        boolean playerIsBust = this.player.isBust();

        boolean dealerIsStaying = this.dealer.isStaying();
        boolean playerIsStaying = this.player.isStaying();

        boolean playerHasHigherValue = player.getPoints() > dealer.getPoints();
        boolean playerHasLowerOrEqualValue = player.getPoints() <= dealer.getPoints();

        // optie 1.
            // dealer is bust
            // OF dealer is staying
            // EN speler heeft hogere waarde dan dealer
        if (dealerIsBust || dealerIsStaying && playerHasHigherValue) {
            System.out.println("Je hebt GEWONNEN!");
            endGame();
            return;
        }

        // optie 2.
            // player is bust
            // OF player is staying
            // EN speler heeft een lagere of gelijke waarde als dealer
        if (playerIsBust || playerIsStaying && playerHasLowerOrEqualValue) {
            System.out.println("Je hebt VERLOREN!");
            endGame();
            return;
        }

        // optie 3.
            // player is not staying
            // player preforms move
        if (!playerIsStaying) {
            String move = getNextMove(input);
            player.doMove(deck, move);
        }
        // optie 4.
            // dealer is not staying
            // player is not bust
            // dealer preforms move
        if (!dealerIsStaying && !playerIsBust) {
             dealer.doMove(deck);
        }
    }

    private void showCurrentState() {
        System.out.println(""); // newline
        System.out.println(this.dealer); // dealer to string
        System.out.println(""); // newline
        System.out.println(this.player); // player to string
    }

    /**
     * Methode om de volgende stap van de gebruiker op te halen
     * @param input de input die gebruikt moet worden
     * @return de keuze van de gebruiker
     */
    private String getNextMove(Scanner input) {
        while (true) {
            System.out.println("\nWat wil je doen? ["+HIT+"] of ["+STAY+"]");
            String choice = input.nextLine();
            boolean inputIsHitOrStay = choice.equalsIgnoreCase(HIT) || choice.equalsIgnoreCase(STAY);
            if (inputIsHitOrStay) {
                return choice;
            }
        }
    }
}
