package mastermindgame_java.Settings;

import java.util.Arrays;

import mastermindgame_java.LetGameRun.GameMessages;

public class ProvideFeedback {
    private int[] guess;
    private int[] secretCode;
    private int nRightNumbersRightPosition;
    private int nRightNumbersWrongPosition;
    private int nWrongNumbersWrongPosition;

    public ProvideFeedback(int[] secretCode) {
        this.secretCode = secretCode;
    }

    public int[] getFeedback(int[] guess) {
        this.guess = guess;
        this.nRightNumbersRightPosition = checkRightNumberRightPosition();
        this.nWrongNumbersWrongPosition = checkWrongNumberWrongPosition();
        this.nRightNumbersWrongPosition = checkRightNumberWrongPosition();
        return new int[] { nRightNumbersRightPosition, nRightNumbersWrongPosition, nWrongNumbersWrongPosition };
    }

    public void displayFeedback() {
        System.out.println(GameMessages.provideFeedback(nRightNumbersRightPosition, nRightNumbersWrongPosition,
                nWrongNumbersWrongPosition));
    }

    private int calculateMaxNumber() {
        return Math.max(Arrays.stream(secretCode).max().getAsInt(), Arrays.stream(guess).max().getAsInt());
    }

    private int[] calculateArrayMultiplicity(int[] array, int maxnumber) {
        int[] multiplicity = new int[maxnumber + 1];
        for (int i = 0; i < array.length; i++) {
            multiplicity[array[i]]++;
        }
        return multiplicity;
    }

    private int checkRightNumberRightPosition() {

        int rightNumbers = 0;

        int[] secretCode_flag = new int[secretCode.length];
        int[] guessCode_flag = new int[secretCode.length];

        for (int i = 0; i < guess.length; i++) {
            if (secretCode[i] == guess[i]) {
                rightNumbers++;
                secretCode_flag[i] = 1;
                guessCode_flag[i] = 1;
            }
        }

        return rightNumbers;
    }

    private int checkWrongNumberWrongPosition() {
        int maxnumber = calculateMaxNumber();

        int[] secretCodeMultiplicity = calculateArrayMultiplicity(secretCode, maxnumber);
        int[] guessMultiplicity = calculateArrayMultiplicity(guess, maxnumber);

        int wrongNumberWrongPosition = 0;
        for (int i = 0; i < secretCodeMultiplicity.length; i++) {
            if (guessMultiplicity[i] > secretCodeMultiplicity[i]) {
                wrongNumberWrongPosition += guessMultiplicity[i] - secretCodeMultiplicity[i];
            }
        }
        return wrongNumberWrongPosition;
    }

    private int checkRightNumberWrongPosition() {
        return secretCode.length - nRightNumbersRightPosition - nWrongNumbersWrongPosition;
    }
}