package mastermindgame_java.Settings;

import java.util.HashMap;
import java.util.Map;
import static mastermindgame_java.Settings.SetDifficulty.Level;

public class CalculatePoints {
    private final int basePoints = 10;
    private Level difficultyLvl;

    private int pointsPerTrialLeft;
    private int multiplicationConstant;

    private static final Map<Level, pointsParameters> pointsMap = new HashMap<>();

    public CalculatePoints(Level difficultyLvl) {
        this.difficultyLvl = difficultyLvl;
        setParameters();
    }

    static {
        pointsMap.put(Level.EASY, new pointsParameters(5, 1));
        pointsMap.put(Level.MEDIUM, new pointsParameters(10, 2));
        pointsMap.put(Level.HARD, new pointsParameters(30, 4));
    }

    private void setParameters() {
        pointsParameters parameters = pointsMap.get(difficultyLvl);
        this.pointsPerTrialLeft = parameters.pointsPerTrialLeft;
        this.multiplicationConstant = parameters.multiplicationConstant;
    }

    private static class pointsParameters {
        private int pointsPerTrialLeft;
        private int multiplicationConstant;

        public pointsParameters(int pointsPerTrialLeft, int multiplicationConstant) {
            this.pointsPerTrialLeft = pointsPerTrialLeft;
            this.multiplicationConstant = multiplicationConstant;
        }
    }

    public int calculateFinalScore(int trialsLeft) {
        int score = 0;

        if (trialsLeft != 0) {
            score += pointsPerTrialLeft * trialsLeft;
            score *= multiplicationConstant;
        }
        score += basePoints;

        return score;
    }
}