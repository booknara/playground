package com.booknara.problem.hash;

import org.junit.Assert;
import org.junit.Test;

public class TwoSumTest {
    @Test
    public void twoSum() {
        TwoSum twoSum = new TwoSum();
        Assert.assertArrayEquals(new int[] {0, 1}, twoSum.twoSum(new int[]{2, 7, 11, 15}, 9));
    }
}
