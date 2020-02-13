package com.booknara.problem.dp;

import org.junit.Assert;
import org.junit.Test;

public class MaximalRectangleTest {
    @Test
    public void maximalRectangle() {
        MaximalRectangle maximalRectangle = new MaximalRectangle();
        char[][] input = new char[][] {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        Assert.assertEquals(6, maximalRectangle.maximalRectangle(input));
    }
}
