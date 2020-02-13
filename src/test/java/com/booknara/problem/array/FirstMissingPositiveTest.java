package com.booknara.problem.array;

import org.junit.Assert;
import org.junit.Test;

public class FirstMissingPositiveTest {
    @Test
    public void firstMissingPositive() {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        Assert.assertEquals(3, firstMissingPositive.firstMissingPositive(new int[] {1,2,0}));
        Assert.assertEquals(2, firstMissingPositive.firstMissingPositive(new int[] {3,4,-1,1}));
        Assert.assertEquals(1, firstMissingPositive.firstMissingPositive(new int[] {7,8,9,11,12}));
    }
}
