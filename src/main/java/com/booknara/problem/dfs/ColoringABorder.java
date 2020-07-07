package com.booknara.problem.dfs;

/**
 * 1034. Coloring A Border (Medium)
 * https://leetcode.com/problems/coloring-a-border/
 */
public class ColoringABorder {
    // T:O(n^2),  S:O(1)
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        // input check 1 <= grid.length <= 50, 1 <= grid[0].length <= 50

        dfs(grid, r0, c0, grid[r0][c0]);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] < 0) {
                    grid[i][j] = color;
                }
            }
        }

        return grid;
    }

    public void dfs(int[][] grid, int r, int c, int oldColor) {
        // base case
        if (r < 0 || c < 0 || r == grid.length || c == grid[r].length || grid[r][c] != oldColor) {
            return;
        }

        // update the target value to negative
        grid[r][c] *= -1;
        // 4 directions
        // top
        dfs(grid, r - 1, c, oldColor);
        // bottom
        dfs(grid, r + 1, c, oldColor);
        // left
        dfs(grid, r, c - 1, oldColor);
        // right
        dfs(grid, r, c + 1, oldColor);

        if (r > 0 && r < grid.length - 1 && c > 0 && c < grid[r].length - 1
                && Math.abs(grid[r - 1][c]) == oldColor
                && Math.abs(grid[r + 1][c]) == oldColor
                && Math.abs(grid[r][c - 1]) == oldColor
                && Math.abs(grid[r][c + 1]) == oldColor) {
            // in case of the same value in all 4 directions
            grid[r][c] = oldColor;
        }
    }
}
