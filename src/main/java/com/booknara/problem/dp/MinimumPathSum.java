package com.booknara.problem.dp;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        // Error handling
        if (grid == null) {
            return 0;
        }

        if (grid.length == 1 && grid[0].length == 1) {
            return grid[0][0];
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                int top = i - 1 >= 0 ? grid[i - 1][j] : Integer.MAX_VALUE;
                int left = j - 1 >= 0 ? grid[i][j - 1] : Integer.MAX_VALUE;
                grid[i][j] = Math.min(top, left) + grid[i][j];
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }

    public int minPathSum1(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        return minPathSumHelper(grid, 0, 0, memo);
    }

    private int minPathSumHelper(int[][] grid, int row, int col, int[][] memo) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return grid[row][col];
        }

        if(memo[row][col] != 0) {
            return memo[row][col];
        }

        int rowInc = Integer.MAX_VALUE, colInc = Integer.MAX_VALUE;
        if(row < grid.length - 1) {
            rowInc = minPathSumHelper(grid, row + 1, col, memo);
        }

        if(col < grid[0].length - 1) {
            colInc = minPathSumHelper(grid, row, col + 1, memo);
        }

        memo[row][col] = Math.min(rowInc, colInc) + grid[row][col];

        return memo[row][col];
    }
}
