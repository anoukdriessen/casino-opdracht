package nl.novi.casino.games;

import java.util.Scanner;
import nl.novi.casino.Mechanics;

import static nl.novi.casino.Main.DEBUGMODE;
import static nl.novi.casino.StringLib.*;

/**
 * OPDRACHT 2. Game klasse BLACK_JACK_GAME
 * spel waarbij gebruiker blackjack gaat spelen
 * Spel bestaat uit mechanics (start/stop spel & definieer input)
 */
public class BlackJackGame {
    private final Mechanics m;

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
//        welcome();

        // VRAAG SPELER OM NAAM

        // de beginwaardes worden ingesteld
//        setUpNewGame();

        // speel spel zolang spel actief is
//        while (isActiveGame()) {
//            playRound();
//        }

    }

}
