package com.booknara.problem.dp;

/**
 * 583. Delete Operation for Two Strings (Medium)
 * https://leetcode.com/problems/delete-operation-for-two-strings/
 */
public class DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }

        if (word1.length() * word2.length() == 0) {
            return Math.max(word1.length(), word2.length());
        }

        // LCS(Longest Common Sequence)
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int len = dp[word1.length()][word2.length()];

        return word1.length() - len + word2.length() - len;
    }
}
