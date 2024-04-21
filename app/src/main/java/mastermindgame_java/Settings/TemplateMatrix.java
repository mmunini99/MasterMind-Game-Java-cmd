package mastermindgame_java.Settings;

import mastermindgame_java.LetGameRun.GameMessages;


public class TemplateMatrix {


    private final int lengthofguess;
    private final int lengthoffeedback = 3;

    public int[][] template;

    PrintString printString;
    GameMessages gameMessages;

    public TemplateMatrix(int lengthOfTrials, int lengthOfGuess, boolean printToFile) {

        this.lengthofguess = lengthOfGuess;

        int ncolumn = lengthOfGuess + lengthoffeedback + 1;
        int nrow = lengthOfTrials;
        this.template = new int[nrow][ncolumn];

        printString = new PrintString(printToFile);
        gameMessages = new GameMessages(printToFile);

    }

    public void setGuess(int[] guess, int[] feedback, int count) {

        int ncolumn = lengthofguess + lengthoffeedback + 1;


        this.template[count][0] = count + 1;

        for (int i = 1; i < 5; i++) {
            this.template[count][i] = guess[i - 1];
        }

        for (int i = 5; i < ncolumn; i++) {
            this.template[count][i] = feedback[i - 5];
        }

    }


    public void printTemplate(int count) {

        if (count == 0) {
            gameMessages.columnsNameTemplateGuesses();
            int round = 0;

            String output = "";
            output = getTemplateOutput(output, template, round);

            printString.redirectOutput(output);

            printString.redirectOutput("");

        } else if (count >= 1) {

            gameMessages.columnsNameTemplateGuesses(); // TODO sure?

            String output = "";
            for (int i = 0; i < count; i++) {
                output += "\n";
            }

            for (int i = 0; i < count; i++) { // TODO sure?
                output = getTemplateOutput(output, template, i);

                output += "\n";
            }

            printString.redirectOutput(output);

       }
    }

    private String getTemplateOutput(String output, int[][] template, int round) {

        for (int j = 0; j < template[round].length; j++) {
            output += template[round][j] + "\t";
        }
        return output;
    }

}