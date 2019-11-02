import java.util.HashSet;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.io.IOException;

public class DuplicateRemover {

  HashSet<String> uniqueWords = new HashSet<String>();

  public void remove (FileInputStream dataFile) {
    Scanner inFS = null;

    try {
      dataFile = new FileInputStream("problem1.txt");
      inFS = new Scanner(dataFile);

      while (inFS.hasNextLine()) {
        uniqueWords.add(inFS.nextLine());
      }

      dataFile.close();
    }
    catch (IOException except) {
      System.out.println("IOException: " + except.getMessage());
    }
  }

  public void write (FileOutputStream outputFile) {
    PrintWriter outFS = null;

    try {
      outputFile = new FileOutputStream("unique_words.txt");
      outFS = new PrintWriter(outputFile);

      for (String words : uniqueWords) {
        outFS.println(words);
      }

      if (outFS.checkError() == true) {
        System.out.println("An error has occurred");
      }

      outFS.flush();
      outputFile.close();
    }
    catch (IOException except) {
      System.out.println("IOException: " + except.getMessage());
    }
  }
}
