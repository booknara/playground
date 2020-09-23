package com.booknara.problem.dp;

/**
 * 1143. Longest Common Subsequence (Medium)
 * https://leetcode.com/problems/longest-common-subsequence/
 */
public class LongestCommonSubsequence {
    // T:O(m*n), S:O(min(m, n))
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.length() == 0
                || text2 == null || text2.length() == 0) {
            return 0;
        }

        int[][] memo = new int[2][text2.length() + 1];
        for (int i = 1, k = 1; i < text1.length() + 1; i++, k ^= 1) {
            for (int j = 1; j < text2.length() + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    memo[k][j] = memo[k ^ 1][j - 1] + 1;
                } else {
                    memo[k][j] = Math.max(memo[k][j - 1], memo[k ^ 1][j]);
                }
            }
        }

        return memo[text1.length() % 2][text2.length()];
    }

    // T:O(m*n), S:O(m*n)
    public int longestCommonSubsequence1(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) return 0;

        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // i = text1, j = text2
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        return dp[m][n];
    }
}
