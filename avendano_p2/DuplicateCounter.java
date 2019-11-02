import java.util.HashMap;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DuplicateCounter {

  HashMap<String, Integer> wordCounter = new HashMap<>();

  public void count (FileInputStream dataFile) {
    String str;
    Scanner inFS = null;

    try {
      dataFile = new FileInputStream("problem2.txt");
      inFS = new Scanner(dataFile);

      while (inFS.hasNextLine()) {

        str = inFS.nextLine();
        if (wordCounter.containsKey(str)) {
          wordCounter.put(str, wordCounter.get(str) + 1);
          continue;
        }
         wordCounter.putIfAbsent(str, 1);
       }
       dataFile.close();
    }
   catch (IOException except) {
      System.out.println("IOException: " + except.getMessage());
    }
  }

  public void write(FileOutputStream outputFile) {
    PrintWriter outFS = null;

    try {
      outputFile = new FileOutputStream("unique_word_counts.txt");
      outFS = new PrintWriter(outputFile);

      for (String key: wordCounter.keySet()) {
        outFS.println(key + " " + wordCounter.get(key));
        outFS.flush();
      }
      if (outFS.checkError() == true) {
        System.out.println("An error has occurred");
      }
      outputFile.close();
    }
   catch (IOException except) {
      System.out.println("IOException: " + except.getMessage());
    }
  }
}
