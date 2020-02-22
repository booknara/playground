package com.booknara.problem.twopointers;

import org.junit.Assert;
import org.junit.Test;

public class TwoSumIITest {
    @Test
    public void twoSum() {
        TwoSumII twoSumII = new TwoSumII();
        Assert.assertArrayEquals(new int[] {1, 2}, twoSumII.twoSum(new int[]{2, 7, 11, 15}, 9));
    }
}
