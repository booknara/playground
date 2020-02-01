package com.booknara.problem.dp;

import org.junit.Assert;
import org.junit.Test;

public class CoinChangeTest {
    @Test
    public void coinChangeTest() {
        CoinChange coinChange = new CoinChange();
        Assert.assertEquals(3, coinChange.coinChange(new int[]{1, 2, 5}, 11));
        Assert.assertEquals(-1, coinChange.coinChange(new int[]{2}, 3));
        Assert.assertEquals(4, coinChange.coinChange(new int[]{2,5,10,1}, 27));
        Assert.assertEquals(20, coinChange.coinChange(new int[]{186,419,83,408}, 6249));

        Assert.assertEquals(3, coinChange.coinChangeTopdown(new int[]{1, 2, 5}, 11));
        Assert.assertEquals(-1, coinChange.coinChangeTopdown(new int[]{2}, 3));
        Assert.assertEquals(4, coinChange.coinChangeTopdown(new int[]{2,5,10,1}, 27));
        Assert.assertEquals(20, coinChange.coinChangeTopdown(new int[]{186,419,83,408}, 6249));
    }
}
