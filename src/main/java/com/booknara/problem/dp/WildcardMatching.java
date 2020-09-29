package com.booknara.problem.dp;

/**
 * 44. Wildcard Matching (Hard)
 * https://leetcode.com/problems/wildcard-matching/
 */
public class WildcardMatching {
    // T:O(m*n), S:O(m*n)
    public boolean isMatch(String s, String p) {
        // inpput check
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        // init
        for (int j = 1; j <= n; j++) {
            if(p.charAt(j-1) == '*'){
                dp[0][j] = true;
            } else {
                // can't be true after a letter appears
                break;
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    if (s.charAt(i - 1) == p.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }

        return dp[m][n];
    }
}
/**
 '?' Matches any single character.
 '*' Matches any sequence of characters (including the empty sequence).

 .*a*b
 .ttfff
 aftttf
 dftftf
 cftftf
 eftftf
 bftftt

 .a*c?
 .tffff
 afttff
 cffttf
 dfftft
 cffttf

 Input:
 s = "adceb"
 p = "*a*b"
 Output: true
 Explanation: The first '*' matches the empty sequence,
 while the second '*' matches the substring "dce".
 */