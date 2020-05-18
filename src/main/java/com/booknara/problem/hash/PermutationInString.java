package com.booknara.problem.hash;

import java.util.Arrays;

/**
 * 567. Permutation in String (Medium)
 * https://leetcode.com/problems/permutation-in-string/
 */
public class PermutationInString {
    // T:O(n), S:O(1)
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.length() == 0) return true;
        if (s2 == null || s2.length() == 0) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for (char c: s1.toCharArray()) {
            s1Count[c - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            s2Count[c - 'a']++;

            int r = i - s1.length();
            if (r >= 0) {
                s2Count[s2.charAt(r) - 'a']--;
            }

            if (Arrays.equals(s1Count, s2Count)) {
                return true;
            }
        }

        return false;
    }
}
