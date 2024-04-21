package mastermindgame_java.Settings;

import static mastermindgame_java.Settings.SetDifficulty.Level;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

// Import the Scanner class, used to take user input
import java.util.Scanner;
import java.util.stream.Stream;
import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGetUserInput {
    @ParameterizedTest
    @MethodSource("provideTestData_testGetUserInput")
    public void testGetUserInput(String input, String expectedOutput) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(testIn);
        GetUserInput getUserInput = new GetUserInput(scanner);
        String returnedOutput = getUserInput.getUserInput();

        assertEquals(expectedOutput, returnedOutput);
        scanner.close();
    }

    static Stream<Arguments> provideTestData_testGetUserInput() {
        return Stream.of(
            Arguments.of("Easy", "Easy"),
            Arguments.of("Medium", "Medium"),
            Arguments.of("shaha", "shaha")
        );
    }

}
