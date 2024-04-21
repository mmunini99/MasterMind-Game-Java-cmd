package mastermindgame_java.Settings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;

public class TestProvideFeedback {

    @ParameterizedTest
    @MethodSource("provideTestData_testGetFeedback")
    public void testGetFeedback(int[] secretCode, int[] guess, int[] expectedOutput) {
        // expectedOutput: [nRightNumbersRightPosition, nRightNumbersWrongPosition, nWrongNumbersWrongPosition]

        ProvideFeedback feedbackObj = new ProvideFeedback(secretCode);
        int[] feedback = feedbackObj.getFeedback(guess);

        assertArrayEquals(expectedOutput, feedback);
    }

    static Stream<Arguments> provideTestData_testGetFeedback() {
        return Stream.of(
            Arguments.of(new int[]{0, 1, 2, 1}, new int[]{0, 1, 2, 1}, new int[]{4, 0, 0}),
            Arguments.of(new int[]{0, 3, 1, 4}, new int[]{4, 3, 0, 2}, new int[]{1, 2, 1}),
            Arguments.of(new int[]{1, 5, 5, 2}, new int[]{5, 5, 2, 1}, new int[]{1, 3, 0})
        );
    }
    
}
