package mastermindgame_java.Settings;

import static mastermindgame_java.Settings.SetDifficulty.Level;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

// Import the Scanner class, used to take user input
import java.util.Scanner;
import java.util.stream.Stream;
import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
// Import the assertions
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCheckGuessValidity {

    @ParameterizedTest
    @MethodSource("provideTestData_testIsCorrectValueInterval")
    public void testIsCorrectValueInterval(Level lvl, String input, boolean expectedIsValid) {
        SetDifficulty setDifficulty = new SetDifficulty(lvl);
        int MIN_VALUE = 0;
        int MAX_VALUE = setDifficulty.getMaxValueForColor();
        int DIGIT_COUNT = setDifficulty.getLengthOfSequence();

        char minChar = Character.forDigit(MIN_VALUE, 10);
        char maxChar = Character.forDigit(MAX_VALUE, 10);

        int[] guess = new int[DIGIT_COUNT];
        ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(testIn);
        CheckGuessValidity checkGuess = new CheckGuessValidity(scanner, lvl);

        boolean isValid = checkGuess.isCorrectValueInterval(guess, minChar, maxChar, input);
        assertEquals(expectedIsValid, isValid);

        scanner.close();
    }

    static Stream<Arguments> provideTestData_testIsCorrectValueInterval() {
        return Stream.of(
            Arguments.of(Level.EASY.toString(), "0121", true),
            Arguments.of(Level.MEDIUM.toString(), "0135", true),
            Arguments.of(Level.MEDIUM.toString(), "0t39", false),
            Arguments.of(Level.HARD.toString(), "5412", true)
        );
    }



    @ParameterizedTest
    @MethodSource("provideTestData_testValidateGuess")
    public void testValidateGuess(Level lvl, String input, int[] expectedOutput) {
        
        ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(testIn);
        CheckGuessValidity checkGuess = new CheckGuessValidity(scanner, lvl);

        int[] returnedGuess = checkGuess.validateGuess();

        assertArrayEquals(expectedOutput, returnedGuess);

        scanner.close();

    }

    static Stream<Arguments> provideTestData_testValidateGuess() {
        return Stream.of(
            Arguments.of(Level.EASY, "4222\n0122", new int[]{0, 1, 2, 2}),
            Arguments.of(Level.MEDIUM, "3455", new int[]{3, 4, 5, 5}),
            Arguments.of(Level.HARD, "5123", new int[]{5, 1, 2, 3})
        );
    }

    
}
