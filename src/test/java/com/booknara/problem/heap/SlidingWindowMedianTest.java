package com.booknara.problem.heap;

import org.junit.Assert;
import org.junit.Test;

public class SlidingWindowMedianTest {
    @Test
    public void medianSlidingWindow() {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        int[] input = {-2147483648,-2147483648,2147483647,2147483647};
        double[] output = {-2147483648.00000,2147483647.00000};
        Assert.assertArrayEquals(output, slidingWindowMedian.medianSlidingWindow(input, 3), 0.0);
    }
}
