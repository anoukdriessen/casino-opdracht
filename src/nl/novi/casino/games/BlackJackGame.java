package nl.novi.casino.games;

import java.util.Scanner;
import nl.novi.casino.Mechanics;
import nl.novi.casino.games.blackjack.Card;
import nl.novi.casino.games.blackjack.Deck;
import nl.novi.casino.games.blackjack.players.Dealer;
import nl.novi.casino.games.blackjack.players.Player;
import nl.novi.casino.games.blackjack.players.Players;

import static nl.novi.casino.Main.DEBUGMODE;
import static nl.novi.casino.StringLib.*;

/**
 * OPDRACHT 2. Game klasse BLACK_JACK_GAME
 * spel waarbij gebruiker blackjack gaat spelen
 * Spel bestaat uit mechanics (start/stop spel & definieer input)
 */
public class BlackJackGame {
    private final Mechanics m;

    private Player player;
    private Dealer dealer;

    private Deck deck;

    /**
     * Constructor definieert de mechanics met userinput
     * @param userInput de Scanner die gebruikt moet worden
     */
    public BlackJackGame(Scanner userInput) {
        this.m = new Mechanics(userInput);
    }

    /**
     * Methode die aangeroepen wordt om het spel te starten
     */
    public void playGame(){
        // start het spel, welkomst bericht wordt getoond
        welcome();

        // stel spel in voor start
        setUpNewGame();

        // speel spel zolang spel actief is
        int round = 1;
        while (isActiveGame()) {
            System.out.println("\n" + ROUND + round);

            // eerste ronde
            if (round == 1) {
                Card toGive;

                // speler krijgt 2 kaarten van stapel
                this.player.givePlayerCard(deck);
                this.player.givePlayerCard(deck);

                // dealer krijgt 1 kaart van stapel
                giveDealerACard();
            }

            // print tussenstand
            getStats();

            // speler is aan zet
            // laat de speler een keuze maken
            System.out.println(CHOICE);

            String userChoice = letPlayerChoose();
            String dealerChoice = "";

            this.player.performMove(this.deck, userChoice);
            boolean playerHasBJ = this.player.getHandValue() == 21;

            if (this.player.isBust()) {
                // einde spel
                this.m.endGame();
                break;
            }
            if (playerHasBJ) {
                // player has BlackJack / 21 points
                System.out.println(YOU_HAVE + BLACKJACK);
                System.out.println(YOU_HAVE + WON + GAME);
                this.m.endGame();
                break;
            }

            // dealer is aan zet
            // laat de dealer een keuze maken
            if (this.dealer.getHandValue() < 17) {
                // dealer heeft minder dan 17 punten
                dealerChoice = HIT;
            } else {
                // dealer heeft meer dan 17 punten
                dealerChoice = STAY;
            }

            this.dealer.performMove(this.deck, dealerChoice);
            boolean dealerHasBJ = this.dealer.getHandValue() == 21;

            getStats();

            if (this.dealer.isBust()) {
                // einde spel
                this.m.endGame();
                break;
            }
            if (dealerHasBJ) {
                System.out.println(this.dealer.getName() + " has " + BLACKJACK);
                System.out.println(YOU_HAVE + LOST + GAME);
                this.m.endGame();
                break;
            }
            boolean playerHasLessOrEqualPoints = this.player.getHandValue() <= this.dealer.getHandValue();
            boolean lessThen21Points = this.player.getHandValue() < 21 && this.dealer.getHandValue() < 21;
            boolean dealerHasLessThanPlayer = this.dealer.getHandValue() < this.player.getHandValue();

            if (this.player.isStaying()) {
                // speler had gekozen voor stay
                if (playerHasLessOrEqualPoints && lessThen21Points) {
                    System.out.println(YOU_HAVE + "less or equal to " + this.dealer.getHandValue() + POINTS);
                    // dealer won
                    System.out.println(YOU_HAVE + LOST + GAME);
                    this.m.endGame();
                    break;
                } else {
                    // player won
                    System.out.println(YOU_HAVE + WON + GAME);
                    this.m.endGame();
                    break;
                }
            } else if (this.dealer.isStaying()) {
                // dealer had gekozen voor stay
                if (dealerHasLessThanPlayer) {
                    System.out.println(YOU_HAVE + WON + GAME);
                } else  {
                    System.out.println(YOU_HAVE + LOST + GAME);
                }
            }
            round++;
        }

    }

    /**
     * Methode print welkomstbericht voor spel Blackjack
     */
    public void welcome(){
        this.m.startGame(BLACKJACK, HTP_BLACKJACK);
    }

    /**
     * Methode om de Scanner die gebruikt moet worden weer te geven
     * @return Scanner toUse
     */
    public Scanner getInput() {
        return this.m.getInput();
    }

    /**
     * Methode om het spel klaar te zetten
     */
    public void setUpNewGame(){
        // VRAAG SPELER OM NAAM
        System.out.print("Wat is je naam: ");
        // maak speler aan
        if (DEBUGMODE) {
            this.player = new Player("Anouk");
            System.out.println("speler vult naam in");
        } else {
            this.player = new Player(getInput().next());
        }
        // maak dealer aan
        this.dealer = new Dealer();

        getCardDeck();

//        if (DEBUGMODE) {
//            System.out.println("\nplayer aangemaakt: " + player);
//            System.out.println("dealer aangemaakt: " + dealer);
//            System.out.println("deck aangemaakt: " + deck);
//        }
    }

    /**
     * Methode om het kaart deck aan te maken
     * de methode schud ook de kaarten
     */
    public void getCardDeck() {
        // Maak deck aan met daarin alle benodigde kaarten
        this.deck = new Deck();

        // schud de kaarten
        this.deck.shuffle();
    }

    /**
     * Methode om te controleren of Blackjack actieve game is
     */
    public boolean isActiveGame(){
        return this.m.isGameIsRunning();
    }

    /**
     * Methode om de dealer een kaart te geven
     * en deze naar de terminal te printen
     */
    public void giveDealerACard() {
        Card toGive = deck.getCard();
        this.dealer.addCardToHand(deck.getCard());
        System.out.println(this.dealer.getName() + GOT + toGive);
    }

    public void getStats() {
        System.out.println();
        System.out.println(this.player.getName() + " has " + this.player.getHandValue() + POINTS);
        System.out.println(this.dealer.getName() + " has " + this.dealer.getHandValue() + POINTS);
    }

    public String letPlayerChoose() {
        while (getInput().hasNext()) {
            String next = getInput().next();
            boolean validInput = next.equalsIgnoreCase(HIT) || next.equalsIgnoreCase(STAY);
            if (validInput) {
                return next;
            } else {
                System.out.println(INVALID_CHOICE);
            }
        }
        return null;
    }
}
