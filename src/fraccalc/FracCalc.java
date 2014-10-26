package fraccalc;

import java.util.Scanner;

/**
 * FracCalc main program class.
 * 
 * @author Thomas Nijssen
 * @see Fraction
 * 
 */
public class FracCalc {

    /**
     * Main Entry point.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.err.println("Welcome!");
        
        Scanner sc = new Scanner(System.in);
        
        while (1==1) {
            String input = sc.nextLine();
            if(input.equals("quit")) {
                System.err.println("bye");
                break;
            }
            System.out.println(calculate(input));
        }

    }

    /**
     * Given an expression as a String, this returns a String with the result.
     * 
     * @param input
     * @return The result of the expression.
     */
    public static String calculate(String input) {
        //Split the expression into tokens
        String[] parts = input.split("\\s");

        //Must have an odd number of tokens, but more than 1.
        if ((parts.length % 2) == 0 || parts.length == 1) {
            System.err.println("Bad input.");
            return "";
        }

        //Token counter
        int i = 0;

        Fraction out = Fraction.parseStr(parts[i++]);
        
        //For each two tokens...
        while (i < parts.length) {
            //...get the operation...
            char op = parts[i++].charAt(0);
            
            //...and the second operand.
            Fraction cur = Fraction.parseStr(parts[i++]);

            switch (op) {
                case '+':
                    out = out.add(cur);
                    break;
                case '-':
                    out = out.subtract(cur);
                    break;
                case '*':
                    out = out.multiply(cur);
                    break;
                case '/':
                    out = out.divide(cur);
                    break;
                default:
                    System.err.println("Unrecognized operator.");
                    return "";
            }
        }
        
        //Simplify and return
        return out.simplify().toString();
    }
}
