package com.booknara.problem.stack;

import org.junit.Assert;
import org.junit.Test;

public class BasicCalculatorTest {
    @Test
    public void calculate() {
        BasicCalculator basicCalculator = new BasicCalculator();
        Assert.assertEquals(92, basicCalculator.calculate(" 32 + 60"));
        Assert.assertEquals(4, basicCalculator.calculate("2-1+3"));
        Assert.assertEquals(55, basicCalculator.calculate(" (3+52 )"));
        Assert.assertEquals(23, basicCalculator.calculate("(1+(4+5+2)-3)+(6+8)"));

        Assert.assertEquals(-4, basicCalculator.calculate("1-(5)"));
    }
}
