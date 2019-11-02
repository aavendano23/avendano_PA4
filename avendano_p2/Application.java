import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Application {

  public static void closeFileReader(FileInputStream fileName, FileOutputStream outFile) {
      try {
         if (fileName != null) {
            System.out.println("Closing problem1 file.");
            fileName.close();
            System.out.println("Closing uniquewords file.");
            outFile.close();
         }
      } catch (IOException closeExcpt) {
         System.out.println("Error closing file: " + closeExcpt.getMessage());
      }
   }

  public static void main (String[] args) {

    DuplicateCounter duplicateCounter = new DuplicateCounter();
    FileInputStream inStream = null;
    Scanner inFS = null;
    FileOutputStream outStream = null;
    PrintWriter outFS = null;

    try {
      inStream = new FileInputStream("problem2.txt");
      inFS = new Scanner(inStream);
      outStream = new FileOutputStream("unique_word_counts.txt");
      outFS = new PrintWriter(outStream);

      duplicateCounter.count(inFS);

      duplicateCounter.write(outFS);
    }
   catch (IOException except) {
      System.out.println("IOException: " + except.getMessage());
    }
   finally {
    closeFileReader(inStream, outStream);
   }
  }
}
