package nl.novi.casino.games;

import java.util.Scanner;
import nl.novi.casino.Mechanics;

import static nl.novi.casino.Main.DEBUGMODE;
import static nl.novi.casino.StringLib.*;

/**
 * OPDRACHT 1. Game klasse HIGHER AND LOWER
 * spel waarbij gebruiker een getal moet raden
 * Spel bestaat uit mechanics (start/stop spel & definieer input)
 */
public class HigherLowerGame {
    private final Mechanics m;

    private int guesses, numberToGuess;
    private boolean isAnswerCorrect;

    /**
     * Constructor definieert de mechanics met userinput
     * @param userInput de Scanner die gebruikt moet worden
     */
    public HigherLowerGame(Scanner userInput) {
        this.m = new Mechanics(userInput);
    }

    /**
     * Methode die aangeroepen wordt om het spel te starten
     */
    public void playGame(){
        // start het spel, welkomst bericht wordt getoond
        welcome();

        // de beginwaardes worden ingesteld
        setUpNewGame();

        // speel spel zolang spel actief is
        while (isActiveGame()) {
            playRound();
        }

    }

    /**
     * Methode print welkomstbericht voor spel Higher and Lower
     */
    public void welcome(){
        this.m.startGame(HIGHERANDLOWER, HTP_HIGHERANDLOWER);
    }

    /**
     * Methode om de begin waardes te (re)setten
     * er wordt een random getal gegenereerd tussen de 0 en 100
     * isAnswerCorrect en guesses wordt op default waarde gezet
     */
    public void setUpNewGame(){
        this.numberToGuess = this.m.getRandomIntegerNumber(100);
        this.isAnswerCorrect = false;
        this.guesses = 0;
    }

    /**
     * Methode om te controleren of Higher Lower actieve game is
     */
    public boolean isActiveGame(){
        return this.m.isGameIsRunning();
    }

    /**
     * Methode om een ronde van Higher and Lower te spelen
     */
    public void playRound() {
        int userGuessed;
        // speel zolang het antwoord niet juist is
        while (!isAnswerCorrect) {
            // start met raden
            System.out.println(MAKEAGUESS);

            // speler raad een nummer
            if (DEBUGMODE) {
                // voer 3 guesses uit 1 is te hoog, 2 is te laag en 4 is correct
                if (guesses == 0) {
                    userGuessed = numberToGuess + 1;
                }
                else if (guesses == 1) {
                    userGuessed = numberToGuess - 1;
                }
                else {
                    userGuessed = numberToGuess;
                }
                System.out.printf(USERRESULT, userGuessed);

            } else {
                while (inputIsNotInt()) {
                    // input is niet valid
                    String s = getInput().next();
                    System.out.printf(NOTVALIDNUMBER, s);
                }
                // input is valid
                userGuessed = getInput().nextInt();
                System.out.printf(USERRESULT, userGuessed);
            }

            // verhoog de gemaakte guesses
            guesses++;

            // controleer het antwoord
            isAnswerCorrect = userGuessed == numberToGuess;

            if (!isAnswerCorrect) {
                // antwoord is niet juist, kan te hoog of te laag zijn

                boolean guessToHigh = userGuessed > numberToGuess;
                if (guessToHigh) {
                    System.out.println(TOOHIGH);
                } else {
                    System.out.println(TOOLOW);
                }

            } else {
                // antwoord is juist
                if (guesses == 1) {
                    System.out.printf(CORRECT, guesses);
                } else {
                    System.out.printf(CORRECT + "s", guesses);
                }
            }
        }
        m.endGame();
    }

    /**
     * Methode om te controleren of input integer is
     * @return true als input vanuit Scanner integer is
     */
    public boolean inputIsNotInt() {
        return !getInput().hasNextInt();
    }

    /**
     * Methode om de Scanner die gebruikt moet worden weer te geven
     * @return Scanner toUse
     */
    public Scanner getInput() {
        return this.m.getInput();
    }
}
