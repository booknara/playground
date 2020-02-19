package com.booknara.problem.dp;

/**
 * Leet code : 10. Regular Expression Matching (Hard)
 * https://leetcode.com/problems/regular-expression-matching/
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if ((s == null && p == null)
                || (s.length() == 0 && p.length() == 0)) {
            return true;
        }

        //
        boolean[][] memo = new boolean[s.length() + 1][p.length() + 1];
        memo[0][0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j)
                        || p.charAt(j) == '.') {
                    memo[i + 1][j + 1] = memo[i][j];
                } else if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) == '.' || s.charAt(i) == p.charAt(j - 1)) {
                        // TODO: Check again because it's not working
                        memo[i + 1][j + 1] = memo[i + 1][j - 1] || memo[i][j + 1];
                    } else {
                        memo[i + 1][j + 1] = memo[i + 1][j - 1];
                    }
                } else {
                    memo[i + 1][j + 1] = false;
                }
            }
        }

        return memo[s.length()][p.length()];
    }
}
