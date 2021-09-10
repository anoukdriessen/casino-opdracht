package nl.novi.casino;

import java.util.Random;
import java.util.Scanner;
import static nl.novi.casino.StringLib.*;

/**
 * De Mecahnics achter de games
 *
 * bevat een controle of de game momenteel actief is
 * bevat een inputScanner die de input van de game bijhoudt
 */
public class Mechanics {
    private boolean gameIsRunning;
    private Scanner in;
    private final Random random;

    /**
     * Bij het aanmaken van mechanics is gameIsRunning false by default
     * & Scanner wordt ingesteld
     * @param inputToUse de scanner die gebruikt moet worden
     */
    public Mechanics(Scanner inputToUse) {
        this.gameIsRunning = false;
        this.in = inputToUse;

        this.random = new Random();
    }

    /**
     * Methode om te controleren of de game nog actief is
     * @return true if game is running
     */
    public boolean isGameIsRunning() {
        return this.gameIsRunning;
    }

    /**
     * Getter for input
     */
    public Scanner getInput(){
        return this.in;
    }

    /**
     * Als startGame aangeroepen wordt wordt de gameIsRunning naar true geset
     * & wordt een welkomsbericht getoond per bericht
     * in dit bericht staat hoe het spel gespeeld wordt
     * @param gameName spelnaam
     * @param howToPlay spelbeschrijving
     */
    public void startGame(String gameName, String howToPlay) {
        this.gameIsRunning = true;
        printWelcomeMessage(gameName, howToPlay);
    }

    /**
     * Methode die een gestyled welkomstbericht print
     * @param gameName naam van het spel
     * @param howToPlay uitleg van het spel
     */
    public void printWelcomeMessage(String gameName, String howToPlay) {
        System.out.println(LINE);
        System.out.println(NEWLINE + WELCOME + gameName + BLANKSPC);
        System.out.println(NEWLINE + howToPlay);
        System.out.println(NEWLINE + GOODLUCK);
        System.out.println(LINE);
    }

    /**
     * Methode om een random getal te genereren
     */
    public int getRandomIntegerNumber() {
        return random.nextInt();
    }

    /**
     * Methode om een random getal te genereren binnen bound
     */
    public int getRandomIntegerNumber(int bound) {
        return random.nextInt(bound);
    }

    /**
     * Methode om het actieve spel te stoppen
     */
    public void endGame() {
        this.gameIsRunning = false;
    }

}
