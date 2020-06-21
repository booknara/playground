package com.booknara.problem.dp;

/**
 * 174. Dungeon Game (Hard)
 * https://leetcode.com/problems/dungeon-game/
 */
public class DungeonGame {
    /**
     * input: two dimension array - dungeon
     * output: minimum initial health
     */
    // T:O(n^2), S:O(n^2)
    public int calculateMinimumHP(int[][] dungeon) {
        // input check
        if (dungeon == null || dungeon.length == 0) return 1;

        int row = dungeon.length + 1;
        int col = dungeon[0].length + 1;
        int[][] dp = new int[row][col];
        // dp value initialization
        for (int i = 0;i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((i == row - 2 && j == col - 1) || i == row - 1 && j == col - 2) {
                    dp[i][j] = 1;
                    continue;
                }

                dp[i][j] = Integer.MAX_VALUE;
            }
        }


        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                // dp[i][j] -> depends on future states
                // dp[i][j] + dungeon[i][j] = min(dp[i + 1][j], dp[i][j + 1])
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                if (dp[i][j] < 1) dp[i][j] = 1; // dp[i][j] shouldn't be 0 or below because of death
            }
        }

        return dp[0][0];
    }
}
