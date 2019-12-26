package com.booknara.problem.dp;

import org.junit.Assert;
import org.junit.Test;

public class MinimumPathSumTest {
    @Test
    public void minPathSumTest() {
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        Assert.assertEquals(7, minimumPathSum.minPathSum(new int[][] {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1},
        }));

        Assert.assertEquals(7, minimumPathSum.minPathSum1(new int[][] {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1},
        }));
    }
}
