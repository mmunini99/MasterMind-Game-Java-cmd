package mastermindgame_java.Settings;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestProvideFeedback {

    @ParameterizedTest
    @MethodSource("provideTestData_testGetFeedback")
    public void testGetFeedback(int[] secretCode, int[] guess, int[] expectedOutput) {

        ProvideFeedback feedbackObj = new ProvideFeedback(secretCode);
        int[] feedback = feedbackObj.getFeedback(guess);

        assertArrayEquals(expectedOutput, feedback);
    }

    static Stream<Arguments> provideTestData_testGetFeedback() {
        return Stream.of(
                Arguments.of(new int[] { 0, 1, 2, 1 }, new int[] { 0, 1, 2, 1 }, new int[] { 4, 0, 0 }),
                Arguments.of(new int[] { 1, 1, 1, 1 }, new int[] { 1, 1, 1, 1 }, new int[] { 4, 0, 0 }),
                Arguments.of(new int[] { 4, 3, 4, 5 }, new int[] { 4, 3, 4, 5 }, new int[] { 4, 0, 0 }),
                Arguments.of(new int[] { 5, 3, 2, 0 }, new int[] { 5, 3, 2, 0 }, new int[] { 4, 0, 0 }),
                Arguments.of(new int[] { 0, 1, 5, 3 }, new int[] { 0, 1, 5, 3 }, new int[] { 4, 0, 0 }),

                Arguments.of(new int[] { 0, 1, 2, 3 }, new int[] { 0, 1, 4, 3 }, new int[] { 3, 0, 1 }),
                Arguments.of(new int[] { 3, 1, 5, 3 }, new int[] { 3, 1, 5, 2 }, new int[] { 3, 0, 1 }),
                Arguments.of(new int[] { 0, 1, 2, 3 }, new int[] { 0, 1, 4, 3 }, new int[] { 3, 0, 1 }),
                Arguments.of(new int[] { 4, 4, 4, 3 }, new int[] { 4, 4, 4, 2 }, new int[] { 3, 0, 1 }),
                Arguments.of(new int[] { 3, 5, 3, 5 }, new int[] { 3, 4, 3, 5 }, new int[] { 3, 0, 1 }),

                Arguments.of(new int[] { 5, 5, 2, 1 }, new int[] { 5, 5, 1, 2 }, new int[] { 2, 2, 0 }),
                Arguments.of(new int[] { 3, 2, 5, 1 }, new int[] { 1, 2, 5, 3 }, new int[] { 2, 2, 0 }),
                Arguments.of(new int[] { 3, 2, 5, 0 }, new int[] { 1, 2, 5, 3 }, new int[] { 2, 1, 1 }),
                Arguments.of(new int[] { 2, 2, 4, 5 }, new int[] { 2, 0, 4, 2 }, new int[] { 2, 1, 1 }),
                Arguments.of(new int[] { 4, 3, 0, 1 }, new int[] { 4, 3, 2, 5 }, new int[] { 2, 0, 2 }),
                Arguments.of(new int[] { 2, 3, 5, 1 }, new int[] { 2, 4, 4, 1 }, new int[] { 2, 0, 2 }),

                Arguments.of(new int[] { 1, 5, 5, 2 }, new int[] { 5, 5, 2, 1 }, new int[] { 1, 3, 0 }),
                Arguments.of(new int[] { 1, 5, 5, 2 }, new int[] { 5, 5, 2, 1 }, new int[] { 1, 3, 0 }),
                Arguments.of(new int[] { 2, 4, 2, 5 }, new int[] { 2, 2, 5, 4 }, new int[] { 1, 3, 0 }),
                Arguments.of(new int[] { 0, 3, 1, 4 }, new int[] { 4, 3, 0, 2 }, new int[] { 1, 2, 1 }),
                Arguments.of(new int[] { 4, 2, 3, 4 }, new int[] { 4, 3, 2, 2 }, new int[] { 1, 2, 1 }),
                Arguments.of(new int[] { 2, 4, 2, 5 }, new int[] { 5, 4, 0, 0 }, new int[] { 1, 1, 2 }),
                Arguments.of(new int[] { 3, 2, 5, 0 }, new int[] { 5, 0, 5, 4 }, new int[] { 1, 1, 2 }),
                Arguments.of(new int[] { 4, 2, 3, 4 }, new int[] { 4, 1, 5, 0 }, new int[] { 1, 0, 3 }),
                Arguments.of(new int[] { 2, 2, 2, 5 }, new int[] { 4, 2, 4, 3 }, new int[] { 1, 0, 3 }),

                Arguments.of(new int[] { 5, 4, 5, 2 }, new int[] { 1, 1, 1, 1 }, new int[] { 0, 0, 4 }),
                Arguments.of(new int[] { 1, 4, 2, 0 }, new int[] { 5, 5, 3, 5 }, new int[] { 0, 0, 4 }),
                Arguments.of(new int[] { 0, 1, 0, 0 }, new int[] { 2, 3, 4, 2 }, new int[] { 0, 0, 4 }),
                Arguments.of(new int[] { 4, 3, 2, 3 }, new int[] { 5, 0, 1, 1 }, new int[] { 0, 0, 4 }),
                Arguments.of(new int[] { 3, 2, 3, 3 }, new int[] { 0, 1, 1, 5 }, new int[] { 0, 0, 4 })

        );
    }

}
