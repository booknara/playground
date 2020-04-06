package com.booknara.problem.hash;

/**
 * 567. Permutation in String (Medium)
 * https://leetcode.com/problems/permutation-in-string/
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.length() == 0) return true;
        if (s2 == null || s2.length() == 0) return false;

        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for (char c: s1.toCharArray()) {
            s1Count[c - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            s2Count[s2.charAt(i) - 'a']++;

            int r = i - s1.length();
            if (r >= 0) {
                s2Count[s2.charAt(r) - 'a']--;
            }

            boolean equal = true;
            for (int j = 0; j < 26; j++) {
                if (s1Count[j] != s2Count[j]) {
                    equal = false;
                    break;
                }
            }

            if (equal) return true;
        }

        return false;
    }
}
