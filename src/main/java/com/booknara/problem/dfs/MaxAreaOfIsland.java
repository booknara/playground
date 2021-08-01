package com.booknara.problem.dfs;

/**
 * 695. Max Area of Island (Medium)
 * https://leetcode.com/problems/max-area-of-island/
 */
public class MaxAreaOfIsland {
  public int maxAreaOfIsland(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int max = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          int area = dfs(grid, i, j, 0);
          max = Math.max(max, area);
        }
      }
    }

    return max;
  }

  private int dfs(int[][] grid, int r, int c, int n) {
    if (r < 0 || r == grid.length || c < 0 || c == grid[0].length
        || grid[r][c] == 0) {
      return 0;
    }

    grid[r][c] = 0;

    return 1 + dfs(grid, r, c - 1, n)
        + dfs(grid, r, c + 1, n)
        + dfs(grid, r - 1, c, n)
        + dfs(grid, r + 1, c, n);
  }

  int[][] dirs = new int[][]{
      {-1, 0},
      {1, 0},
      {0, -1},
      {0, 1}
  };

  public int maxAreaOfIsland1(int[][] grid) {
    // input check
    if (grid == null) return 0;

    int res = 0;
    int m = grid.length;
    int n = grid[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        res = Math.max(res, getMaxArea(grid, i, j));
      }
    }

    return res;
  }

  public int getMaxArea(int[][] grid, int i, int j) {
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
      return 0;
    }

    int res = 1;
    grid[i][j] = 0;
    // checking 4 directions
    for (int d = 0; d < dirs.length; d++) {
      res += getMaxArea(grid, i + dirs[d][0], j + dirs[d][1]);
    }

    return res;
  }
}
