package com.booknara.problem.array;

/**
 * 1277. Count Square Submatrices with All Ones (Medium)
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 */
public class CountSquareSubmatricesWithAllOnes {
    // T:O(n^2), S:O(1)
    public int countSquares(int[][] matrix) {
        if (matrix == null || matrix[0].length == 0) return 0;

        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }

                if (i == 0 || j == 0) {
                    // For first row and col
                    res += matrix[i][j];
                } else {
                    // check three elements and get the min + 1
                    matrix[i][j] = getMin(matrix[i - 1][j - 1],
                            matrix[i - 1][j],
                            matrix[i][j - 1]) + 1;
                    res += matrix[i][j];
                }
            }
        }

        return res;
    }

    public int getMin(int x, int y, int z) {
        return Math.min(Math.min(x, y), z);
    }
}
