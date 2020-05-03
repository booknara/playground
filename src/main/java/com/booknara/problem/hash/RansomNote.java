package com.booknara.problem.hash;

/**
 * 383. Ransom Note (Easy)
 * https://leetcode.com/problems/ransom-note/
 */
public class RansomNote {
    // T: O(ransomNote.length() + magazine.length()), S:O(1)
    public boolean canConstruct(String ransomNote, String magazine) {
        // check input
        if (ransomNote == null || ransomNote.length() == 0) return true;
        if (magazine == null || magazine.length() == 0) return false;

        int[] bucket = new int[26]; // assume all the letter are lowercase
        for (char c: magazine.toCharArray()) {
            bucket[c - 'a']++;
        }

        for (char c: ransomNote.toCharArray()) {
            if (bucket[c - 'a'] == 0) {
                // Not exist or already consumed
                return false;
            }

            bucket[c - 'a']--;
        }

        return true;
    }
}
