package com.booknara.problem.dp;

import org.junit.Assert;
import org.junit.Test;

public class LongestStringChainTest {
    @Test
    public void longestStrChain() {
        LongestStringChain longestStringChain = new LongestStringChain();
        Assert.assertEquals(4, longestStringChain.longestStrChain(new String[] {"a","b","ba","bca","bda","bdca"}));
    }
}
