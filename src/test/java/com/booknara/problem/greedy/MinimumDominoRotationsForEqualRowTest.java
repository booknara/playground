package com.booknara.problem.greedy;

import org.junit.Assert;
import org.junit.Test;

public class MinimumDominoRotationsForEqualRowTest {
    @Test
    public void minDominoRotations() {
        MinimumDominoRotationsForEqualRow mr = new MinimumDominoRotationsForEqualRow();
        Assert.assertEquals(2, mr.minDominoRotations(new int[]{2,1,2,4,2,2}, new int[]{5,2,6,2,3,2}));
        Assert.assertEquals(-1, mr.minDominoRotations(new int[]{3,5,1,2,3}, new int[]{3,6,3,3,4}));
        Assert.assertEquals(1, mr.minDominoRotations(new int[]{1,2,1,1,1,2,2,2}, new int[]{2,1,2,2,2,2,2,2}));
    }
}
