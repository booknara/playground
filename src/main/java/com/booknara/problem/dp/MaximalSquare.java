package com.booknara.problem.dp;

/**
 * 221. Maximal Square (Medium)
 * https://leetcode.com/problems/maximal-square/
 */
public class MaximalSquare {
    // T:O(n^2), s:O(min(n, m))
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[n + 1];
        int prev = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    max = Math.max(max, dp[j] * dp[j]);
                } else {
                    dp[j] = 0;
                }

                prev = temp;

            }
        }

        return max;
    }

    // T:O(m*n), s:O(m*n)
    public int maximalSquare1(char[][] matrix) {
        // input check
        if (matrix == null || matrix.length == 0) return 0;

        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') continue;

                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                } else {
                    // matrix[i][j] -> '1'
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max * max;
    }

    // T:O(m * n), S:O(m * n)
    public int maximalSquare2(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int res = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') continue;

                if (i - 1 >= 0 && j - 1 >= 0 &&
                        matrix[i - 1][j] == '1' && matrix[i][j - 1] == '1' && matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1],
                            Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                } else {
                    dp[i][j] = 1;
                }

                res = Math.max(res, dp[i][j] * dp[i][j]);
            }
        }

        return res;
    }
}
