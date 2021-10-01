package games.players;

/**
 * Klasse speler is een speler in een casino spel
 * elke speler heeft een naam en een aantal punten
 */
public class Player {
    private String name;
    private int points;

    /**
     * Constructor voor de klasse Player
     * @param name de naam van de speler (ook wel type)
     */
    public Player(String name) {
        this.name = name;
        this.points = 0;
    }

    /**
     * Getter voor de naam van de speler
     * @return de naam van de speler
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter voor de punten van de speler
     * @return de punten van de speler
     */
    public int getPoints() {
        return this.points;
    }

    /**
     * Methode om speler punten te geven
     */
    public void givePlayerPoints(int pointsToAdd) {
        this.points = this.points + pointsToAdd;
    }

    /**
     * Methode om speler minpunten te geven
     */
    public void takePlayerPoints(int pointsToTake) {
        this.points = this.points - pointsToTake;
    }
}
