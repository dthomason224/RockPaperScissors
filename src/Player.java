public abstract class Player {
    private int choice;
    private int gamesWon;

    public Player() {

    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public void addWin(){
        gamesWon++;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public abstract void chosenOption();
}
