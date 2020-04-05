package com.booknara.problem.array;

import org.junit.Assert;
import org.junit.Test;

public class SubarraySumEqualsKTest {
    @Test
    public void subarraySum() {
        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        Assert.assertEquals(2, subarraySumEqualsK.subarraySum(new int[] {1, 1, 1}, 2));
        Assert.assertEquals(0, subarraySumEqualsK.subarraySum(new int[] {1}, 0));
        Assert.assertEquals(55, subarraySumEqualsK.subarraySum(new int[] {0,0,0,0,0,0,0,0,0,0}, 0));

        Assert.assertEquals(2, subarraySumEqualsK.subarraySum1(new int[] {1, 1, 1}, 2));
        Assert.assertEquals(0, subarraySumEqualsK.subarraySum1(new int[] {1}, 0));
        Assert.assertEquals(55, subarraySumEqualsK.subarraySum1(new int[] {0,0,0,0,0,0,0,0,0,0}, 0));

        Assert.assertEquals(2, subarraySumEqualsK.subarraySum2(new int[] {1, 1, 1}, 2));
        Assert.assertEquals(0, subarraySumEqualsK.subarraySum2(new int[] {1}, 0));
        Assert.assertEquals(55, subarraySumEqualsK.subarraySum2(new int[] {0,0,0,0,0,0,0,0,0,0}, 0));
    }
}
