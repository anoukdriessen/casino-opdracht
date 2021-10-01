package games.cards;

public class LowBlackjackDeck extends BlackjackDeck {

    public static void main(String[] args) {
        new LowBlackjackDeck();
    }
    public LowBlackjackDeck() {
        super();

        // vul het kaartendeck drie keer ( drie decks )
        for (int i = 0; i < 4; i++) {
            for (Suit suit : cardSuits) {
                // voor ieder cardsuit
                for (Value value : cardValues) {
                    // voor iedere waarde tussen 2 en 6
                    // voeg een kaart toe aan deck
                    boolean valueBetween2And6 = value.getValue() <= 6;
                    if (valueBetween2And6) {
                        cards.add(new Card(suit, value));
                    }
                }
            }
        }

    }
}
