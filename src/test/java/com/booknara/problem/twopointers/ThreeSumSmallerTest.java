package com.booknara.problem.twopointers;

import org.junit.Assert;
import org.junit.Test;

public class ThreeSumSmallerTest {
    @Test
    public void threeSumSmaller() {
        ThreeSumSmaller threeSumSmaller = new ThreeSumSmaller();
        Assert.assertEquals(2, threeSumSmaller.threeSumSmaller(new int[]{-2, 0, 1, 3}, 2));
    }
}
