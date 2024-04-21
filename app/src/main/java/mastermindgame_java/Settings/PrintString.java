package mastermindgame_java.Settings;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintString {
    PrintStream printStream;
    boolean printToFile;

    public String filePath = "output.txt";

    public PrintString(boolean printToFile) {
        this.printToFile = printToFile;

        
    }





    public void redirectOutput(String input) {
        try {
            if (printToFile) {
                printToTxt(input);
            } else {
                printToCommandLine(input);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private void printToCommandLine(String input) {
        System.out.println(input);
    }



    private void printToTxt(String input) throws FileNotFoundException, IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(filePath, true);
        this.printStream = new PrintStream(fileOutputStream);
        System.setOut(printStream);
        printToCommandLine(input);
        printStream.close();
        fileOutputStream.close();
    }

    public void cleanFile() {
        try {
            // Create a FileOutputStream without append mode (truncate)
            FileOutputStream fileOutputStream = new FileOutputStream(filePath, false);
            
            // Close the FileOutputStream to truncate the file
            fileOutputStream.close();
            
            System.out.println("File cleaned successfully.");
        } catch (IOException e) {
            System.err.println("Error cleaning the file: " + e.getMessage());
        }
    }
    
}
