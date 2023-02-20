import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            boolean isValid;
            String expr="";

            Scanner scan = new Scanner(new File("src//Infixes"));
            while (scan.hasNextLine()) {
                expr = (scan.nextLine());
                isValid = Operation.validate(expr);
                if (isValid) {
                    System.out.println(" : Validation complete");
                    String transExp = Operation.translate(expr);
                    System.out.println("Value after evaluating expression is " + Operation.evaluate(transExp) +"\n");
                }else
                    System.out.println(" : Invalid parenthesis!"+ "\n");
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}