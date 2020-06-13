package com.booknara.problem.math;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubsetTest {
    @Test
    public void largestDivisibleSubset() {
        LargestDivisibleSubset largestDivisibleSubset = new LargestDivisibleSubset();
        List<Integer> expectedReult = Arrays.asList(1, 2, 8);
        Assert.assertEquals(expectedReult, largestDivisibleSubset.largestDivisibleSubset(new int[]{5, 2, 1, 8}));
    }
}
