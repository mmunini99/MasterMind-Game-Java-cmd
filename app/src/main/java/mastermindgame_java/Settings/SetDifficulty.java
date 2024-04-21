package mastermindgame_java.Settings;

import static mastermindgame_java.LetGameRun.GameMessages.invalidLevel;

import java.util.HashMap;
import java.util.Map;
public class SetDifficulty {

    public static enum Level {
        EASY, MEDIUM, HARD
    }

    private int lengthOfSequence = 0;
    private int numberOfTrials = 0;
    private int maxValueForColor = 0;
    private Level level;

    private static final Map<Level, DifficultyParameters> difficultyMap = new HashMap<>();

    public SetDifficulty(Level level){
        this.level = level;
        setParameters();
    }

    static {
        // Define difficulty parameters
        difficultyMap.put(Level.EASY, new DifficultyParameters(4, 15, 2));
        difficultyMap.put(Level.MEDIUM, new DifficultyParameters(4, 12, 5));
        difficultyMap.put(Level.HARD, new DifficultyParameters(4, 7, 5));
    }

    public void setParameters() {
        DifficultyParameters parameters = difficultyMap.get(level);
        if (parameters == null) {
            throw new IllegalArgumentException(invalidLevel()); // TODO va bene?
        }
        this.lengthOfSequence = parameters.lengthOfSequence;
        this.numberOfTrials = parameters.numberOfTrials;
        this.maxValueForColor = parameters.maxValueForColor;
    }

    // Helper class to store difficulty parameters
    private static class DifficultyParameters {
        private int lengthOfSequence;
        private int numberOfTrials;
        private int maxValueForColor;

        public DifficultyParameters(int lengthOfSequence, int numberOfTrials, int maxValueForColor) {
            this.lengthOfSequence = lengthOfSequence;
            this.numberOfTrials = numberOfTrials;
            this.maxValueForColor = maxValueForColor;
        }
    }

    // Getter methods for accessing parameters
    public int getLengthOfSequence() {
        return lengthOfSequence;
    }

    public int getNumberOfTrials() {
        return numberOfTrials;
    }

    public int getMaxValueForColor() {
        return maxValueForColor;
    }

    public String Difficulty2String() {
        switch (level) {
            case EASY:
                return "Easy";
            case MEDIUM:
                return "Medium";
            case HARD:
                return "Hard";
            default:
                return invalidLevel();
        }
    }

}