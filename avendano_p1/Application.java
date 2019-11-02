import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Application {

  public static void main (String[] args) {

    DuplicateRemover duplicateRemover =  new DuplicateRemover();
    FileInputStream inStream = null;
    FileOutputStream outStream = null;

    duplicateRemover.remove(inStream);
    duplicateRemover.write(outStream);
  }
}
