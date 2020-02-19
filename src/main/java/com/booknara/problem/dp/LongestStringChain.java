package com.booknara.problem.dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Leet code : 1048. Longest String Chain (Medium)
 * https://leetcode.com/problems/longest-string-chain/
 */
public class LongestStringChain {
    public int longestStrChain(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }

        Map<String, Integer> map = new HashMap<>();
        // Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());
        Arrays.sort(words, Comparator.comparingInt(String::length));

        for (String word: words) {
            //System.out.println(word);
            if (word.length() == 1) {
                map.put(word, 1);
                continue;
            }

            int max = 0;
            for (int i = 0; i < word.length(); i++) {
                StringBuilder builder = new StringBuilder(word).deleteCharAt(i);
                max = Math.max(max, map.getOrDefault(builder.toString(), 0) + 1);
            }

            map.put(word, max);
        }

        int totalMax = 0;
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            totalMax = Math.max(totalMax, entry.getValue());
        }

        return totalMax;
    }
}
