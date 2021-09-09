package nl.novi.casino;
import nl.novi.casino.games.higherandlower.HigherLowerGame;
import java.util.Scanner;

/**
 * Edhub opdracht de gouden driehoek
 * Deze oefening bestaat uit acht losse opdrachten
 *
 * Casus:
 * Casino de gouden driehoek is een casino met meerdere locaties in Nederland hier kunnen verschillende spellen worden gespeeld.
 * Gezien de populariteit van internet casino's gaat ook dit casino de digitale markt betreden.
 * In deze reeks van opdrachten wordt de testversie van het online casino ontwikkeld.
 * De applicatie is een command-line-application.
 * Er worden verschillende spellen ontwikkeld die uiteindelijk gecombineerd worden tot een casino applicatie
 *
 * @author anoukdriessen
 */
public class Main {
    public static final boolean DEBUGMODE = true;

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        // STAP 1. De speler start het spel (de main methode wordt aangeroepen)
        HigherLowerGame game = new HigherLowerGame(inputScanner);
        game.playGame();
    }

}
