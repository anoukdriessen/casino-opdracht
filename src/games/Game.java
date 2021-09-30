package games;

import java.util.Random;
import java.util.Scanner;

/**
 * Klasse Game is het beginpunt van alle spellen in het casino
 * ieder spel heeft een nummer, naam, een uitleg
 * ieder spel kan actief / niet-actief zijn
 */
public class Game {
    // boolean om bepaalde outputs te tonen die gebruikt kunnen worden als debug
    public static final boolean DEBUG = true;

    private final int number;
    private final String name;
    private final String uitleg;
    private final Random randomGenerator;

    private boolean isRunning;

    /**
     * Constructor voor klasse Game
     * @param name de naam van het spel
     */
    public Game(int number, String name, String uitleg){
        this.number = number;
        this.name = name;
        this.uitleg = uitleg;

        // bij aanmaken van game is het spel niet actief
        this.isRunning = false;

        // games kunnen werken met random getallen
        this.randomGenerator = new Random();
    }

    /**
     * Getter voor de naam van het spel
     * @return de naam van het spel
     */
    public String getName() {
        return this.name;
    }
    /**
     * Getter voor de uitleg van het spel
     * @return de uitleg van het spel
     */
    public String getUitleg() {
        return this.uitleg;
    }

    /**
     * Methode om te controleren of het spel actief is
     * @return spel actief (true) / niet actief (false)
     */
    public boolean isRunning() {
        return isRunning;
    }

    public void startGame() {
        this.isRunning = true;
    }

    public void playGame(Scanner input) {
        System.out.println("We gaan " + this.name + " spelen.");
    }

    public void endGame() {
        this.isRunning = false;
    }

    /**
     * Methode om random getal te generen binnen een gespecificeerde bound
     * @return een random getal binnen bound
     */
    public int getRandomIntegerNumber(int bound) {
        return randomGenerator.nextInt(bound);
    }

    @Override
    public String toString() {
        return "[" + this.number + "] " + this.name;
    }
}
