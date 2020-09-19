package com.booknara.problem.dp;

/**
 * 304. Range Sum Query 2D - Immutable (Medium)
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 */
public class NumMatrixII {
    int[][] matrix;

    // T:O(n*m), S:O(1)
    public NumMatrixII(int[][] matrix) {
        this.matrix = matrix;

        if (matrix == null || matrix.length == 0) return;

        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                int up = 0;
                int left = 0;
                int diagonal = 0;
                if (i != 0) left = matrix[i - 1][j];
                if (j != 0) up = matrix[i][j - 1];
                if (i != 0 && j != 0) diagonal = matrix[i - 1][j - 1];

                matrix[i][j] = left + up - diagonal + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int up = 0, left = 0, diagonal = 0;
        if (row1 != 0) up = matrix[row1 - 1][col2];
        if (col1 != 0) left = matrix[row2][col1 - 1];
        if (row1 != 0 && col1 != 0) diagonal = matrix[row1 - 1][col1 - 1];

        return matrix[row2][col2] - up - left + diagonal;
    }
}
