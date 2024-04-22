package mastermindgame_java.LetGameRun;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

import static mastermindgame_java.LetGameRun.GameMessages.*;
import mastermindgame_java.Settings.CalculatePoints;
import mastermindgame_java.Settings.CheckGuessValidity;
import mastermindgame_java.Settings.ProvideFeedback;
import mastermindgame_java.Settings.ScannerDifficulty;
import mastermindgame_java.Settings.SetDifficulty;
import mastermindgame_java.Settings.TemplateMatrix;
import static mastermindgame_java.Settings.SetDifficulty.Level;

public class Play {
    private Scanner scanner;
    private ScannerDifficulty scannerDifficulty;
    private Level difficultyLvl;
    private SetDifficulty setDifficulty;
    private int lengthOfSequence;
    private int trials;
    private int maxValue;

    private CheckGuessValidity scannerGuess;
    private TemplateMatrix resultSummary;
    private CalculatePoints score;

    private boolean printToFile;
    public boolean playerWon;

    // Variable used only in graphic version
    public int[] secretCode;
    public int[] feedback = new int[3]; // ---> create a constant
    private int count;
    private boolean initialized = false;

    public Play(Scanner scanner, boolean printToFile) {
        this.scanner = scanner;
        this.printToFile = printToFile;
        scannerDifficulty = new ScannerDifficulty(scanner);
    }

    public void askForDifficulty() {
        scannerDifficulty.getDifficulty(scanner);
        this.difficultyLvl = scannerDifficulty.getDifficultyLevel();
        this.setDifficulty = new SetDifficulty(difficultyLvl);
        this.trials = setDifficulty.getNumberOfTrials();
        this.lengthOfSequence = setDifficulty.getLengthOfSequence();
        this.maxValue = setDifficulty.getMaxValueForColor();

        this.scannerGuess = new CheckGuessValidity(scanner, difficultyLvl);
        this.resultSummary = new TemplateMatrix(trials, lengthOfSequence, printToFile);
        this.score = new CalculatePoints(difficultyLvl);

        initialized = true;

    }

    public boolean LetGameRun(int[] secretCode) {
        System.out.println(firstWelcomeMessage(difficultyLvl.toString()));

        System.out.println(declareNumberOfTrials(trials));

        int count = 0;

        int final_score = 0;
        ProvideFeedback provideFeedback = new ProvideFeedback(secretCode);

        while (count < trials) {
            if (count > 0) {
                resultSummary.printTemplate(count);
            }
            System.out.println(enterYourGuess(lengthOfSequence));

            int[] guess = scannerGuess.validateGuess();

            this.feedback = provideFeedback.getFeedback(guess);
            resultSummary.setGuess(guess, feedback, count);

            provideFeedback.displayFeedback();

            if (wasSecretCodeGuessed(feedback)) {
                this.playerWon = true;
                break;
            }
            // Check if the player has trials left
            if (areTrialsLeft(count)) {
                count++;
                System.out.println(displayRemainingTrials(trials - count));
            } else {
                this.playerWon = false;
                break;
            }

        }
        System.out.println("Remaining trials: " + (trials - count) + "\n");

        final_score = score.calculateFinalScore(trials - count - 1);

        System.out.println(provideFinalScore(final_score));

        return playerWon;
    }

    public int[] generateSecretCode() {

        int[] code = new int[lengthOfSequence];
        Random random = new Random();

        for (int i = 0; i < lengthOfSequence; i++) {
            code[i] = random.nextInt((maxValue + 1));
        }
        return code;
    }

    public void computeFeedback(int[] guess) {
        ProvideFeedback provider = new ProvideFeedback(secretCode);
        this.feedback = provider.getFeedback(guess);
    }

    public boolean getInitialized() {
        return initialized;
    }

    public int getCount() {
        return count;
    }

    public void AugCount() {
        count++;
    }

    public void setSecretCode(int[] secretCode) {
        this.secretCode = secretCode;
    }

    public boolean areTrialsLeft(int count) {
        return count < trials && count != trials - 1;
    }

    public int[] getSecretCode() {
        return secretCode;
    }

    public boolean wasSecretCodeGuessed(int[] feedback) {
        return feedback[0] == lengthOfSequence;
    }

    public static void main(String[] args) {
        final boolean printToFile = false;

        Scanner scanner = new Scanner(System.in);
        Play play = new Play(scanner, printToFile);

        play.askForDifficulty();

        int[] secretCode = play.generateSecretCode();

        boolean playerWon = play.LetGameRun(secretCode);

        if (playerWon) {
            System.out.println(secretCodeWasGuessed());
        } else {
            System.out.println(lostMessage(Arrays.toString(secretCode)));
        }
        scanner.close();
    }
}
