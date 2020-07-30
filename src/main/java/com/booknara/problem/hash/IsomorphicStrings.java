package com.booknara.problem.hash;

/**
 * 205. Isomorphic Strings (Easy)
 * https://leetcode.com/problems/isomorphic-strings/
 */
public class IsomorphicStrings {
    // T:O(n), S:O(1)
    public boolean isIsomorphic(String s, String t) {
        // input check, s and t have the same length
        if (s.length() == 0 || t.length() == 0) return true;

        int[] bucket1 = new int[256];
        int[] bucket2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (bucket1[s.charAt(i)] != bucket2[t.charAt(i)]) {
                return false;
            }
            bucket1[s.charAt(i)] = i + 1;
            bucket2[t.charAt(i)] = i + 1;
        }

        return true;
    }
}
