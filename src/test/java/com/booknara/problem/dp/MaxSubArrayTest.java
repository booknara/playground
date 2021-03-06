package com.booknara.problem.dp;

import org.junit.Assert;
import org.junit.Test;

public class MaxSubArrayTest {
    @Test
    public void maxSubArrayTest() {
        MaxSubArray maxSubArray = new MaxSubArray();

        Assert.assertEquals(maxSubArray.maxSubArray(new int[] {0, 1}), 1);
        Assert.assertEquals(maxSubArray.maxSubArray(new int[] {2, 0, 1}), 3);
        Assert.assertEquals(maxSubArray.maxSubArray(new int[] {2, -1, 1}), 2);
        Assert.assertEquals(maxSubArray.maxSubArray(new int[] {-2,-1}), -1);
        Assert.assertEquals(maxSubArray.maxSubArray(new int[] {-1,-2}), -1);
        Assert.assertEquals(maxSubArray.maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}), 6);
    }
}
