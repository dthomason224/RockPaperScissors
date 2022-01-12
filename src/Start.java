import java.util.InputMismatchException;
import java.util.Scanner;

public class Start
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = -1;

        do {
            try {
                System.out.println("Do you want to play against a computer or another player: 1 for Computer, 2 for Player, " +
                        "and 3 To Quit");
                input = scanner.nextInt();
                if (input == 3)
                {
                    System.exit(0);
                }
            }
            catch (InputMismatchException exception)
            {
                System.out.println("Try Again");
                scanner.nextLine();
            }
        }while (!(input == 1 || input == 2));

        if (input == 1){
            Human player = new Human();
            Computer computer = new Computer();

            Game game = new Game(player, computer);

            game.startGame();
        }
        if (input == 2)
        {
            Human player1 = new Human();
            Human player2 = new Human();

            Game game = new Game(player1, player2);

            game.startGame();
        }
    }
}
