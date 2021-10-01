package games.slotmachines;

public class FiveReelerMachine extends SlotMachineSettings {

    public FiveReelerMachine(String name, int wheels, int cost) {
        super(name, wheels, cost);
    }

    @Override
    public int setCreditsToGive(char winningSymbol) {
        String message;
        switch (winningSymbol) {
            case DOLLAR:
                message = "JACKPOT!";
                this.credits = this.cost * 420 + 100;
                break;
            case YINYANG:
                message = "SMALL WIN";
                this.credits = this.cost * 25 + 100;
                break;
            case SPADE:
                message = "MEDIUM WIN";
                this.credits = this.cost * 50 + 100;
                break;
            case HEART:
                message = "LOVE IS ON YOUR SIDE";
                this.credits = this.cost * 69 + 100;
                break;
            case CLUB:
                message = "YOU ARE IN LUCK";
                this.credits = this.cost * 200 + 100;
                break;
            default:
                message = "";
        }
        System.out.println("\n" + message + " je hebt " + this.credits + " credits gewonnen");
        return this.credits;
    }
}
