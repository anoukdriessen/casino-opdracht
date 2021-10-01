package games.cards;

public class SimpleBlackjackDeck extends BlackjackDeck {
    public SimpleBlackjackDeck() {
        super();

        // vul het kaartendeck
        for (Suit suit : cardSuits) {
            // voor ieder cardsuit
            for (Value value : cardValues) {
                // voor iedere waarde
                // voeg een kaart toe aan deck
                cards.add(new Card(suit, value));
            }
        }
    }
}
