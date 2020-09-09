package com.booknara.problem.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 266. Palindrome Permutation (Easy)
 * https://leetcode.com/problems/palindrome-permutation/
 */
public class PalindromePermutation {
    // T:O(n), S:O(n)
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
}
/**
 "rer"
 [
 a:2,
 c:2,
 e:1,
 r:2
 ]
 */