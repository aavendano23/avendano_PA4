import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.io.FileInputStream;
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

    DuplicateRemover duplicateRemover =  new DuplicateRemover();
    FileInputStream inStream = null;
    Scanner inFS = null;
    FileOutputStream outStream = null;
    PrintWriter outFS = null;

    try {
      inStream = new FileInputStream("problem1.txt");
      inFS = new Scanner(inStream);
      outStream = new FileOutputStream("unique_words.txt");
      outFS = new PrintWriter(outStream);

      duplicateRemover.remove(inFS);

      duplicateRemover.write(outFS);
    }
    catch (IOException except) {
      System.out.println("IOException: " + except.getMessage());
    }
    finally {
    closeFileReader(inStream, outStream);
    }


  }

}
