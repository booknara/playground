package com.booknara.problem.dfs;

/**
 * Leet code: 200 Number of Islands(Medium)
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    total++;
                    visitGrid(grid, i, j);
                }
            }
        }

        return total;
    }

    private void visitGrid(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length
                || j < 0 || j >= grid[i].length
                || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        // left
        visitGrid(grid, i - 1, j);
        // top
        visitGrid(grid, i, j - 1);
        // right
        visitGrid(grid, i + 1, j);
        // bottom
        visitGrid(grid, i, j + 1);
    }
}
