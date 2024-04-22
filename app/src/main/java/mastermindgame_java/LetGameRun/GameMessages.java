package mastermindgame_java.LetGameRun;

import static mastermindgame_java.Settings.SetDifficulty.Level;

import mastermindgame_java.Settings.PrintString;

public class GameMessages {

    boolean printToFile;

    PrintString printString;

    public GameMessages(boolean printToFile) {
        this.printToFile = printToFile;

        printString = new PrintString(printToFile);
    }

    public static String firstWelcomeMessage(String level) {
        return String.format("\nYou will play with the %s level. Have a nice game!\n", level);
    }

    public static String secondWelcomeMessage(int digitCount, int maxNumber) {
        return String.format("Welcome to Mastermind! Try to guess the %d-digit secret code using numbers from 0 to %d or type %s to quit the game.\n", digitCount, maxNumber, "EXIT");
    }

    public static String chooseDifficultyMessage() {   
        return String.format("Choose difficulty between %s, %s and %s or type %s to quit the game:", 
        Level.EASY.toString(), Level.MEDIUM.toString(), Level.HARD.toString(), "EXIT");
    }

    public static String difficultyInputNotValid() {
        return String.format("Invalid difficulty. Please try again or type %s to quit the game:", "EXIT");
    }

    public static String declareNumberOfTrials(int trials) {
        return String.format("You have %d trials to guess the sequence.\n", trials);
    }

    public static String displayRemainingTrials(int remainingTrials) {
        return String.format("You have %d guesses left. Good luck!\n", remainingTrials);
    }

    public static String provideFeedback(int correctPosition, int correctDigit, int wrongGuesses) {
        return String.format("Feedback: %d correct position, %d correct digit, %d wrong guesses\n", correctPosition, correctDigit, wrongGuesses);
    }

    public static String enterYourGuess(int digitCount) {
        return String.format("Enter your %d-digit guess: ", digitCount);
    }

    public static String invalidInputSequence(int digitCount, int maxNumber) {
        return String.format("Invalid input. Please enter a %d-digit number using digits from 0 to %d.\n", digitCount, maxNumber);
    }

    public static String lostMessage(String correctCombination) {
        return String.format("Sorry you lost!\nThe correct combination was: %s\n", correctCombination);
    }

    public static String secretCodeWasGuessed() {
        return "Congratulations! You guessed the secret code!\n";
    }

    public static String provideFinalScore(int score) {
        return String.format("Final score: %d\n", score);
    }

    public static String exitGameMessage() {
        return "Exiting the game...\n";
    }

    public static String templateGuesses() {
        return "These are your previous guesses: \n";
    }

    public void columnsNameTemplateGuesses() {
        String output = "Trial\tPos1\tPos2\tPos3\tPos4\tOK\tN-OK\tNO\n";
        printString.redirectOutput(output);

    }

    public static String invalidLevel() {
        return "Invalid difficulty level";
    }
}