package fraccalc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author thomas
 */
public class FracCalc {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        InputStream buf = null;
        if(args.length == 0) {
            buf = System.in;
        } else {
            buf = new FileInputStream(new File(args[0]));
        }

        System.err.println("Welcome!");
        
        Scanner sc = new Scanner(buf);
        
        while (1==1) {
            String input = sc.nextLine();
            if(input.equals("quit")) {
                System.err.println("bye");
                break;
            }
            System.out.println(calculate(input));
        }

    }

    public static String calculate(String input) {
        String[] parts = input.split("\\s");

        if ((parts.length % 2) == 0 || parts.length == 1) {
            System.err.println("Bad input.");
            return "";
        }

        int i = 0;

        Fraction out = Fraction.parseStr(parts[i++]);
        while (i < parts.length) {
            char op = parts[i++].charAt(0);
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
        
        return out.simplify().toString();
    }
}
