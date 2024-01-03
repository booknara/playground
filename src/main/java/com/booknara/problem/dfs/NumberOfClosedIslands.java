package com.booknara.problem.dfs;

/**
 * 1254. Number of Closed Islands
 * https://leetcode.com/problems/number-of-closed-islands
 */
public class NumberOfClosedIslands {
  int[][] dirs = new int[][]{
      {-1, 0},
      {1, 0},
      {0, -1},
      {0, 1}
  };

  // T:O(n*m), S:O(1)
  public int closedIsland(int[][] grid) {
    if (grid == null || grid.length == 0) return 0;

    int res = 0;
    int m = grid.length;
    int n = grid[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          continue;
        }

        // case 0
        if (dfs(grid, i, j)) {
          res++;
        }
      }
    }

    return res;
  }

  public boolean dfs(int[][] grid, int i, int j) {
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
      return false;
    }
    if (grid[i][j] == 1) {
      return true;
    }

    grid[i][j] = 1;
    boolean res = true;
    for (int[] dir : dirs) {
      int r = i + dir[0];
      int c = j + dir[1];
      res = dfs(grid, r, c) && res;
    }

    return res;
  }
}
