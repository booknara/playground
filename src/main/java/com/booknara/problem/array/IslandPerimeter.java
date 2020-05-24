package com.booknara.problem.array;

/**
 * 463. Island Perimeter (Easy)
 * https://leetcode.com/problems/island-perimeter/
 */
public class IslandPerimeter {
    // Looping, T:O(n^2), S:O(1)
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    res += getPerimeter(grid, i, j);
                }
            }
        }

        return res;
    }

    private int getPerimeter(int[][] grid, int r, int c) {
        int res = 0;
        // top
        if (r == 0 || grid[r - 1][c] == 0) res++;
        // bottom
        if (r == grid.length - 1 || grid[r + 1][c] == 0) res++;
        // left
        if (c == 0 || grid[r][c - 1] == 0) res++;
        // right
        if (c == grid[r].length - 1 || grid[r][c + 1] == 0) res++;
        return res;
    }

    // DFS, T:(n^2), S:O(1)
    public int islandPerimeter1(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }

        return 0;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
            return 1;
        }

        if (grid[i][j] == -1) return 0;
        // used -1 for visited grid
        grid[i][j] = -1;

        return dfs(grid, i - 1, j)
                + dfs(grid, i + 1, j)
                + dfs(grid, i, j - 1)
                + dfs(grid, i, j + 1);
    }
}
