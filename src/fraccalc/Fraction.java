package fraccalc;

/**
 * FracCalc Fraction Class.
 *
 * @author Thomas Nijssen
 * @date 23-Sep-2014
 * @class AP CS-A period 1
 */
public class Fraction {

    /**
     * The whole number part of the fraction.
     */
    public int whole;
    
    /**
     * The numerator part of the fraction.
     */
    public int numerator;
    
    /**
     * The denominator part of the fraction.
     */
    public int denominator;

    /**
     * Constructs a new {@link Fraction} object with the given parts.
     * 
     * @param whole
     * @param numerator
     * @param denominator 
     */
    public Fraction(int whole, int numerator, int denominator) {
        /* Ensure only whole or numerator is negative */
        if((whole < 0) || (numerator < 0 && denominator < 0)) {
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
        } else if(numerator > 0 && denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        } else if(numerator < 0 || denominator < 0) {
            denominator = Math.abs(denominator);
        }
        
        this.whole = whole;
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
    /**
     * Given a valid string representation of a {@link Fraction}, create a new {@link Fraction} object with those parameters.
     * Passing any string that is not a valid {@link Fraction} object has undefined behaviour.
     * 
     * @param str
     * @return a new {@link Fraction} object with the given parameters.
     */
    public static Fraction parseStr(String str) {
        int whole, num, denom;

        // Split by underscore
        String[] wholeParts = str.split("_");
        if (wholeParts.length == 2) {
            //We have a whole as well as the fraction
            whole = Integer.parseInt(wholeParts[0]);
        } else {
            //we have only a fraction or a whole
            whole = 0;
        }

        //Now, split the fraction
        int fracIndex = wholeParts.length == 2 ? 1 : 0;
        String[] fracParts = wholeParts[fracIndex].split("/");

        num = Integer.parseInt(fracParts[0]);

        if (fracParts.length == 2) {
            //it is a fraction
            denom = Integer.parseInt(fracParts[1]);
        } else {
            //it is only a whole
            denom = 1;
        }

        //Return the fraction object
        return new Fraction(whole, num, denom);
    }

    /**
     * Converts this {@link Fraction} object into an improper fraction.
     * 
     * @return a new {@link Fraction} object, with the parameters of the current one as an improper fraction.
     */
    public Fraction toImproper() {
        int newnum = Math.abs(this.denominator * this.whole) + Math.abs(this.numerator);
        int numnegative = (this.whole < 0 || this.numerator < 0 || this.denominator < 0) ? -1 : 1;
        return new Fraction(0, numnegative * newnum, this.denominator);
    }

    /**
     * Utility method to set the base of the fraction to something else.
     * 
     * @param newBase
     * @return a new {@link Fraction} object that can be safely added to another.
     */
    public Fraction changeBase(int newBase) {
        int multiplier = newBase / this.denominator;
        return new Fraction(this.whole, this.numerator * multiplier, newBase);
    }

    /**
     * Adds two {@link Fraction}s together: the <code>other</code> to <code>this</code>. Base changing is handled internally.
     * @param other
     * @return a new {@link Fraction} object.
     */
    public Fraction add(Fraction other) {
        int newBase = other.denominator == this.denominator ? this.denominator : other.denominator * this.denominator;
        Fraction a = this.toImproper().changeBase(newBase);
        Fraction b = other.toImproper().changeBase(newBase);

        return new Fraction(a.whole + b.whole, a.numerator + b.numerator, newBase);
    }

    /**
     * Subtracts two {@link Fraction}s: <code>other</code> from <code>this</code>. Base changing is handled internally.
     * 
     * @param other
     * @return a new {@link Fraction} object.
     */
    public Fraction subtract(Fraction other) {
        int newBase = other.denominator == this.denominator ? this.denominator : other.denominator * this.denominator;
        Fraction a = this.toImproper().changeBase(newBase);
        Fraction b = other.toImproper().changeBase(newBase);

        return new Fraction(a.whole - b.whole, a.numerator - b.numerator, newBase);
    }

    /**
     * Multiplies two {@link Fraction}s together: <code>this</code> with <code>other</code>.
     * 
     * @param other
     * @return a new {@link Fraction} object.
     */
    public Fraction multiply(Fraction other) {
        Fraction a = this.toImproper();
        Fraction b = other.toImproper();
        return new Fraction(0, a.numerator * b.numerator, a.denominator * b.denominator);
    }

    /**
     * Divide <code>this</code> / <code>other</code>.
     * 
     * @param other
     * @return a new {@link Fraction} object.
     */
    public Fraction divide(Fraction other) {
        Fraction a = this.toImproper();
        Fraction b = other.toImproper();

        //"flip the fraction and multiply"
        return new Fraction(0, a.numerator * b.denominator, a.denominator * b.numerator);
    }

    /**
     * Simplify <code>this</code>.
     * @return a new {@link Fraction} object.
     */
    public Fraction simplify() {
        int gcm = (int) gcm(this.numerator, this.denominator);

        int newNum = this.numerator / gcm;
        int newDenom = this.denominator / gcm;
        int newWhole = this.whole;

        if (Math.abs(newNum) > Math.abs(newDenom)) {
            newWhole += newNum / newDenom;
            newNum = newNum % newDenom;
        }
        else if(newNum == newDenom) {
            newWhole += (newWhole < 0) ? -1 : 1;
            newNum = newDenom = 0;
        }

        return new Fraction(newWhole, newNum, newDenom);
    }

    /**
     * Find the GCM of two integers, using Euclid's method.
     * @param a
     * @param b
     * @return the GCM of {@link a} and {@link b}.
     */
    private static long gcm(int a, int b) {
        if(b == 0) return a;
        return gcm(b, a % b);
    }

    /**
     * Represents the current {@link Fraction} object as a string.
     * 
     * @return a String representation of the current Fraction object.
     * 
     */
    @Override
    public String toString() {
        String out = "";
        
        if((this.whole == 0) && (this.numerator == 0)) {
            return "0";
        }

        //add sign
        out += (this.whole >= 0 && (this.numerator < 0 || this.denominator < 0)) ? "-" : "";
        
        //put whole number
        out += (this.whole != 0)
                ? this.whole
                : "";

        //only if it isn't a whole number
        if (this.numerator != 0) {
            out += this.whole != 0 ? "_" : "";
            out += Math.abs(this.numerator);
            out += this.denominator != 1 ? ("/" + Math.abs(this.denominator)) : "";
        }

        return out;
    }
}
