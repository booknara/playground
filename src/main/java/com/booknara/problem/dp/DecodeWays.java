package com.booknara.problem.dp;

/**
 * 91. Decode Ways (Medium)
 * https://leetcode.com/problems/decode-ways/
 */
public class DecodeWays {
    // DP solution, T:O(n), S:O(n)
    public int numDecodings(String s) {
        // Assume s is valid to generate decode ways
        if (s == null || s.length() == 0) return 0;

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            // one digit
            char c = s.charAt(i);
            if (c != '0') {
                dp[i + 1] = dp[i];
            }

            // two digits
            if (i != 0) {
                int two = Integer.parseInt(s.substring(i - 1, i + 1));
                if (two >= 10 && two <= 26) {
                    dp[i + 1] += dp[i - 1];
                }
            }
        }

        return dp[s.length()];
    }

    // Recursive method: TLE, T:O(2^n), S:O(h)
    int count;
    public int numDecodings1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        count = 0;
        dfs(s, 0);

        return count;
    }

    public void dfs(String s, int index) {
        if (index >= s.length()) {
            count++;
            return;
        }

        int n = Character.getNumericValue(s.charAt(index)) + 64;
        if (n < 65) return;

        // one digit
        dfs(s, index + 1);
        if (index + 1 < s.length() && Integer.parseInt(s.substring(index, index + 2)) < 27) {
            // two digits
            dfs(s, index + 2);
        }
    }
}
