import java.util.InputMismatchException;
import java.util.Scanner;

public class Human extends Player{
    private final Scanner scanner;

    public Human() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void chosenOption() {
        int input = -1;
        do {
            try {
                System.out.println("Enter a selection: 0 for Rock, 1 for Paper, 2 for Scissors, 3 for Game History");
                input = scanner.nextInt();
            }
            catch (InputMismatchException exception)
            {
                System.out.println("Try Again");
                scanner.nextLine();
            }
        }while (!(input == 0 || input == 1 || input == 2));

        setChoice(input);
    }
}
