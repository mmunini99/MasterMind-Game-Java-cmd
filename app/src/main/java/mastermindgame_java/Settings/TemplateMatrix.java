package mastermindgame_java.Settings;

import mastermindgame_java.LetGameRun.GameMessages;


public class TemplateMatrix {


    private final int lengthofguess;
    private final int lengthoffeedback = 3;

    private int[][] template;

    public TemplateMatrix(int lengthoftrials, int lengthofguess) {

        this.lengthofguess = lengthofguess;

        int ncolumn = lengthofguess + lengthoffeedback + 1;
        int nrow = lengthoftrials;
        this.template = new int[nrow][ncolumn];

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

        // System.out.println("count: " + count); // print the number of trials

        if (count == 0) {
            System.out.println(GameMessages.columnsNameTemplateGuesses());

            for (int j = 0; j < template[0].length; j++) {

                System.out.print(template[0][j] + "\t");

            }

            System.out.println();

        } else if (count >= 1) {



            System.out.println(GameMessages.columnsNameTemplateGuesses());

            for (int i = 0; i < count; i++) {

                System.out.println();
            }

            for (int i = 0; i < count; i++) {
                for (int j = 0; j < template[i].length; j++) {
                    System.out.print(template[i][j] + "\t");
                }

                System.out.println();
            }
       }
    }




}