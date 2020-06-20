package com.booknara.problem.dp;

import org.junit.Assert;
import org.junit.Test;

public class DecodeWaysTest {
    @Test
    public void numDecodings() {
        DecodeWays decodeWays = new DecodeWays();
        Assert.assertEquals(2, decodeWays.numDecodings("12"));
        Assert.assertEquals(3, decodeWays.numDecodings("226"));
        Assert.assertEquals(0, decodeWays.numDecodings("01"));
        Assert.assertEquals(5898240, decodeWays.numDecodings("1787897759966261825913315262377298132516969578441236833255596967132573482281598412163216914566534565"));

    }
}
