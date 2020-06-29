package com.booknara.problem.dp;

/**
 * 62. Unique Paths (Medium)
 * https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths {
    // input : integer (m, n)
    // output : the possible number of way from top-left to bottom-right
    // T:O(n*m), S:O(n*m)
    public int uniquePaths(int m, int n) {
        // input check : 1 <= m, n <= 100
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                if (i == 1 && j == 1) {
                    dp[i][j] = 1;
                    continue;
                }

                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m][n];
    }
}
