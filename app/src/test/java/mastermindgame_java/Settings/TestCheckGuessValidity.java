package mastermindgame_java.Settings;

import java.util.Scanner;
import java.util.stream.Stream;
import java.io.ByteArrayInputStream;

import static mastermindgame_java.Settings.SetDifficulty.Level;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
            Arguments.of(Level.EASY.toString(), "0151", false),
            Arguments.of(Level.EASY.toString(), "6271", false),
            Arguments.of(Level.EASY.toString(), "2180", false),
            Arguments.of(Level.EASY.toString(), "####", false),
            Arguments.of(Level.EASY.toString(), "!200", false),
            Arguments.of(Level.EASY.toString(), "20è0", false),
            Arguments.of(Level.EASY.toString(), "34&0", false),
            Arguments.of(Level.EASY.toString(), "011+", false),
            Arguments.of(Level.EASY.toString(), "0121", true),
            Arguments.of(Level.EASY.toString(), "0000", true),
            Arguments.of(Level.EASY.toString(), "1211", true),
            Arguments.of(Level.EASY.toString(), "0121", true),
            Arguments.of(Level.EASY.toString(), "2122", true),

            Arguments.of(Level.MEDIUM.toString(), "0039", false),
            Arguments.of(Level.MEDIUM.toString(), "0126", false),
            Arguments.of(Level.MEDIUM.toString(), "8172", false),
            Arguments.of(Level.MEDIUM.toString(), "!!2?", false),
            Arguments.of(Level.MEDIUM.toString(), "342=", false),
            Arguments.of(Level.MEDIUM.toString(), "34%5", false),
            Arguments.of(Level.MEDIUM.toString(), "14%ò", false),
            Arguments.of(Level.MEDIUM.toString(), "0135", true),
            Arguments.of(Level.MEDIUM.toString(), "0001", true),
            Arguments.of(Level.MEDIUM.toString(), "4444", true),
            Arguments.of(Level.MEDIUM.toString(), "1231", true),
            Arguments.of(Level.MEDIUM.toString(), "3354", true),

            Arguments.of(Level.HARD.toString(), "5417", false),
            Arguments.of(Level.HARD.toString(), "8888", false),
            Arguments.of(Level.HARD.toString(), "0926", false),
            Arguments.of(Level.HARD.toString(), "2227", false),
            Arguments.of(Level.HARD.toString(), "092!", false),
            Arguments.of(Level.HARD.toString(), "££££", false),
            Arguments.of(Level.HARD.toString(), "ì4$5", false),
            Arguments.of(Level.HARD.toString(), "è821", false),
            Arguments.of(Level.HARD.toString(), "5412", true),
            Arguments.of(Level.HARD.toString(), "5555", true),
            Arguments.of(Level.HARD.toString(), "2252", true),
            Arguments.of(Level.HARD.toString(), "4251", true),
            Arguments.of(Level.HARD.toString(), "1523", true)
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
            Arguments.of(Level.EASY, "1201", new int[]{1, 2, 0, 1}),
            Arguments.of(Level.EASY, "0000", new int[]{0, 0, 0, 0}),
            Arguments.of(Level.EASY, "1120", new int[]{1, 1, 2, 0}),
            Arguments.of(Level.EASY, "4222\n0122", new int[]{0, 1, 2, 2}),
            Arguments.of(Level.EASY, "422\n0122", new int[]{0, 1, 2, 2}),
            Arguments.of(Level.EASY, "555£\n798\n9111\n1200", new int[]{1, 2, 0, 0}),
            Arguments.of(Level.EASY, "1200\n1000", new int[]{1, 2, 0, 0}),
            Arguments.of(Level.EASY, "1021\n1200", new int[]{1, 0, 2, 1}),
            Arguments.of(Level.EASY, "1121\n12!0\n££££", new int[]{1, 1, 2, 1}),
            Arguments.of(Level.EASY, "2021\n120\n££££", new int[]{2, 0, 2, 1}),
            
            Arguments.of(Level.MEDIUM, "3455", new int[]{3, 4, 5, 5}),
            Arguments.of(Level.MEDIUM, "2222", new int[]{2, 2, 2, 2}),
            Arguments.of(Level.MEDIUM, "1524", new int[]{1, 5, 2, 4}),
            Arguments.of(Level.MEDIUM, "3456\n5555", new int[]{5, 5, 5, 5}),
            Arguments.of(Level.MEDIUM, "8614\n1423", new int[]{1, 4, 2, 3}),
            Arguments.of(Level.MEDIUM, "2224\n6234", new int[]{2, 2, 2, 4}),
            Arguments.of(Level.MEDIUM, "1231\n3314", new int[]{1, 2, 3, 1}),
            Arguments.of(Level.MEDIUM, "143\n$347\n2531", new int[]{2, 5, 3, 1}),
            Arguments.of(Level.MEDIUM, "89%\n&443\n5321", new int[]{5, 3, 2, 1}),
            Arguments.of(Level.MEDIUM, "35%4\n1112\n7777", new int[]{1, 1, 1, 2}),
        
            Arguments.of(Level.HARD, "5123", new int[]{5, 1, 2, 3}),
            Arguments.of(Level.HARD, "1234", new int[]{1, 2, 3, 4}),
            Arguments.of(Level.HARD, "0532", new int[]{0, 5, 3, 2}),
            Arguments.of(Level.HARD, "1212", new int[]{1, 2, 1, 2}),
            Arguments.of(Level.HARD, "7123\n3221", new int[]{3, 2, 2, 1}),
            Arguments.of(Level.HARD, "2349\n0682\n4354", new int[]{4, 3, 5, 4}),
            Arguments.of(Level.HARD, "5633\n3422", new int[]{3, 4, 2, 2}),
            Arguments.of(Level.HARD, "1236\n1324\n)654", new int[]{1, 3, 2, 4}),
            Arguments.of(Level.HARD, "3491\n5434\n?233", new int[]{5, 4, 3, 4}),
            Arguments.of(Level.HARD, "123\n153&\n$732\n%432\n2452", new int[]{2, 4, 5, 2}),
            Arguments.of(Level.HARD, "146\n654\n(=6\n87)8\n3455", new int[]{3, 4, 5, 5})
        );
    }

    
}
