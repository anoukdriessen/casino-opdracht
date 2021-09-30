package nl.novi.casino;

/**
 * Game String library class
 * wordt gebruikt om alle teksten bij te houden die in de game gebruikt worden
 */
public class StringLib {
    // general
    public static final String LINE = "*****************************************************************************************************************************************";
    public static final String NEWLINE = "*\t";
    public static final String BLANKSPC = "\n*";
    public static final String WELCOME = "WELCOME @ ";
    public static final String GOODLUCK = "GOODLUCK!!!";
    public static final String USERRESULT = "You typed: %s\n";

    // not valid
    public static final String NOTVALIDNUMBER = "\"%s\" is not a valid number.\n";
    public static final String NOTVALIDCOMMAND = "\"%s\" is not a valid command.\n";

    // higher and lower
    public static final String HIGHERANDLOWER = "Higher and Lower";
    public static final String HTP_HIGHERANDLOWER = "You are going to try to guess a random generated number\n" +
            NEWLINE + "The number is a number between 0 and 100";
    public static final String MAKEAGUESS = "Make a guess... ";
    public static final String TOOHIGH = "That number is too high!";
    public static final String TOOLOW = "That number is too low!";
    public static final String CORRECT = "Correct! You guessed the number in [%s] turn";

    // blackjack
    public static final String BLACKJACK = "Blackjack";

    public static final String DEALER = "DEALER";
    public static final String PLAYER = "PLAYER";

    public static final String EMPTYHAND = " has no cards";

    public static final String TPOINTS = "Ten Points";
    public static final String TOPOINTS = "Twenty-One Points";

    public static final String WON = "WON";
    public static final String LOST = "LOST";
    public static final String DRAW = "DRAW";

    public static final String YOU_ARE = "You are ";
    public static final String YOU_HAVE = "You have ";

    public static final String STAY = "STAY";
    public static final String HIT = "HIT";
    public static final String BUST = "BUST";

    public static final String HTP_BLACKJACK = "This version is played without Aces and Jokers,\n" +
            NEWLINE +"We play with 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen and the King\n" +
            NEWLINE +"Each card has a value: Each number has [the numeric value], the Jack, Queen and King are each ["+TPOINTS+"]\n" +
            NEWLINE +"The game is played between "+ DEALER +" and "+PLAYER+",\n" +
            NEWLINE +"the goal is to get as close or get exactly ["+TOPOINTS+"]\n" +
            NEWLINE +"["+TOPOINTS+"] always wins the game, then you've owned "+BLACKJACK.toUpperCase()+"!\n" +
            NEWLINE +"you've ["+LOST+"] if you get more then ["+TOPOINTS+"], if we are both below ["+TOPOINTS+"] the highest score wins.\n" +
            NEWLINE +"When the game starts the "+PLAYER+" gets 2 cards, the "+DEALER+" gets 1\n" +
            NEWLINE +"You can choose to "+STAY+", you don't get another card and hope the "+DEALER+" will "+BUST+" ["+TOPOINTS+"]\n" +
            NEWLINE +"or you play "+HIT+" and get a card after you're turn the "+DEALER+" will do the same ["+STAY+"/"+HIT+"]\n" +
            NEWLINE +"The game has ended when "+PLAYER+" or "+DEALER+" have gone over ["+TOPOINTS+"]\n" +
            NEWLINE +"or when "+PLAYER+" or "+DEALER+" chose "+STAY+" and the other player has a higher card value (beneath or equal to ["+TOPOINTS+"])\n" +
            NEWLINE +"If we play a "+DRAW+", the "+DEALER+" has "+WON+"!" + BLANKSPC;

    public static final String SHUFFELED = "Cards have been shuffeled, here we go!";
    public static final String ROUND = "ROUND: ";
    public static final String GOT = " got the card: ";
    public static final String CHOICE = "The choice is yours.. What is it going to be... " + HIT + " or " + STAY;
    public static final String INVALID_CHOICE = "This input is invalid please enter: " + HIT + " or " + STAY;

    public static final String[] CARDSUITS = new String[]{"diamonds", "hearts", "spades",  "clubs"};
    public static final char[] UNI_SUITS = new char[]{'\u2666', '\u2665', '\u2660', '\u2663'};
    public static final String[] COLORS = new String[]{"red", "black"};

    public static final String[] CARDS = new String[]{"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    public static final int[] VALUES = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
    public static final String POINTS = " points";
    public static final String GAME = " this game!";
    public static final String ANOTHER_ROUND = "No winner yet, we play another round";


}

