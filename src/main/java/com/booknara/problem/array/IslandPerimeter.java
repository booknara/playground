package com.booknara.problem.array;

/**
 * 463. Island Perimeter (Easy)
 * https://leetcode.com/problems/island-perimeter/
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int peri = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    peri += getPerimeter(grid, i, j);
                }
            }
        }

        return peri;
    }

    public int getPerimeter(int[][] grid, int r, int c) {
        int total = 0;
        // Left
        if (c == 0 || grid[r][c - 1] != 1) {
            total++;
        }
        // Right
        if (c + 1 == grid[r].length || grid[r][c + 1] != 1) {
            total++;
        }
        // Top
        if (r == 0 || grid[r - 1][c] != 1) {
            total++;
        }
        // Bottom
        if (r + 1 == grid.length || grid[r + 1][c] != 1) {
            total++;
        }

        return total;
    }
}
