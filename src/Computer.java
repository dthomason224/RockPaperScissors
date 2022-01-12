import java.util.Random;

public class Computer extends Player{
    private final Random random;
    private final int THREE_OPTIONS = 3;

    public Computer() {
        this.random = new Random();
    }

    @Override
    public void chosenOption() {
        int randomChoice = random.nextInt(THREE_OPTIONS);

        setChoice(randomChoice);
    }
}
