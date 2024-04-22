package mastermindgame_java.Settings;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestTemplateMatrix {

    @ParameterizedTest
    @MethodSource("provideTestData_testSetGuess")
    public void testSetGuess(int[] guess, int[] feedback, int count, int[] expectedOutput) {
        int lengthOfTrials = count + 1;

        TemplateMatrix matrix = new TemplateMatrix(lengthOfTrials, guess.length, false);
        matrix.setGuess(guess, feedback, count);

        System.out.print(matrix.template[count]);

        assertArrayEquals(matrix.template[count], expectedOutput);
    }

    static Stream<Arguments> provideTestData_testSetGuess() {
        return Stream.of(
                Arguments.of(new int[] { 0, 0, 0, 0 }, new int[] { 0, 1, 3 }, 0, new int[] { 1, 0, 0, 0, 0, 0, 1, 3 }),
                Arguments.of(new int[] { 4, 2, 1, 1 }, new int[] { 1, 1, 2 }, 1, new int[] { 2, 4, 2, 1, 1, 1, 1, 2 }),
                Arguments.of(new int[] { 0, 3, 2, 5 }, new int[] { 4, 0, 0 }, 5, new int[] { 6, 0, 3, 2, 5, 4, 0, 0 }),
                Arguments.of(new int[] { 1, 2, 0, 2 }, new int[] { 3, 1, 0 }, 2, new int[] { 3, 1, 2, 0, 2, 3, 1, 0 }));
    }


}
