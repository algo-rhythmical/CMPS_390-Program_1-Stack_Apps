import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) {

        String expr ="";
        Scanner input = new Scanner(System.in);
        System.out.print("Enter expression in (n+-/*n) +-/* (n+-/*n) format: ");
        expr = input.next();
        Operation myExpression = new Operation(expr);

    }
}
