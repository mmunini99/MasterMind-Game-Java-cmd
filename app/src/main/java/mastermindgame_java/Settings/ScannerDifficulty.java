package mastermindgame_java.Settings;

import java.util.Scanner;
import static mastermindgame_java.LetGameRun.GameMessages.*;
import static mastermindgame_java.Settings.SetDifficulty.Level;

public class ScannerDifficulty {

    private Level level;
    private GetUserInput getUserInput;
    private String input;

    // Constructor
    public ScannerDifficulty(Scanner scanner) {
        this.level = null;
        this.input = null;

        getUserInput = new GetUserInput(scanner);
    }

    // Check that the input is valid
    public void checkDifficulty(String input) {
        // If the user types a valid difficulty, set the level

        try {
            this.level = Level.valueOf(input);
        } catch (IllegalArgumentException e) {
            System.out.println(difficultyInputNotValid());
            input = getUserInput.getUserInput().toUpperCase();
            checkDifficulty(input);
        }

    }

    // Prompt the user for input
    public ScannerDifficulty getDifficulty(Scanner scanner) {
        System.out.println(chooseDifficultyMessage());
        this.input = getUserInput.getUserInput().toUpperCase();
        checkDifficulty(input);
        return this;
    }

    public Level getDifficultyLevel() {
        return level;
    }

}