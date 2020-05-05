package com.booknara.problem.array;

/**
 * 387. First Unique Character in a String (Easy)
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqueCharacterInString {
    // T:O(n, the length of string), S:O(1)
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        int[] bucket = new int[26];
        for (char c: s.toCharArray()) {
            bucket[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (bucket[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
