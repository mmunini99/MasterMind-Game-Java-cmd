package mastermindgame_java.LetGameRun;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

// Import the Scanner class, used to take user input
import java.util.Scanner;
import java.io.ByteArrayInputStream;

import java.io.File;
import java.util.stream.Stream;

// Import the assertions
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPlay {

    @ParameterizedTest
        @MethodSource("provideTestData_testLetGameRun")
        public void testLetGameRun(int[] secretCode, boolean expectedOutput, String input) {

            ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
            Scanner scanner = new Scanner(testIn);
            Play play = new Play(scanner, false);
            play.askForDifficulty();
            boolean returnedOutput = play.LetGameRun(secretCode);
            assertEquals(expectedOutput, returnedOutput);
            scanner.close();
        }
    
    static Stream<Arguments> provideTestData_testLetGameRun() {
        String basePath = "./src/test/java/mastermindgame_java/LetGameRun/";
        String currentDirectory = System.getProperty("user.dir");
        System.out.println("Current working directory: " + currentDirectory);
        String[] fileNames = {"TestInputs1.txt", "TestInputs2.txt", "TestInputs3.txt"};

        String[] input = new String[3];

        for (int i = 0; i < 3; i++) {
            input[i] = getInputFromTxt(basePath + fileNames[i]);
        }
        return Stream.of(
            Arguments.of(new int[] {0, 1, 0, 0}, true, input[0]),
            Arguments.of(new int[] {2, 0, 4, 4} , true, input[1]),
            Arguments.of(new int[] {1, 0, 1, 0}, false, input[2])
            );
    }

    private static String getInputFromTxt(String path) {
        File file = new File(path);
        String input = "";
        try{
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()){
                input += sc.nextLine().toString();
                input += "\n";
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return input;
    }

}
