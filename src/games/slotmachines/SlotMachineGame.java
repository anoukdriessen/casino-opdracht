package games.slotmachines;

import games.Game;

import java.util.Scanner;

/**
 * Klasse SlotMachineGame is een bekende casino klassieker: fruitautomaten
 * Het spel zal bestaan uit drie verschillende fruitautomaten met verschillende instellingen.
 */
public class SlotMachineGame extends Game {
    private int credit;
    private SlotMachineSettings pennyMachine, highRollerMachine, fiveReelerMachine;
    private final static String PENNY = "Penny Machine";
    private final static String HIGH_ROLLER = "High Roller Machine";
    private final static String FIVE_REELER = "5-Reeler Machine";

    /**
     * Constructor voor klasse SlotMachineGame
     */
    public SlotMachineGame(int number, String name, String uitleg) {
        super(number, name, uitleg);
        // Bij het starten van het spel krijgt de speler een hoeveelheid munten
        this.credit = 100;

    }

    /**
     * Methode om het spel te spelen
     */
    @Override
    public void playGame(Scanner input) {
        System.out.println("We gaan " + super.getName() + " spelen");
        startGame();

        SlotMachineSettings[] listOfVariations = new SlotMachineSettings[3];
        createMachines(listOfVariations);

        while (isRunning()) {
            if (this.credit == 0) {
                System.out.println("Je credits zijn op, einde spel");
                endGame();
                return;
            }

            System.out.println("Je hebt momenteel " + this.credit + " munten, op welke machine wil je spelen?");

            showVariations(listOfVariations);
            System.out.println("Wil je stoppen type dan [ einde ]");
            while (!input.hasNextInt()) {
                System.out.println(!input.hasNextInt());
                System.out.println(input.hasNextInt());

                String nextInput = input.nextLine();
                if (nextInput.equalsIgnoreCase("einde")) {
                    if (this.credit < 100) {
                        System.out.println("Je hebt " + (100 - this.credit) + " credits verloren");
                    } else {
                        System.out.println("Je hebt " + (this.credit - 100) + " credits gewonnen");
                    }
                    endGame();
                    return;
                } else {
                    // unvalid
                    System.out.println("Je hebt " + nextInput + " ingevuld, vul het getal in van de machine die je wilt spelen.");
                }
            }
            int choice = input.nextInt();
            System.out.print("Je kiest ");
            SlotMachineSettings game;
            if (choice == 1) {
                // play penny
                System.out.println(PENNY);
                game = listOfVariations[0];
                playGameChoice(game);
            } else if (choice == 2){
                // high roller
                System.out.println(HIGH_ROLLER);
                game = listOfVariations[1];
                playGameChoice(game);
            } else if (choice == 3){
                // 5-reeler
                System.out.println(FIVE_REELER);
                game = listOfVariations[2];
                playGameChoice(game);
            }
        }
    }

    public void createMachines(SlotMachineSettings[] listOfVariations) {
        // 1. Penny Machine
        pennyMachine = new PennySlotMachine(PENNY, 3, 1);
        listOfVariations[0] = pennyMachine;

        // 2. High Roller Machine
        highRollerMachine = new HighRollerMachine(HIGH_ROLLER, 3, 10);
        listOfVariations[1] = highRollerMachine;

        // 3. De 5-reeler Machine
        fiveReelerMachine = new FiveReelerMachine(FIVE_REELER, 5, 5);
        listOfVariations[2] = fiveReelerMachine;
    }

    public void showVariations(SlotMachineSettings[] listOfVariations) {
        int i = 1;
        for (SlotMachineSettings variation : listOfVariations) {
            System.out.println("[" + i + "] " + variation);
            i++;
        }
    }

    public void playGameChoice(SlotMachineSettings game) {
        boolean enoughToPlay = game.cost <= this.credit;
        if (!enoughToPlay) {
            System.out.println("Je hebt niet genoeg credit");
        } else {
            System.out.println("Dit spel kost " + game.cost + " credit");
            // play game
            this.credit -= game.cost;
            boolean gameplay = game.playGame();

            // speler wint spel
            if (gameplay) {
                System.out.println("Je hebt GEWONNEN!");
                // geef speler credit
                this.credit += game.getCreditsToGive();
            } else {
                System.out.println("\nJe hebt VERLOREN, probeer opnieuw.");
            }
        }
    }
}
