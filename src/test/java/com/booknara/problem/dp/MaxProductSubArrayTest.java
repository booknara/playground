package com.booknara.problem.dp;

import org.junit.Assert;
import org.junit.Test;

public class MaxProductSubArrayTest {
    @Test
    public void maxProductTest() {
        MaxProductSubArray maxProductSubArray = new MaxProductSubArray();
        Assert.assertEquals(maxProductSubArray.maxProduct(new int[]{2, 3, -2, 4}), 6);
        Assert.assertEquals(maxProductSubArray.maxProduct(new int[]{-2, 0, -1}), 0);
        Assert.assertEquals(maxProductSubArray.maxProduct(new int[]{-2, -1}), 2);
        Assert.assertEquals(maxProductSubArray.maxProduct(new int[]{1, 2, 0, 3, 2}), 6);
        Assert.assertEquals(maxProductSubArray.maxProduct(new int[]{-4,-3,-2}), 12);

    }
}
