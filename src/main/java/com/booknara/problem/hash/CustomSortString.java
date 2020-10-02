package com.booknara.problem.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 791. Custom Sort String (Medium)
 * https://leetcode.com/problems/custom-sort-string/
 */
public class CustomSortString {
    // T:O(n, the length of T), S:O(n)
    public String customSortString(String S, String T) {
        // input check
        if (S == null || S.length() == 0) return T;

        // 1. Create and fill Set from S
        Set<Character> set = new HashSet<>();
        for (char c: S.toCharArray()) {
            set.add(c);
        }
        // 2. find any characters from T which is not present in S
        // 3. count each chacacter for T using bucket
        StringBuilder res = new StringBuilder();
        int[] bucket = new int[26];
        for (char c: T.toCharArray()) {
            if (set.contains(c)) {
                bucket[c - 'a']++;
            } else {
                res.append(c);
            }
        }

        // 4. Iterate S characters and print characters based on bucket count
        for (char c: S.toCharArray()) {
            int freq = bucket[c - 'a'];
            for (int i = 0; i < freq; i++) {
                res.append(c);
            }
        }

        return res.toString();
    }
}
