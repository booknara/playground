package com.booknara.problem.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. Word Pattern (Easy)
 * https://leetcode.com/problems/word-pattern/
 */
public class WordPattern {
    // T:O(n), S:O(n)
    public boolean wordPattern(String pattern, String str) {
        // input check
        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            // diffent size
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(words[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(words[i])) return false;

                map.put(pattern.charAt(i), words[i]);
            }
        }

        return true;
    }

    public boolean wordPattern1(String pattern, String str) {
        // input check
        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            // diffent size
            return false;
        }

        Map<Character, Integer> characterMap = new HashMap<>();
        Map<String, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (characterMap.containsKey(pattern.charAt(i)) && wordMap.containsKey(words[i])) {
                char c = pattern.charAt(i);
                String s = words[i];

                if (!characterMap.get(c).equals(wordMap.get(s))) {
                    return false;
                }
            } else if (characterMap.containsKey(pattern.charAt(i))|| wordMap.containsKey(words[i])) {
                return false;
            } else {
                characterMap.put(pattern.charAt(i), i);
                wordMap.put(words[i], i);
            }
        }

        return true;
    }
}
