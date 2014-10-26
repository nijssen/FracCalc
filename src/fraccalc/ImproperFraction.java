/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fraccalc;

/**
 * Lab 
 * @author Thomas Nijssen
 * @date 23-Sep-2014
 * @class AP CS-A period 1
 */
public class ImproperFraction {
    public int numerator;
    public int denominator;
    
    public ImproperFraction(int numerator, int denominator)
    {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
    public ImproperFraction(Fraction in)
    {
        this.numerator = in.denominator * in.whole + in.numerator;
        this.denominator = in.denominator;
    }
    
    
}
