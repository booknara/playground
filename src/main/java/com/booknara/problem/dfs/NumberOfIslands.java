package com.booknara.problem.dfs;

/**
 * 200. Number of Islands (Medium)
 * https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfIslands {
    // T:O(n^2), S:O(1)
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int i, int j) {
        // out of scope or invalid case
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[i].length - 1 || grid[i][j] == '0') {
            return;
        }

        // grid[i][j] = '1' case
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
