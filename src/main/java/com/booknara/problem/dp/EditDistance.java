package com.booknara.problem.dp;

/**
 * 72. Edit Distance (Hard)
 * https://leetcode.com/problems/edit-distance/
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if (n * m == 0) {
            return n + m;
        }

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                    continue;
                }

                if (j == 0) {
                    dp[i][j] = i;
                    continue;
                }
                int left = dp[i][j - 1];
                int top = dp[i - 1][j];
                int leftTop = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = getMin(left, top, leftTop - 1) + 1;
                } else {
                    dp[i][j] = getMin(left, top, leftTop) + 1;
                }
            }
        }

        return dp[n][m];
    }

    public int getMin(int i, int j, int k) {
        return Math.min(k, Math.min(i, j));
    }
}
