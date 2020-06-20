package com.booknara.problem.dp;

/**
 * 91. Decode Ways (Medium)
 * https://leetcode.com/problems/decode-ways/
 */
public class DecodeWays {
    // DP solution, T:O(n), S:O(n)
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // dp array size : s.length() + 2 because of two init values dp[0] = 0, dp[1] = 1
        int[] dp = new int[s.length() + 2];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 0; i < s.length(); i++) {
            // one digit (1 ~ 9), skip 0
            if (s.charAt(i) != '0') {
                dp[i + 2] = dp[i + 1];
            }

            // not allow to make two digits because of substring function
            if (i - 1 < 0) {
                continue;
            }
            // two digits (10 ~ 26)
            int d = Integer.parseInt(s.substring(i - 1, i + 1));
            if (d >= 10 && d <= 26) {
                dp[i + 2] += dp[i];
            }
        }

        return dp[s.length() + 1];
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
