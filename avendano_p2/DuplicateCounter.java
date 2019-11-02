import java.util.HashMap;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.util.Scanner;

public class DuplicateCounter {

  HashMap<String, Integer> wordCounter = new HashMap<>();

  public void count (Scanner dataFile) {
    String str;

    while (dataFile.hasNextLine()) {

      str = dataFile.nextLine();
      if (wordCounter.containsKey(str)) {
        wordCounter.put(str, wordCounter.get(str) + 1);
        continue;
      }
       wordCounter.putIfAbsent(str, 1);
     }

     //System.out.println("keys: " + wordCounter.keySet());
     //System.out.println("values: " + wordCounter.values());

  }

  public void write(PrintWriter outputFile) {
    //outputFile.println()

    for (String key: wordCounter.keySet()) {
      outputFile.println(key + " " + wordCounter.get(key));
      outputFile.flush();
    }

  }

}
