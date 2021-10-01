package games.slotmachines;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Slotmachines heeft drie variaties met verschillende settings
 * iedere variatie heeft een naam, aantal wielen en een prijs om te spelen
 */
public abstract class SlotMachineSettings {
    String name;
    int wheels;
    int cost;
    int credits;

    // er zijn 5 mogelijke symbolen
    protected final static char DOLLAR = '\u0024';
    protected final static char YINYANG = '\u262F';
    protected final static char SPADE = '\u2664';
    protected final static char HEART = '\u2661';
    protected final static char CLUB = '\u2667';

    protected char[] symbols = new char[] {DOLLAR, YINYANG, SPADE, HEART, CLUB};

    public SlotMachineSettings(String name, int wheels, int cost) {
        this.name = name;
        this.wheels = wheels;
        this.cost = cost;
    }

    public boolean playGame() {
        System.out.println("... je trekt aan de hendel ...");
        System.out.println("LET'S GET SPINNING");
        // controleer of een speler gewonnen heeft
        boolean won = hasPlayerWon();
        return won;
    }

    public boolean hasPlayerWon() {
        Random r = new Random();
        List<Character> wheelSymbols = new ArrayList<>();

        for (int i = 0; i < wheels; i++) {
            // voor ieder wiel voeg een random geselecteerd symbool toe
            char symbolOnWheel = symbols[r.nextInt(symbols.length)];
            System.out.print("[ " + symbolOnWheel + " ] ");
            wheelSymbols.add(symbolOnWheel);
        }
        char prevSymbol = ' ';
        boolean allTheSame = true;
        for (char symbol : wheelSymbols) {
            if (prevSymbol == ' ') {
                // first symbol
                prevSymbol = symbol;
            } else {
                // other symbols
                if (symbol == prevSymbol) {
                    // is gelijk aan vorige symbool
                    // doe niets
                } else {
                    // is niet gelijk aan vorige symbool
                    allTheSame = false;
                }
            }
        }

        // aan het einde van loop nog allTheSame
        // geef credit
        if (allTheSame) {
            setCreditsToGive(prevSymbol);
        }
        return allTheSame;
    }

    @Override
    public String toString() {
        return this.name + " met " + this.wheels + " wielen kost (" + this.cost + ")";
    }

    public int setCreditsToGive(char winningSymbol) {
        String message;
        switch (winningSymbol) {
            case DOLLAR:
                message = "JACKPOT!";
                this.credits = this.cost + 420;
                break;
            case YINYANG:
                message = "SMALL WIN";
                this.credits = this.cost + 25;
                break;
            case SPADE:
                message = "MEDIUM WIN";
                this.credits = this.cost + 50;
                break;
            case HEART:
                message = "LOVE IS ON YOUR SIDE";
                this.credits = this.cost + 69;
                break;
            case CLUB:
                message = "YOU ARE IN LUCK";
                this.credits = this.cost + 200;
                break;
            default:
                message = "";
        }
        System.out.println("\n" + message + " je hebt " + this.credits + " credits gewonnen");
        return this.credits;
    }

    public int getCreditsToGive() {
        return this.credits;
    }
}
