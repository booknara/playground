package com.booknara.problem.dp;

/**
 * 161. One Edit Distance (Medium)
 * https://leetcode.com/problems/one-edit-distance/
 */
public class OneEditDistance {
    // T:O(n), S:O(1)
    public boolean isOneEditDistance(String s, String t) {
        if (s.equals(t)) return false;

        int sLen = s.length();
        int tLen = t.length();

        if (Math.abs(sLen - tLen) > 1) return false;

        boolean foundDiff = false;
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) != t.charAt(j)) {
                if (foundDiff) return false;
                foundDiff = true;
                if (sLen > tLen) {
                    i++;
                } else if (sLen < tLen) {
                    j++;
                } else {
                    i++;
                    j++;
                }
            } else {
                i++;
                j++;
            }
        }

        return true;
    }

    public boolean isOneEditDistance1(String s, String t) {
        if (s.length() == 0 && t.length() == 0) return false;

        if (Math.abs(s.length() - t.length()) > 1) return false;

        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        // init setting (col)
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        // init setting (row)
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = getMin(dp[i][j], dp[i][j + 1], dp[i + 1][j]) + 1;
                }
            }
        }

        // only one edit can be true
        return dp[m][n] == 1;
    }

    public int getMin(int i, int j, int k) {
        return Math.min(i, Math.min(j, k));
    }
    /**
     Input: s = "ab", t = "acb"
     T  a  a  a
     0  1  2  3
     a  1  0  1  2
     a  2  1  1  1
     */
    // T:O(n), S:O(1)
    public boolean isOneEditDistance2(String s, String t) {
        if (s.equals(t)) return false;

        int sLen = s.length();
        int tLen = t.length();
        if (sLen == tLen) {
            if (sLen == 1) return true;
            // replace
            return replace(s, t);
        }

        if (sLen + 1 == tLen) {
            if (sLen == 0) return true;
            // insert
            return insert(s, t);
        }

        if (sLen - 1 == tLen) {
            if (sLen == 1) return true;
            // delete
            return delete(s, t);
        }

        return false;
    }

    public boolean replace(String s, String t) {
        boolean used = false;
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) != t.charAt(j)) {
                if (used) {
                    return false;
                }
                used = true;
            }
            i++;
            j++;
        }

        return true;
    }

    public boolean insert(String s, String t) {
        boolean used = false;
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) != t.charAt(j)) {
                if (used) {
                    return false;
                }
                used = true;
                j++;
            } else {
                i++;
                j++;
            }
        }

        return true;
    }

    public boolean delete(String s, String t) {
        boolean used = false;
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) != t.charAt(j)) {
                if (used) {
                    return false;
                }
                used = true;
                i++;
            } else {
                i++;
                j++;
            }
        }

        return true;
    }
}
