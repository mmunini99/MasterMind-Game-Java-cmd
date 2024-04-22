package mastermindgame_java.Settings;

import static mastermindgame_java.Settings.SetDifficulty.Level;

import java.util.Scanner;
import java.util.stream.Stream;
import java.io.ByteArrayInputStream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDifficulty {

    @ParameterizedTest
    @MethodSource("provideTestData_testGetDifficulty_ValidInput")
    public void testGetDifficulty_ValidInput(String input, Level expectedOutput) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(testIn);
        ScannerDifficulty scannerDifficulty = new ScannerDifficulty(scanner);
        scannerDifficulty.getDifficulty(scanner);

        Level returnedOutput = scannerDifficulty.getDifficultyLevel();

        assertEquals(expectedOutput, returnedOutput);
        scanner.close();
    }

    static Stream<Arguments> provideTestData_testGetDifficulty_ValidInput() {
        return Stream.of(
                Arguments.of("Easy", Level.EASY.toString()),
                Arguments.of("easY", Level.EASY.toString()),
                Arguments.of("EASY", Level.EASY.toString()),
                Arguments.of("Medium", Level.MEDIUM.toString()),
                Arguments.of("medium", Level.MEDIUM.toString()),
                Arguments.of("MEDIUM", Level.MEDIUM.toString()),
                Arguments.of("Hard", Level.HARD.toString()),
                Arguments.of("HaRd", Level.HARD.toString()),
                Arguments.of("HARD", Level.HARD.toString()));
    }

    @ParameterizedTest
    @MethodSource("provideTestData_testGetDifficulty_Invalidinput")
    public void testGetDifficulty_Invalidinput(String invalidInput, String validInput, Level expectedOutput) {
        String input = invalidInput + "\n" + validInput + "\n";
        ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(testIn);
        ScannerDifficulty scannerDifficulty = new ScannerDifficulty(scanner);
        scannerDifficulty.getDifficulty(scanner);

        Level returnedOutput = scannerDifficulty.getDifficultyLevel();

        assertEquals(expectedOutput, returnedOutput);
        scanner.close();
    }

    static Stream<Arguments> provideTestData_testGetDifficulty_Invalidinput() {
        return Stream.of(
                Arguments.of("jhscbhjs", "Easy", Level.EASY.toString()),
                Arguments.of("()2345ytr", "EASY", Level.EASY.toString()),
                Arguments.of("123", "Medium", Level.MEDIUM.toString()),
                Arguments.of("£$€", "MEDIUM", Level.MEDIUM.toString()),
                Arguments.of("hjscb", "Hard", Level.HARD.toString()),
                Arguments.of("erduvi", "HarD", Level.HARD.toString()));
    }

    @ParameterizedTest
    @MethodSource("provideTestData_testGetLengthOfSequence")
    public void testGetLengthOfSequence(Level input, int expectedOutput) {
        SetDifficulty setDifficulty = new SetDifficulty(input);
        int returnedOutput = setDifficulty.getLengthOfSequence();
        assertEquals(expectedOutput, returnedOutput);
    }

    static Stream<Arguments> provideTestData_testGetLengthOfSequence() {
        return Stream.of(
                Arguments.of(Level.EASY.toString(), 4),
                Arguments.of(Level.MEDIUM.toString(), 4),
                Arguments.of(Level.HARD.toString(), 4));
    }

    @ParameterizedTest
    @MethodSource("provideTestData_testGetNumberOfTrials")
    public void testGetNumberOfTrials(Level input, int expectedOutput) {
        SetDifficulty setDifficulty = new SetDifficulty(input);
        int returnedOutput = setDifficulty.getNumberOfTrials();
        assertEquals(expectedOutput, returnedOutput);
    }

    static Stream<Arguments> provideTestData_testGetNumberOfTrials() {
        return Stream.of(
                Arguments.of(Level.EASY.toString(), 15),
                Arguments.of(Level.MEDIUM.toString(), 12),
                Arguments.of(Level.HARD.toString(), 7));
    }

    @ParameterizedTest
    @MethodSource("provideTestData_testGetMaxValueForColor")
    public void testGetMaxValueForColor(Level input, int expectedOutput) {
        SetDifficulty setDifficulty = new SetDifficulty(input);
        int returnedOutput = setDifficulty.getMaxValueForColor();
        assertEquals(expectedOutput, returnedOutput);
    }

    static Stream<Arguments> provideTestData_testGetMaxValueForColor() {
        return Stream.of(
                Arguments.of(Level.EASY.toString(), 2),
                Arguments.of(Level.MEDIUM.toString(), 5),
                Arguments.of(Level.HARD.toString(), 5));
    }

}
