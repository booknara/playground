package com.booknara.problem.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MinimumTimeDifferenceTest {
    @Test
    public void findMinDifference() {
        MinimumTimeDifference minimumTimeDifference = new MinimumTimeDifference();
        Assert.assertEquals(1, minimumTimeDifference.findMinDifference(Arrays.asList("23:59", "00:00")));
        Assert.assertEquals(1, minimumTimeDifference.findMinDifference(Arrays.asList("23:58", "00:00", "00:01")));
        Assert.assertEquals(147, minimumTimeDifference.findMinDifference(Arrays.asList("05:31","22:08","00:35")));
    }
}
