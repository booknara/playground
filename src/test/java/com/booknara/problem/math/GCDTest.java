package com.booknara.problem.math;

import org.junit.Assert;
import org.junit.Test;

public class GCDTest {
    @Test
    public void getGCD() {
        Assert.assertEquals(2, GCD.getGCD(10, 12));
        Assert.assertEquals(6, GCD.getGCD(12, 18));

        Assert.assertEquals(2, GCD.getGCD1(10, 12));
        Assert.assertEquals(6, GCD.getGCD1(12, 18));

        Assert.assertEquals(2, GCD.getGCD2(10, 12));
        Assert.assertEquals(6, GCD.getGCD2(12, 18));

        Assert.assertEquals(2, GCD.getGCD(10, 12, 2));
        Assert.assertEquals(6, GCD.getGCD(12, 18, 6));
    }
}
