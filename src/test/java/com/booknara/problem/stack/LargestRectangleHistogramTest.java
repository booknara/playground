package com.booknara.problem.stack;

import org.junit.Assert;
import org.junit.Test;

public class LargestRectangleHistogramTest {
    @Test
    public void largestRectangleArea() {
        LargestRectangleHistogram largestRectangleHistogram = new LargestRectangleHistogram();
        Assert.assertEquals(10, largestRectangleHistogram.largestRectangleArea(new int[] {2,1,5,6,2,3}));
        Assert.assertEquals(16, largestRectangleHistogram.largestRectangleArea(new int[] {6,7,5,2,4,5,9,3}));
    }
}
