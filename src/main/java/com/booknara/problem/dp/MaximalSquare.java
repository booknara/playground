package com.booknara.problem.dp;

/**
 * 221. Maximal Square (Medium)
 * https://leetcode.com/problems/maximal-square/
 */
public class MaximalSquare {
    // DP, Space O(min(n, m))
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

    // DP, Space O(n*m)
    public int maximalSquare1(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '0') {
                    continue;
                }

                dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                max = Math.max(max, dp[i][j] * dp[i][j]);
            }
        }

        return max;
    }
}
