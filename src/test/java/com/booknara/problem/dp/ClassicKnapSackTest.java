package com.booknara.problem.dp;

import org.junit.Assert;
import org.junit.Test;

public class ClassicKnapSackTest {
    @Test
    public void getHighestValueTest() {
        ClassicKnapSack classicKnapSack = new ClassicKnapSack();
        Assert.assertEquals(classicKnapSack.getHighestValue(
                new int[]{5, 4, 6, 3},
                new int[]{10, 40, 30, 50},
                10),
                90);

        Assert.assertEquals(classicKnapSack.getHighestValue(
                new int[]{1, 2, 3, 2, 2},
                new int[]{8, 4, 0, 5, 3},
                4),
                13);

        Assert.assertEquals(classicKnapSack.getHighestValue2(
                new int[]{5, 4, 6, 3},
                new int[]{10, 40, 30, 50},
                10),
                90);

        Assert.assertEquals(classicKnapSack.getHighestValue2(
                new int[]{1, 2, 3, 2, 2},
                new int[]{8, 4, 0, 5, 3},
                4),
                13);
    }
}
