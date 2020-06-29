package com.booknara.problem.dp;

/**
 * 63. Unique Paths II (Medium)
 * https://leetcode.com/problems/unique-paths-ii/
 */
public class UniquePathsII {
    // input : integer (m, n)
    // output : the possible number of way from top-left to bottom-right
    // T:O(m*n), S:O(m*n)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // input check
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;

        // edge case (start element is 1)
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
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

                if (obstacleGrid[i - 1][j - 1] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}
