package com.booknara.problem.dp;

/**
 * 1463. Cherry Pickup II (Hard)
 * https://leetcode.com/problems/cherry-pickup-ii/
 */
public class CherryPickupII {
  // T:O(m*n*n), S:O(m*n*n)
  public int cherryPickup(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int[][][] dp = new int[m][n][n];    // DP state: row, col1, col2
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          dp[i][j][k] = -1;
        }
      }
    }

    return dp(grid, dp, 0, 0, n - 1);
  }

  // (row, col1) -> R1, (row, col2) -> R2
  public int dp(int[][] grid, int[][][] dp, int row, int col1, int col2) {
    // base case
    if (row >= grid.length || col1 < 0 || col2 < 0
        || col1 >= grid[0].length || col2 >= grid[0].length) {
      return 0;
    }
    if (dp[row][col1][col2] != -1) {
      return dp[row][col1][col2];
    }

    int res = 0;
    res += Math.max(grid[row][col1], grid[row][col2]);
    if (col1 != col2) {
      res += Math.min(grid[row][col1], grid[row][col2]);
    }
    int max = 0;
    // left-down, down, right-down
    for (int i = col1 - 1; i <= col1 + 1; i++) {
      for (int j = col2 - 1; j <= col2 + 1; j++) {
        max = Math.max(max, dp(grid, dp, row + 1, i, j));
      }
    }
    res += max;

    dp[row][col1][col2] = res;
    return res;
  }
}
