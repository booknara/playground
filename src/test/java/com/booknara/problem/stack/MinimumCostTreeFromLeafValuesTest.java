package com.booknara.problem.stack;

import org.junit.Assert;
import org.junit.Test;

public class MinimumCostTreeFromLeafValuesTest {
    @Test
    public void mctFromLeafValues() {
        MinimumCostTreeFromLeafValues minimumCostTreeFromLeafValues
                = new MinimumCostTreeFromLeafValues();
        Assert.assertEquals(500, minimumCostTreeFromLeafValues.mctFromLeafValues(new int[] {15,13,5,3,15}));
        Assert.assertEquals(32, minimumCostTreeFromLeafValues.mctFromLeafValues(new int[] {6,2,4}));
    }
}
