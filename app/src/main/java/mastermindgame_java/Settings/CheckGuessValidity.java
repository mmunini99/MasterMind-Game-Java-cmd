package mastermindgame_java.Settings;

import java.util.Scanner;
import static mastermindgame_java.LetGameRun.GameMessages.*;
import static mastermindgame_java.Settings.SetDifficulty.Level;

public class CheckGuessValidity {

    private final int MIN_VALUE = 0;
    private int MAX_VALUE;
    private int DIGIT_COUNT;

    GetUserInput getUserInput;

    public CheckGuessValidity(Scanner scanner, Level difficulty_lvl) {

        SetDifficulty setDifficulty = new SetDifficulty(difficulty_lvl);

        this.MAX_VALUE = setDifficulty.getMaxValueForColor();

        this.DIGIT_COUNT = setDifficulty.getLengthOfSequence();

        this.getUserInput = new GetUserInput(scanner);
    }

    public int[] validateGuess() {
        int[] guess = new int[DIGIT_COUNT];
        boolean validInput = false;
    
        char minChar = Character.forDigit(MIN_VALUE, 10);
        char maxChar = Character.forDigit(MAX_VALUE, 10);
    
        while (!validInput) {
            String input = getUserInput.getUserInput();
    
            if (!isCorrectLength(input)) {
                System.out.println(invalidInputSequence(DIGIT_COUNT, MAX_VALUE)); // TODO va bene?
                continue;
            }
    
            boolean validFormat = isCorrectValueInterval(guess, minChar, maxChar, input);
    
            if (!validFormat) {
                System.out.println(invalidInputSequence(DIGIT_COUNT, MAX_VALUE));
            } else {
                validInput = true;
            }
        }
    
        return guess;
    }

    public boolean isCorrectValueInterval(int[] guess, char minChar, char maxChar, String input) {
        boolean validFormat = true;
        for (int i = 0; i < DIGIT_COUNT; i++) {
            char digit = input.charAt(i);
            if (digit < minChar || digit > maxChar) {
                validFormat = false;
                break;
            }
            guess[i] = Character.getNumericValue(digit);
        }
        return validFormat;
    }

    public boolean isCorrectLength(String input) {
        return input.length() == DIGIT_COUNT;
    }
}