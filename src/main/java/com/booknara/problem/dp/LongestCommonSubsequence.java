package com.booknara.problem.dp;

/**
 * Leet code : 1143 (Medium)
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 *
 * A subsequence of a string is a new string generated from the original string with some characters(can be none)
 * deleted without changing the relative order of the remaining characters.
 * (eg, "ace" is a subsequence of "abcde" while "aec" is not).
 * A common subsequence of two strings is a subsequence that is common to both strings.
 *
 * If there is no common subsequence, return 0.
 *
 * Constraints:
 *
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * The input strings consist of lowercase English characters only.
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
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

    public int optimizelongestCommonSubsequence(String text1, String text2) {
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
}
