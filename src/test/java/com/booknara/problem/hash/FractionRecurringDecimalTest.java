package com.booknara.problem.hash;

import org.junit.Assert;
import org.junit.Test;

public class FractionRecurringDecimalTest {
    @Test
    public void fractionToDecimal() {
        FractionRecurringDecimal fractionRecurringDecimal = new FractionRecurringDecimal();
        Assert.assertEquals("-6.25", fractionRecurringDecimal.fractionToDecimal(-50, 8));
        Assert.assertEquals("0.5", fractionRecurringDecimal.fractionToDecimal(1, 2));
        Assert.assertEquals("2", fractionRecurringDecimal.fractionToDecimal(2, 1));
        Assert.assertEquals("0.(6)", fractionRecurringDecimal.fractionToDecimal(2, 3));
    }
}
