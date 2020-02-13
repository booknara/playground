package com.booknara.problem.hash;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> indexMap = new HashMap<>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (indexMap.containsKey(s.charAt(i))) {
                start = Math.max(start, indexMap.get(s.charAt(i)) + 1);
            }

            max = Math.max(max, i - start + 1);
            indexMap.put(s.charAt(i), i);
        }

        return max;
    }
}
