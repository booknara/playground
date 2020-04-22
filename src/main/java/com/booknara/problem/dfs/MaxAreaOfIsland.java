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
}
