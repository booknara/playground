package com.booknara.problem.hash;

import org.junit.Assert;
import org.junit.Test;

public class TwoSumIIITest {
    @Test
    public void twoSum() {
        TwoSumIII twoSumIII = new TwoSumIII();
        twoSumIII.add(0);
        twoSumIII.add(0);
        Assert.assertTrue(twoSumIII.find(0));
        Assert.assertFalse(twoSumIII.find(1));
    }
}
