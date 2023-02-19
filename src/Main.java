import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        try {
            Scanner scan = new Scanner(new File("src//Infixes"));
            while (scan.hasNextLine()) {
                Operation s = new Operation(scan.nextLine());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
