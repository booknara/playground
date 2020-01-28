package com.booknara.problem.array;

import org.junit.Assert;
import org.junit.Test;

public class TrappingRainWaterTest {
    @Test
    public void trapTest() {
        TrappingRainWater trappingRainWater = new TrappingRainWater();

        Assert.assertEquals(trappingRainWater.trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}), 6);
        Assert.assertEquals(trappingRainWater.trap(new int[] {2, 1, 0}), 0);
        Assert.assertEquals(trappingRainWater.trap(new int[] {1, 2, 3, 2, 1}), 0);
        Assert.assertEquals(trappingRainWater.trap(new int[] {3, 2, 1, 2, 3}), 4);

        Assert.assertEquals(trappingRainWater.trap1(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}), 6);
        Assert.assertEquals(trappingRainWater.trap1(new int[] {2, 1, 0}), 0);
        Assert.assertEquals(trappingRainWater.trap1(new int[] {1, 2, 3, 2, 1}), 0);
        Assert.assertEquals(trappingRainWater.trap1(new int[] {3, 2, 1, 2, 3}), 4);
    }
}
