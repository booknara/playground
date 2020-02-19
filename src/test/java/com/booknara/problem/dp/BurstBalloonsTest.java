package com.booknara.problem.dp;

import org.junit.Assert;
import org.junit.Test;

public class BurstBalloonsTest {
    @Test
    public void maxCoins() {
        BurstBalloons burstBalloons = new BurstBalloons();
        Assert.assertEquals(167, burstBalloons.maxCoins(new int[] {3, 1, 5, 8}));
    }
}
