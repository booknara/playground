package com.booknara.problem.string;

/**
 * 14. Longest Common Prefix (Easy)
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {
    // T:O(n*m), S:O(1)
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i > strs[j].length() - 1 || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }
}
