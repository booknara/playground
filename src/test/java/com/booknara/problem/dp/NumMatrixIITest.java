package com.booknara.problem.dp;

import org.junit.Assert;
import org.junit.Test;

public class NumMatrixIITest {
    @Test
    public void numMatrix() {
        int[][] matrix = new int[][] {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrixII numMatrixII = new NumMatrixII(matrix);
        Assert.assertEquals(8, numMatrixII.sumRegion(2, 1, 4, 3));
        Assert.assertEquals(11, numMatrixII.sumRegion(1, 1, 2, 2));
        Assert.assertEquals(12, numMatrixII.sumRegion(1, 2, 2, 4));
    }
}
