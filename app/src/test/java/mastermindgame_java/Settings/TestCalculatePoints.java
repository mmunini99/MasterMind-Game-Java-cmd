package mastermindgame_java.Settings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalculatePoints {

    @ParameterizedTest
    @CsvSource({
        "EASY, 3, 25",
        "EASY, 0, 10",
        "MEDIUM, 2, 50",
        "MEDIUM, 0, 10",
        "HARD, 2, 250",
        "HARD, 0, 10"
    })
    void testCalculateFinalScore(SetDifficulty.Level difficultyLevel, int trialsLeft, int expectedScore) {
        CalculatePoints calculator = new CalculatePoints();
        int actualScore = calculator.calculateFinalScore(difficultyLevel, trialsLeft);
        assertEquals(expectedScore, actualScore);
    }
}
