package com.booknara.problem.stack;

import org.junit.Assert;
import org.junit.Test;

public class BasicCalculatorIITest {
    @Test
    public void calculate() {
        BasicCalculatorII basicCalculatorII = new BasicCalculatorII();
        Assert.assertEquals(1, basicCalculatorII.calculate(" 3/2 "));
        Assert.assertEquals(7, basicCalculatorII.calculate("3+2*2"));
        Assert.assertEquals(5, basicCalculatorII.calculate(" 3+5 / 2 "));
    }
}
