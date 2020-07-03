package com.booknara.problem.math;

import org.junit.Assert;
import org.junit.Test;

public class LCMTest {
    @Test
    public void getGCD() {
        Assert.assertEquals(60, LCM.getLCM(10, 12));
        Assert.assertEquals(36, LCM.getLCM(12, 18));
        Assert.assertEquals(36, LCM.getLCM(12, 18, 6));
    }
}
