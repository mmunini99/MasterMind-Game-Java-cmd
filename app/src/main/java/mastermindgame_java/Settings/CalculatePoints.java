package mastermindgame_java.Settings;
import java.util.HashMap;
import java.util.Map;
import static mastermindgame_java.Settings.SetDifficulty.Level;

public class CalculatePoints {
    int base_points = 10;

    private final int[] pointsPerTrialLeft = {5, 10, 30};
    private final int[] multiplicationConstant = {1, 2, 4};

    private final Map<Level, Integer> difficultyMap = new HashMap<>();

    public CalculatePoints() {
        difficultyMap.put(Level.EASY, 0);
        difficultyMap.put(Level.MEDIUM, 1);
        difficultyMap.put(Level.HARD, 2);
    }
    
    public int calculate_final_score(Level difficulty_level, int trialsLeft) {
        int score = 0;
        int difficulty = difficultyMap.getOrDefault(difficulty_level, -1);
        
        if (difficulty == -1) {
            System.exit(0);
        }

        if (trialsLeft != 0) {
            score += pointsPerTrialLeft[difficulty] * trialsLeft;
            score *= multiplicationConstant[difficulty];
            score += base_points;
        } else {
            score += base_points;
        }
        return score;
    }
}