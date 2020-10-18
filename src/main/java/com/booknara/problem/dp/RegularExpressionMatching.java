package com.booknara.problem.dp;

/**
 * 10. Regular Expression Matching (Hard)
 * https://leetcode.com/problems/regular-expression-matching/
 */
public class RegularExpressionMatching {
    // T:O(n*m), S:O(n*m), Invalid test case ("aa", "*a")
    public boolean isMatch(String s, String p) {
        // input check
        if (s == null && p == null) return true;
        if (s == null || p == null) return false;

        int m = s.length(); // s -> i
        int n = p.length(); // p -> j

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        // '*' handling for input pattern
        for (int j = 1; j < n + 1; j++) {
            if (j > 1 && p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1)) {
                    // matching characters
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '.') {
                    // any single character
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    // zero or more of the preceding element
                    // 2 cases
                    if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        // only an empty string
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        // empty or single or more string
                        dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }
}
/**
 "aaa"
 "a*"

 "b*" vs "aa" -> F
 "a*" vs "aa" -> T ("a*" -> "" or "a" or "aa")
 "ab*" vs "aaa" -> F ("ab*" -> "a" or "ab" or "abb")
   0 a b *
 0 T F F F
 a F T F T
 a F F F F
 a F F F F


   0 a * a .
 0 T F T F F
 a F T T T F
 a F F T T T
 a F F T T
 b F F T T


 Input: s = "aab", p = "c*a*b"

 . c * a * b
 . t f t f t f
 a f f f t t f
 a f f f f t f
 b f f f f f t

 Input: s = "ab", p = ".*"
 Output: true

 0 . *
 0 t f t
 a f t t
 b f f t

 Output: true
 */