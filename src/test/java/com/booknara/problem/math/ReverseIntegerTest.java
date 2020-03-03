package com.booknara.problem.math;

import org.junit.Assert;
import org.junit.Test;

public class ReverseIntegerTest {
    @Test
    public void reverse() {
        ReverseInteger reverseInteger = new ReverseInteger();
        Assert.assertEquals(321, reverseInteger.reverse(123));
        Assert.assertEquals(0, reverseInteger.reverse(1534236469));
        Assert.assertEquals(-321, reverseInteger.reverse(-123));
        Assert.assertEquals(21, reverseInteger.reverse(120));

        Assert.assertEquals(321, reverseInteger.reverseSimpler(123));
        Assert.assertEquals(-321, reverseInteger.reverseSimpler(-123));
        Assert.assertEquals(21, reverseInteger.reverseSimpler(120));
        Assert.assertEquals(0, reverseInteger.reverseSimpler(1534236469));
    }
}
