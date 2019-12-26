package com.booknara.problem.dp;

import org.junit.Assert;
import org.junit.Test;

public class MinCostClimbStairsTest {
    @Test
    public void minCostClimbingStairsTest() {
        MinCostClimbStairs minCostClimbStairs = new MinCostClimbStairs();
        Assert.assertEquals(6, minCostClimbStairs.minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        Assert.assertEquals(15, minCostClimbStairs.minCostClimbingStairs(new int[] {10, 15, 20}));

        Assert.assertEquals(15, minCostClimbStairs.optimizedMinCostClimbingStairs(new int[] {10, 15, 20}));
        Assert.assertEquals(30, minCostClimbStairs.optimizedMinCostClimbingStairs(new int[] {10, 15, 20, 20}));
    }
}
