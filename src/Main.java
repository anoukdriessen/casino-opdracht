import games.slotmachines.SlotMachineGame;
import games.blackjack.BlackJackGame;
import games.Game;
import games.HigherLowerGame;
import games.blackjack.LowDeckBlackjackGame;
import games.blackjack.SimpleBlackJackGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main klasse van het Casino
 * opdracht van Full Stack Bootcamp - Backend NOVI
 *
 * Deze opdracht bestaat uit 8 losse onderdelen, de casus:
 * Casino de gouden driehoek is een casino met meerdere locaties in Nederland hier kunnen verschillende spellen worden gespeeld.
 * Gezien de populariteit van internet casino's gaat ook dit casino de digitale markt betreden.
 * In deze reeks van opdrachten wordt de testversie van het online casino ontwikkeld.
 * De applicatie is een command-line-application.
 * Er worden verschillende spellen ontwikkeld die uiteindelijk gecombineerd worden tot een casino applicatie
 *
 * September 2021
 * @author anouk driessen
 */
class Main {
    // de spellen die het casino bevat
    private static List<Game> casinoGames;

    // het spel dat gespeeld wordt
    private static Game toPlay;

    public static void main(String[] args) {
        // welkomstbericht
        System.out.println("Welkom bij het Casino de Gouden driehoek");
        // maak de input scanner aan
        Scanner input = new Scanner(System.in);

        // laat de speler een spel kiezen
        letPlayerChooseGame(input);

    }

    public static void getCasinoGames() {
        casinoGames = new ArrayList<>();
        // opdracht 1: Spel Higher and Lower
        casinoGames.add(new HigherLowerGame(
                1,
                "Hoger en Lager",
                "dit spel draait om puur geluk\nIk genereer een random getal en jij moet deze raden, " +
                        "ik geef hints of het getal hoger of lager is dan jij geraden hebt."));
        casinoGames.add(new SimpleBlackJackGame(
                2,
                "Classic Blackjack",
                "dit spel is een klassiek casino spel, zorg dat je niet boven de 21 punten kijgt!"));
        casinoGames.add(new LowDeckBlackjackGame(
                3,
                "Low-Deck Blackjack",
                "dit spel is een variatie op het klassieke casino spel, deze variatie wordt gespeeld met een kaartendeck" +
                        "bestaande uit alle kaarten met waardes tussen 2 en 6 en drie losse decks"));
        casinoGames.add(new SlotMachineGame(
                4,
                "Slot Machines",
                "dit spel is een klassiek casino spel"
        ));
    }

    public static void letPlayerChooseGame(Scanner in){
        System.out.println("Welk spel wil je spelen?");
        getCasinoGames();

        for(Game game : casinoGames) {
            System.out.println(game);
        }

        System.out.print("\nIk kies spel: ");

        // test HigherLower
//        toPlay = casinoGames.get(0);
//        toPlay.playGame(in);

        // test Classic Blackjack
//        toPlay = casinoGames.get(1);
//        toPlay.playGame(in);

        // test LowDeck Blackjack
//        toPlay = casinoGames.get(2);
//        toPlay.playGame(in);

        // test SlotMachineGame
        toPlay = casinoGames.get(3);
        toPlay.playGame(in);
    }
}