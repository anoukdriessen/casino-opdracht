package games.slotmachines;

public class HighRollerMachine extends SlotMachineSettings {

    public HighRollerMachine(String name, int wheels, int cost) {
            super(name, wheels, cost);
    }

    @Override
    public int setCreditsToGive(char winningSymbol) {
        String message;
        switch (winningSymbol) {
            case DOLLAR:
                message = "JACKPOT!";
                this.credits = this.cost + 4200;
                break;
            case YINYANG:
                message = "SMALL WIN";
                this.credits = this.cost + 250;
                break;
            case SPADE:
                message = "MEDIUM WIN";
                this.credits = this.cost + 500;
                break;
            case HEART:
                message = "LOVE IS ON YOUR SIDE";
                this.credits = this.cost + 690;
                break;
            case CLUB:
                message = "YOU ARE IN LUCK";
                this.credits = this.cost + 2000;
                break;
            default:
                message = "";
        }
        System.out.println("\n" + message + " je hebt " + this.credits + " credits gewonnen");
        return this.credits;
    }
}
