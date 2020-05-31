package com.booknara.problem.dp;

/**
 * 72. Edit Distance (Hard)
 * https://leetcode.com/problems/edit-distance/
 */
public class EditDistance {
    // DP space optimization, T:O(n*m), S:O(n)
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if (n * m == 0) return n + m;

        int[][] dp = new int[2][m + 1];
        int row = 1;

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                // row initialization
                if (i == 0) {
                    dp[row][j] = j;
                    continue;
                }

                // column initialization
                if (j == 0) {
                    dp[row][j] = i;
                    continue;
                }

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // no change
                    dp[row][j] = dp[row ^ 1][j - 1];
                } else {
                    // dp[i - 1][j - 1] : replace a character
                    // dp[i][j - 1], dp[i - 1][j] : insert/delete a character
                    dp[row][j] = getMin(dp[row ^ 1][j - 1], dp[row][j - 1], dp[row ^ 1][j]) + 1;
                }
            }

            row ^= 1;
        }

        return dp[row ^ 1][m];
    }

    // DP, T:O(n*m), S:O(n*m)
    public int minDistance1(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if (n * m == 0) return n + m;

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                // row initialization
                if (i == 0) {
                    dp[i][j] = j;
                    continue;
                }

                // column initialization
                if (j == 0) {
                    dp[i][j] = i;
                    continue;
                }

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // no change
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // dp[i - 1][j - 1] : replace a character
                    // dp[i][j - 1], dp[i - 1][j] : insert/delete a character
                    dp[i][j] = getMin(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]) + 1;
                }
            }
        }

        return dp[n][m];
    }

    public int getMin(int i, int j, int k) {
        return Math.min(k, Math.min(i, j));
    }
}
