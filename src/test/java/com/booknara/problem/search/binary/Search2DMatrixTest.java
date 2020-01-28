package com.booknara.problem.search.binary;

import org.junit.Assert;
import org.junit.Test;

public class Search2DMatrixTest {
    @Test
    public void searchMatrixTest() {
        Search2DMatrix search2DMatrix = new Search2DMatrix();
        int[][] input = new int[][] {
                {1,   3,  5, 7},
                {10,  11,  16, 20},
                {23,  30,  34, 50},
        };

        Assert.assertTrue(search2DMatrix.searchMatrix(input, 3));
        Assert.assertFalse(search2DMatrix.searchMatrix(input, 13));
    }
}
