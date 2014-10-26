/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fraccalc;

import junit.framework.*;

public class FracCalcTest implements Test {

    
    public void testIntegerAddition() {
        Assert.assertEquals("2", FracCalc.calculate("1 + 1"));
    }

    
    public void testAdditionBasic() {
        Assert.assertEquals("2/5", FracCalc.calculate("1/5 + 1/5"));
        Assert.assertEquals("1_1/5", FracCalc.calculate("3/5 + 3/5"));
        Assert.assertEquals("1_1/5", FracCalc.calculate("4/5 + 2/5"));
        Assert.assertEquals("1/4", FracCalc.calculate("1/8 + 1/8"));
    }

    
    public void testAdditionIntermediate() {
        Assert.assertEquals("2/5", FracCalc.calculate("3/5 + -1/5"));
        Assert.assertEquals("5_5/6", FracCalc.calculate("20/8 + 3_1/3"));
        Assert.assertEquals("1", FracCalc.calculate("3/5 + 2/5"));
        Assert.assertEquals("1_1/20", FracCalc.calculate("4/5 + 2/8"));
        Assert.assertEquals("452", FracCalc.calculate("452 + 0"));
        Assert.assertEquals("2", FracCalc.calculate("1 + 1"));
        Assert.assertEquals("4", FracCalc.calculate("1 + 3"));
        Assert.assertEquals("254", FracCalc.calculate("0 + 254"));
        Assert.assertEquals("1021778", FracCalc.calculate("124543 + 897235"));
        Assert.assertEquals("900", FracCalc.calculate("978 + -78"));
    }

    
    public void testAdditionAdvanced() {
        Assert.assertEquals("-9035", FracCalc.calculate("-9035 + 0"));
        Assert.assertEquals("-64", FracCalc.calculate("64 + -128"));
        Assert.assertEquals("-133", FracCalc.calculate("-98 + -35"));
        Assert.assertEquals("62_11/19", FracCalc.calculate("0 + 34_543/19"));
        Assert.assertEquals("-44_229/888", FracCalc.calculate("-38_3/72 + -4_82/37"));
        Assert.assertEquals("-7/8", FracCalc.calculate("5_3/4 - 6_5/8"));
    }

    
    public void testSubtractionBasic() {
        Assert.assertEquals("1/5", FracCalc.calculate("3/5 - 2/5"));
        Assert.assertEquals("4/5", FracCalc.calculate("9/10 - 1/10"));
        Assert.assertEquals("0", FracCalc.calculate("1/5 - 1/5"));
        Assert.assertEquals("0", FracCalc.calculate("4_1/2 - 4_1/2"));
    }

    
    public void testSubtractionIntermediate() {
        Assert.assertEquals("0", FracCalc.calculate("68591 - 68591"));
        Assert.assertEquals("-36891", FracCalc.calculate("48623 - 85514"));
        Assert.assertEquals("-9284", FracCalc.calculate("0 - 9284"));
        Assert.assertEquals("-2/5", FracCalc.calculate("2/5 - 4/5"));
        Assert.assertEquals("-1_5/8", FracCalc.calculate("4_1/2 - 5_9/8"));
        Assert.assertEquals("-1_1/8", FracCalc.calculate("3_3/4 - 4_7/8"));
    }

    
    public void testSubtractionAdvanced() {
        Assert.assertEquals("12_3/8", FracCalc.calculate("5_3/4 - -6_5/8"));
        Assert.assertEquals("8_5/21", FracCalc.calculate("-12_3/7 - -20_2/3"));
        Assert.assertEquals("-1_5/12", FracCalc.calculate("-2/3 - 3/4"));
    }

    
    public void testMultiplicationBasic() {
        Assert.assertEquals("3", FracCalc.calculate("1_1/2 * 2"));
        Assert.assertEquals("6/25", FracCalc.calculate("3/5 * 2/5"));
        Assert.assertEquals("0", FracCalc.calculate("0 * 0"));
        Assert.assertEquals("0", FracCalc.calculate("0 * 9321"));
        Assert.assertEquals("0", FracCalc.calculate("0 * -5902"));
        Assert.assertEquals("164268", FracCalc.calculate("234 * 702"));
        Assert.assertEquals("216", FracCalc.calculate("12 * 18"));
        Assert.assertEquals("8", FracCalc.calculate("12/3 * 2/1"));
    }

    
    public void testMultiplicationIntermediate() {
        Assert.assertEquals("2", FracCalc.calculate("16 * 1/8"));
        Assert.assertEquals("0", FracCalc.calculate("0 * 4/5"));
        Assert.assertEquals("2", FracCalc.calculate("3 * 2/3"));
        Assert.assertEquals("1_1/2", FracCalc.calculate("6 * 1/4"));
        Assert.assertEquals("8994872", FracCalc.calculate("1 * 8994872"));
    }

    
    public void testMultiplicationAdvanced() {
        Assert.assertEquals("-842346", FracCalc.calculate("1 * -842346"));
        Assert.assertEquals("-75421", FracCalc.calculate("-1 * 75421"));
        Assert.assertEquals("37953", FracCalc.calculate("-1 * -37953"));
        Assert.assertEquals("8", FracCalc.calculate("-12/3 * -2/1"));
    }

    
    public void testDivisionBasic() {
        Assert.assertEquals("9/16", FracCalc.calculate("3/4 / 4/3"));
        Assert.assertEquals("2_1/4", FracCalc.calculate("3/2 / 2/3"));
        Assert.assertEquals("9457", FracCalc.calculate("9457 / 1"));
        Assert.assertEquals("0", FracCalc.calculate("0 / 37569"));
        Assert.assertEquals("6/11", FracCalc.calculate("6 / 11"));
        Assert.assertEquals("4/9", FracCalc.calculate("4 / 9"));
        Assert.assertEquals("1", FracCalc.calculate("23 / 23"));
        Assert.assertEquals("2_6/7", FracCalc.calculate("20 / 7"));
        Assert.assertEquals("13/24", FracCalc.calculate("1_1/12 / 2"));
    }

    
    public void testDivisionIntermediate() {
        Assert.assertEquals("2_2/3", FracCalc.calculate("16/4 / 3/2"));
        Assert.assertEquals("0", FracCalc.calculate("0 / -98701"));
        Assert.assertEquals("1", FracCalc.calculate("3/4 / 3/4"));
        Assert.assertEquals("-2_2/3", FracCalc.calculate("16/4 / -3/2"));
    }

    
    public void testDivisionAdvanced() {
        Assert.assertEquals("1_5/8", FracCalc.calculate("-13 / -8"));
        Assert.assertEquals("-5/21", FracCalc.calculate("1_2/3 / -5_6/3"));
        Assert.assertEquals("6_661/5520", FracCalc.calculate("-38_3/72 / -4_82/37"));
        Assert.assertEquals("-2803", FracCalc.calculate("-2803 / 1"));
        Assert.assertEquals("-12457", FracCalc.calculate("12457 / -1"));
        Assert.assertEquals("45236", FracCalc.calculate("-45236 / -1"));
        Assert.assertEquals("-2_6/7", FracCalc.calculate("-20 / 7"));
    }

    @Override
    public int countTestCases() {
        return 13;
    }

    @Override
    public void run(TestResult result) {
        testIntegerAddition();
        testAdditionBasic();
        testAdditionIntermediate();
        testAdditionAdvanced();
        testSubtractionBasic();
        testSubtractionIntermediate();
        testSubtractionAdvanced();
        testMultiplicationBasic();
        testMultiplicationIntermediate();
        testMultiplicationAdvanced();
        testDivisionBasic();
        testDivisionIntermediate();
        testDivisionAdvanced();
    }
}
