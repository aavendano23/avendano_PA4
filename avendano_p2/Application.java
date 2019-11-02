import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Application {

  public static void main (String[] args) {

    DuplicateCounter duplicateCounter = new DuplicateCounter();
    FileInputStream inStream = null;
    FileOutputStream outStream = null;

    duplicateCounter.count(inStream);
    duplicateCounter.write(outStream);

  }
}
