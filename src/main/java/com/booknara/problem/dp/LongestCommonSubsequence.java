package com.booknara.problem.dp;

/**
 * 1143. Longest Common Subsequence (Medium)
 * https://leetcode.com/problems/longest-common-subsequence/
 */
public class LongestCommonSubsequence {
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

    public int longestCommonSubsequence1(String text1, String text2) {
        if (text1 == null || text1.length() == 0
                || text2 == null || text2.length() == 0) {
            return 0;
        }

        int[][] memo = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i < text1.length() + 1; i++) {
            for (int j = 1; j < text2.length() + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }

        return memo[text1.length()][text2.length()];
    }
}
