package com.booknara.problem.string;

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

    // T:O(n), S:O(1)
    public boolean isOneEditDistance1(String s, String t) {
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
