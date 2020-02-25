package com.booknara.problem.stack;

import org.junit.Assert;
import org.junit.Test;

public class BasicCalculatorIIITest {
    @Test
    public void calculate() {
        BasicCalculatorIII basicCalculatorIII = new BasicCalculatorIII();
        Assert.assertEquals(4, basicCalculatorIII.calculate(" (6-4)+2"));

        Assert.assertEquals(92, basicCalculatorIII.calculate(" 32 + 60"));
        Assert.assertEquals(4, basicCalculatorIII.calculate("2-1+3"));
        Assert.assertEquals(55, basicCalculatorIII.calculate(" (3+52 )"));
        Assert.assertEquals(23, basicCalculatorIII.calculate("(1+(4+5+2)-3)+(6+8)"));
        Assert.assertEquals(-4, basicCalculatorIII.calculate("1-(5)"));
        Assert.assertEquals(-12, basicCalculatorIII.calculate("(2+6* 3+5- (3*14/7+2)*5)+3"));
    }

}
