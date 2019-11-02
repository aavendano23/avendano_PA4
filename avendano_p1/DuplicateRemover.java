import java.util.HashSet;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.util.Scanner;

public class DuplicateRemover {

  HashSet<String> uniqueWords = new HashSet<String>();

  public void remove (Scanner dataFile) {
    // read in data fileRead
     while (dataFile.hasNextLine()) {
       uniqueWords.add(dataFile.nextLine());
     }
  }

  public void write (PrintWriter outputFile) {
    System.out.println("\nIn write method\n" + uniqueWords);
    for (String words : uniqueWords) {
      outputFile.println(words);
    }
    outputFile.flush();
  }
}
