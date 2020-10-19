package com.booknara.problem.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 266. Palindrome Permutation (Easy)
 * https://leetcode.com/problems/palindrome-permutation/
 */
public class PalindromePermutation {
    // T:O(n), S:O(1)
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) return true;

        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }

        int oddCount = 0;
        for (int i: map.values()) {
            if (i % 2 == 1) oddCount++;
        }

        return oddCount <= 1;
    }

    // T:O(n), S:O(1)
    public boolean canPermutePalindrome1(String s) {
        if (s == null || s.length() == 0) return true;

        int[] bucket = new int[128];
        for (char c: s.toCharArray()) {
            bucket[c]++;
        }

        boolean oddFound = false;
        for (int i = 0; i < 128; i++) {
            if (bucket[i] % 2 == 1) {
                if (oddFound) return false;
                // odd count
                oddFound = true;
            }
        }

        return true;
    }
}
/**
 Input: "code"
 Output: false

 Input: "aab" -> "aba"
 Output: true

 Input: "carerac"
 Output: true

 acer
 2212

 bucket[i] -> even : good
 bucket[i] -> odd : only one time allowed
 */