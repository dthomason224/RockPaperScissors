import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    private final ArrayList<String> gameHistory = new ArrayList<>();
    private int gameCounter = 1;
    private int drawCounter = 0;
    private boolean gameRunning = false;
    private Scanner scanner;

    public Game() {

    }

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        scanner = new Scanner(System.in);
    }

    public void startGame(){
        gameRunning = true;
        while (gameRunning)
        {
            player1.chosenOption();
            player2.chosenOption();
            decideWinner();
            displaySelectedChoices();
            anotherGame();
        }
        showSessionResults();
    }

    public void decideWinner(){
        gameHistory.add("Game " + gameCounter);

        //Interesting way to solve winner in one line / Source - https://stackoverflow.com/a/2795421
        int winner = (3 + player1.getChoice() - player2.getChoice()) % 3;

        switch (winner) {
            case 1 -> {
                System.out.println("Player 1 wins");
                gameHistory.add("Player 1 Wins");
                player1.addWin();
            }
            case 2 -> {
                System.out.println("Player 2 wins");
                gameHistory.add("Player 2 Wins");
                player2.addWin();
            }
            case 0 -> {
                System.out.println("Draw");
                gameHistory.add("Draw");
                drawCounter++;
            }
        }
        gameCounter++;
    }

    //converts number choices to rock, paper, and scissors then adds to arraylist
    public void displaySelectedChoices(){
        String player1Choice = "Player 1 selected " + convertChoice(player1.getChoice());
        String player2Choice = "Player 2 selected " + convertChoice(player2.getChoice());

        System.out.println(player1Choice);
        gameHistory.add(player1Choice);

        System.out.println(player2Choice);
        gameHistory.add(player2Choice);

        System.out.println();
    }

    //converts number choices to strings
    public String convertChoice(int choice){
        switch (choice) {
            case 1 -> {
                return "Paper";
            }
            case 2 -> {
                return "Scissors";
            }
            case 0 -> {
                return "Rock";
            }
        }
        return null;
    }

    //prints array list containing game results
    public void showGameHistory() {
        gameHistory.forEach(System.out::println);
        System.out.println();
    }

    public void showSessionResults() {
        System.out.println("Player 1 wins: " + player1.getGamesWon());
        System.out.println("Player 2 wins: " + player2.getGamesWon());
        System.out.println("Draws: " + drawCounter);
    }

    public void anotherGame(){
        int input = -1;
        do {
            try {
                System.out.println("Do you want to play again: 1 for Yes, 2 for No, 3 for Game History");
                input = scanner.nextInt();
                if (input == 3)
                    showGameHistory();
            }
            catch (InputMismatchException exception)
            {
                System.out.println("Try Again");
                scanner.nextLine();
            }
        }while (!(input == 1 || input == 2));

        if (input == 2)
        {
           gameRunning = false;
        }
    }
}