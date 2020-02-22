package com.booknara.problem.twopointers;

import org.junit.Assert;
import org.junit.Test;

public class ThreeSumClosestTest {
    @Test
    public void threeSumClosest() {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        Assert.assertEquals(2, threeSumClosest.threeSumClosest(new int[] {-1, 2, 1, -4}, 1));
        Assert.assertEquals(-3, threeSumClosest.threeSumClosest(new int[] {-1, 2, 1, -4}, -3));
        Assert.assertEquals(-4, threeSumClosest.threeSumClosest(new int[] {-1, 2, 1, -4}, -4));
    }
}
