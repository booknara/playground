package com.booknara.problem.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 953. Verifying an Alien Dictionary (Easy)
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 */
public class VerifyingAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        if (words == null || words.length == 0) {
            return true;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for (int i = 1; i < words.length; i++) {
            // compare btw i - 1 and i
            String prev = words[i - 1];
            String cur = words[i];
            int minLen = Math.min(prev.length(), cur.length());
            boolean lexi = prev.length() < cur.length();
            for (int j = 0; j < minLen; j++) {
                if (map.get(prev.charAt(j)) < map.get(cur.charAt(j))) {
                    lexi = true;
                    break;
                }

                if (map.get(prev.charAt(j)) > map.get(cur.charAt(j))) {
                    lexi = false;
                    break;
                }
            }

            if (!lexi) {
                return false;
            }
        }

        return true;
    }
}
