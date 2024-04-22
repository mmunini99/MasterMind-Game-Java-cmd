package mastermindgame_java.LetGameRun;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Scanner;
import java.io.ByteArrayInputStream;

import java.io.File;
import java.util.stream.Stream;

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
        String basePath = "./src/test/java/mastermindgame_java/LetGameRun/TestPlayInputs/";

        String[] fileNames = { "Test1.txt", "Test2.txt", "Test3.txt", "Test4.txt", "Test5.txt", "Test6.txt" };

        String[] input = new String[fileNames.length];

        for (int i = 0; i < fileNames.length; i++) {
            input[i] = getInputFromTxt(basePath + fileNames[i]);
        }
        return Stream.of(
                Arguments.of(new int[] { 0, 1, 0, 0 }, true, input[0]),
                Arguments.of(new int[] { 2, 0, 4, 4 }, true, input[1]),
                Arguments.of(new int[] { 1, 0, 1, 0 }, false, input[2]),
                Arguments.of(new int[] { 5, 4, 5, 5 }, false, input[3]),
                Arguments.of(new int[] { 1, 2, 1, 2 }, true, input[4]),
                Arguments.of(new int[] { 4, 5, 3, 2 }, true, input[5]));
    }

    private static String getInputFromTxt(String path) {
        File file = new File(path);
        String input = "";
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
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
