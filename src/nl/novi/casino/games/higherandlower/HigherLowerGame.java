package nl.novi.casino.games.higherandlower;

import java.util.Random;
import java.util.Scanner;

/**
 * Game Class Higher Lower
 *
 * @author anoukdriessen
 */
public class HigherLowerGame {
    // de gebruikersinput
    private Scanner userInput;
    // controleren of de game gespeeld wordt
    private boolean gameIsRunning;
    // random voor de willeukerige getallen
    private Random random;

    /**
     * Constructor voor Higher en Lower
     * @param userInput de scanner die gebruikt wordt voor de userInput
     */
    public HigherLowerGame(Scanner userInput) {
        this.userInput = userInput;
        this.gameIsRunning = false;
        this.random = new Random();
    }

    /**
     * Methode playGame start het spel
     */
    public void playGame() {
        welcome();
        gameIsRunning = true;

        // STAP 2. Het spel kiest een willekeurig nummer tussen 0 en 100 dat geraden moet worden.
        int numberToGuess = getRandomNumber();

        // STAP 3. Het spel zet het aantal gespeelde beurten op 0
        int guesses = 0;
        boolean answerIsCorrect = false;

        while (gameIsRunning) {
            while (!answerIsCorrect){
                // STAP 4. Het spel print de regel ‘Make a guess’
                System.out.println("Make a guess");

                int input;
                // STAP 5. De speler raadt een nummer
                if (DEBUGMODE) {
                    // correct
//                    input = numberToGuess;
                    // incorrect higher
//                    input = numberToGuess + 1;
                    // incorrect lower
//                    input = numberToGuess - 1;
                    // three guesses
                    if (guesses == 0) {
                        input = numberToGuess + 1;
                    } else if (guesses == 1) {
                        input = numberToGuess - 1;
                    } else {
                        input = numberToGuess;
                    }
                } else {
                    //                var input = userInput.nextLine();
                    while (!userInput.hasNextInt()) {
                        String temp = userInput.next();
                        System.out.printf("\"%s\" is not a valid number.\n", temp);
                    }

                    input = userInput.nextInt();
                }


                System.out.printf("You typed: %s\n", input);

                // STAP 6. Het spel hoogt het aantal gespeelde beurten op met 1
                guesses++;

                // controleer antwoord
                answerIsCorrect = input == numberToGuess;

                // antwoord is incorrect
                if (!answerIsCorrect) {
                    if (input > numberToGuess) {
                        // STAP 7. Was het nummer te hoog? Het spel print de regel `That number is too high!` (terug naar stap 4)
                        System.out.println("That number is too high!");
                    } else {
                        // STAP 8. Was het nummer te laag? Het spel print de regel `That number is too low!` (terug naar stap 4)
                        System.out.println("That number is too low!");
                    }
                }
            }

            // Komt het nummer overeen? Het spel print de regel `Correct! You guessed the number in x turns` waarbij x het aantal gespeelde beurten is. (het spel wordt gestopt)
            if (guesses == 1) {
                System.out.printf("Correct! You guessed the number in [%s] turn", guesses);
            } else {
                System.out.printf("Correct! You guessed the number in [%s] turns", guesses);
            }
            gameIsRunning = false;
        }
    }

    /**
     * Print a Welcome Message
     */
    public void welcome() {
        System.out.println("Welcome to \" Higher and Lower \"\nYou are going to try to guess a random generated number\n" +
                "The number is a number between 0 and 100, Goodluck!\n");
    }

    /**
     * Methode om random getal terug te geven die de gebruiker gaat raden
     */
    public int getRandomNumber() {
        return random.nextInt(100);
    }
}
