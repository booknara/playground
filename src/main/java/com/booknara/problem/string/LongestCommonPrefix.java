package com.booknara.problem.string;

/**
 * 14. Longest Common Prefix (Easy)
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {
    // Vertical scanning
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

    // Horizontal scanning
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        int prefix = strs[0].length();

        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() == 0) return "";
            if (prefix == 0) return "";

            int j = 0;
            prefix = Math.min(prefix, strs[i].length());
            while (j < prefix) {
                if (strs[i - 1].charAt(j) != strs[i].charAt(j)) {
                    prefix = j;
                }
                j++;
            }
        }

        return strs[0].substring(0, prefix);
    }
}
