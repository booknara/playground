package com.booknara.problem.dp;

/**
 * 304. Range Sum Query 2D - Immutable (Medium)
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 */
public class NumMatrix {
    int[][] dp;
    // T:O(n^2), S:O(n^2)
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int m = matrix.length, n = matrix[0].length;
        dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // each dp[i - 1][j] and dp[i][j - 1] already contains dp[i - 1][j - 1]
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // (row1, col1) ~ (row2, col2)
        return dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1];
    }
}
