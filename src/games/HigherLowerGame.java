package games;

import java.util.Scanner;

/**
 * Klasse HigherLowerGame is de eerste game van het Casino
 * het is een spel waarbij een gebruiker een getal moet raden
 */
public class HigherLowerGame extends Game {
    private int guesses, numberToGuess;
    private boolean correct;

    /**
     * Constructor voor Hoger en Lager spel
     * @param number nummer van het spel
     * @param name naam van het spel
     * @param uitleg uitleg van het spel
     */
    public HigherLowerGame(int number, String name, String uitleg) {
        super(number, name, uitleg);
        this.guesses = 0;
        this.correct = false;
        this.numberToGuess = getRandomIntegerNumber(100);
    }

    /**
     * Methode om het spel te spelen
     */
    @Override
    public void playGame(Scanner input) {
        System.out.println("We gaan " + super.getName() + " spelen");
        startGame();

        System.out.println("Ik heb een getal tussen de 0 en 100, succes!");

        while(isRunning()) {
            playRound(input);
        }

    }

    /**
     * Speel een ronde van het spel
     * @param input de scanner die gebruikt moet worden
     */
    public void playRound(Scanner input) {
        int thisGuess = 0;

        // speel zolang het antwoord niet juist is
        while (!correct) {
            // laat de speler raden
            guesses = guesses + 1;
            System.out.print("[Ronde " + guesses + "] Welk getal denk je dat het is: ");

            // speler raad een nummer
            if(DEBUG) {
                thisGuess = genereerAntwoorden(thisGuess);
            } else {
                while (!input.hasNextInt()) {
                    // input is niet valid
                    System.out.println("Je hebt " + input.next() + " ingevoerd, " +
                            "dit is niet geldig, voeg een nummer tussen de 0 en 100 in.");
                }

                // input is valid
                thisGuess = input.nextInt();
                System.out.println("Je hebt " + input.next() + "ingevoerd");
            }

            // controleer het antwoord
            correct = thisGuess == numberToGuess;

            if (!correct) {
                // antwoord is niet juist (te hoog / te laag)
                boolean toHigh = thisGuess > numberToGuess;
                if (toHigh) {
                    // guess is te hoog
                    System.out.println(thisGuess + " is te hoog!");
                } else {
                    System.out.println(thisGuess + " is te laag!");
                }
            } else {
                // het antwoord is juist
                System.out.println(thisGuess + " is correct!");
                boolean firstGuess = guesses == 1;
                if (firstGuess) {
                    System.out.println("Je hebt " + numberToGuess + " geraden in 1 ronde");
                } else {
                    System.out.println("Je hebt " + numberToGuess + " geraden in " + guesses + " rondes");
                }

                // stop het spel
                endGame();
            }
        }
    }

    /**
     * Methode om antwoorden te genereren als test
     * @param thisGuess de huidige guess van de gebruiker
     * @return het gegenereerde antwoord, te hoog, te laag of correct afhankelijk van ronde
     */
    public int genereerAntwoorden(int thisGuess) {
        boolean ronde1 = guesses == 1;
        boolean ronde2 = guesses == 2;

        if (ronde1) {
            // ronde 1 = te hoog
            thisGuess = numberToGuess + 1;
            return thisGuess;
        } else if (ronde2) {
            // ronde 2 = te laag
            thisGuess = numberToGuess - 1;
            return thisGuess;
        } else {
            // ronde 3 = correct
            thisGuess = numberToGuess;
            return thisGuess;
        }
    }

}
