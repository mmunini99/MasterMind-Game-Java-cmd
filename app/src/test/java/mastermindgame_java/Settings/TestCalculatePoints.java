package mastermindgame_java.Settings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalculatePoints {

    @ParameterizedTest
    @CsvSource({
        "EASY, 0, 10",
        "EASY, 1, 15",
        "EASY, 3, 25",
        "EASY, 10, 60",
        "EASY, 11, 65",
        "EASY, 14, 80",
        "MEDIUM, 0, 10",
        "MEDIUM, 1, 30",
        "MEDIUM, 2, 50",
        "MEDIUM, 8, 170",
        "MEDIUM, 11, 230",
        "HARD, 0, 10",
        "HARD, 1, 130",
        "HARD, 2, 250",
        "HARD, 6, 730",    
    })
    void testCalculateFinalScore(SetDifficulty.Level difficultyLevel, int trialsLeft, int expectedScore) {
        CalculatePoints calculator = new CalculatePoints();
        int actualScore = calculator.calculateFinalScore(difficultyLevel, trialsLeft);
        assertEquals(expectedScore, actualScore);
    }
}
