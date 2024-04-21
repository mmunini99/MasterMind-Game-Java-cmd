// package mastermindgame_java.Settings;

// import mastermindgame_java.Settings.TemplateMatrix;

// import org.junit.jupiter.params.ParameterizedTest;
// import org.junit.jupiter.params.provider.CsvSource;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// public class TestTemplateMatrix {

//     // Check that the generated matrix of guesses has the same number of columns of
//     // the number of trials that a player has.

//     @ParameterizedTest
//     @CsvSource({
//             "10, 3, 10",
//             "15, 3, 15",
//             "12, 3, 12",
//             "46, 3, 46",
//             "2, 3, 2",
//             "1, 3, 1",
//             "7, 3, 7"
//     })
//     public void testGetTemplate(int exampleOfLengthOfTrials, int guessLength, int expectedOutput) {
//         TemplateMatrix matrixOfResult = new TemplateMatrix(exampleOfLengthOfTrials, guessLength);
//         int[][] matrixTry = matrixOfResult.printtemplate(exampleOfLengthOfTrials);
//         int output = matrixTry.length;
//         assertEquals(expectedOutput, output);
//     }



    

//     // Check that the generated matrix of guesses has always the same number of rows
//     // unconditionally of the number of trials that a player has.
//     @Test
//     public void testnumberofrowsdoesnotchange() {

//         int[] exampleoflengthoftrials = {10, 15, 12, 46, 2, 1, 7}; //number of trials

//         int guesslength = 4;

//         int ExpectedOutput = 8;

//         for(int i = 0; i < exampleoflengthoftrials.length; i++) {
//             TemplateMatrix matrixofresult = new TemplateMatrix(exampleoflengthoftrials[i], guesslength);
//             int[][] matrix_try = matrixofresult.gettemplate();
//             int output = matrix_try[0].length;
//             assertEquals(ExpectedOutput, output);
//         }
//     }



// }
