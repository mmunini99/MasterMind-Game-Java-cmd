package mastermindgame_java.Settings;

import static mastermindgame_java.LetGameRun.GameMessages.*;

import java.util.Scanner;

public class GetUserInput {

    private Scanner scanner;

    public GetUserInput(Scanner scanner) {
        this.scanner = scanner;
    }

    private void checkExit(String input) {
        // If the user types "EXIT", exit the game
        if ("EXIT".equalsIgnoreCase(input.toUpperCase())) {
            System.out.println(exitGameMessage());
            System.exit(0); // Exit the program
        }
    }

    public String getUserInput() {
        String input = scanner.nextLine();
        checkExit(input);
        return input;
    }
    
}