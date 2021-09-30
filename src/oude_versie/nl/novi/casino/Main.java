package nl.novi.casino;

import nl.novi.casino.games.BlackJackGame;
import nl.novi.casino.games.HigherLowerGame;

import java.util.Scanner;

/**
 * NOVI EDHUB OPDRACHT
 * Golden Triangle Casino
 *
 * bestaat uit 8 losse onderdelen
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
    // zet AAN (true) om bepaalde debug messages/uitkomsten te zien
    public static final boolean DEBUGMODE = true;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

//        HigherLowerGame higherLowerGame = new HigherLowerGame(in);
//        higherLowerGame.playGame();

        BlackJackGame blackJackGame = new BlackJackGame(in);
        blackJackGame.playGame();
    }

}
