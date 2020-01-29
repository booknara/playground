package com.booknara.problem.dp;

import org.junit.Assert;
import org.junit.Test;

public class ClimbingStairsTest {
    @Test
    public void climbStairs() {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        Assert.assertEquals(2, climbingStairs.climbStairs(2));
        Assert.assertEquals(3, climbingStairs.climbStairs(3));
    }
}
