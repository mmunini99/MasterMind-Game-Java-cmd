package mastermindgame_java.Settings;

import mastermindgame_java.LetGameRun.GameMessages;


public class TemplateMatrix {


    private final int lengthofguess;
    private final int lengthoffeedback = 3;

    private int[][] template;

    PrintString printString;
    GameMessages gameMessages;

    public TemplateMatrix(int lengthoftrials, int lengthofguess, boolean printToFile) {

        this.lengthofguess = lengthofguess;

        int ncolumn = lengthofguess + lengthoffeedback + 1;
        int nrow = lengthoftrials;
        this.template = new int[nrow][ncolumn];

        printString = new PrintString(printToFile);
        gameMessages = new GameMessages(printToFile);

    }

    public void setguess(int[] guess, int[] feedback, int count) {

        int ncolumn = lengthofguess + lengthoffeedback + 1;


        this.template[count][0] = count + 1;

        for (int i = 1; i < 5; i++) {
            this.template[count][i] = guess[i - 1];
        }

        for (int i = 5; i < ncolumn; i++) {
            this.template[count][i] = feedback[i - 5];
        }





    }


    public void printtemplate(int count) {

        if (count == 0) {
            gameMessages.columnsNameTemplateGuesses();
            int round = 0;

            String output = "";
            output = getTemplateOutput(output, template, round);

            printString.redirectOutput(output);

            printString.redirectOutput("");

        } else if (count >= 1) {

            gameMessages.columnsNameTemplateGuesses();

            String output = "";
            // for (int i = 0; i < count; i++) {
            //     output += "\n";
            // }

            for (int i = 0; i < count; i++) {
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