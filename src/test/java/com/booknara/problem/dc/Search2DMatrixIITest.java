package com.booknara.problem.dc;

import org.junit.Assert;
import org.junit.Test;

public class Search2DMatrixIITest {
    @Test
    public void searchMatrixTest() {
        Search2DMatrixII search2DMatrixII = new Search2DMatrixII();
        int[][] input = new int[][] {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30},
        };

        Assert.assertTrue(search2DMatrixII.searchMatrix(input, 5));
        Assert.assertFalse(search2DMatrixII.searchMatrix(input, 20));

        Assert.assertFalse(search2DMatrixII.searchMatrix(new int[][] {{}}, 1));
        Assert.assertTrue(search2DMatrixII.searchMatrix(new int[][] {{5}, {6}}, 5));
    }
}
