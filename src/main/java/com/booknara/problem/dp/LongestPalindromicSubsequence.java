package com.booknara.problem.dp;

/**
 * 516. Longest Palindromic Subsequence (Medium)
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 */
public class LongestPalindromicSubsequence {
    // O(n^2): Bottom up DP
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[][] memo = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            memo[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    memo[i][j] = 2 + memo[i + 1][j - 1];
                } else {
                    memo[i][j] = Math.max(memo[i][j - 1],
                            memo[i + 1][j]);
                }
            }
        }

        return memo[0][s.length() - 1];
    }
    // O(n^2): Two down DP
    public int longestPalindromeSubseq1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int max = 0;
        int[][] memo = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                // the total number of subproblems (s.length * s.length)
                max = Math.max(max, dfs(memo, s, i, j));
            }
        }

        return max;
    }

    private int dfs(int[][] memo, String s, int row, int col) {
        // System.out.println(row + "," + col);
        if (memo[row][col] != 0) return memo[row][col];
        if (row == col) return 1;

        int res = 0;
        if (s.charAt(row) == s.charAt(col)) {
            if (row + 1 == col) {
                res = 2;
            } else {
                res = 2 + dfs(memo, s, row + 1, col - 1);
            }
        } else {
            res = Math.max(dfs(memo, s, row, col - 1),
                    dfs(memo, s, row + 1, col));
        }

        memo[row][col] = res;
        return res;
    }
}
