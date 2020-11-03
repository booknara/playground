package com.booknara.problem.twopointers;

/**
 * 1446. Consecutive Characters (Easy)
 * https://leetcode.com/problems/consecutive-characters/
 */
public class ConsecutiveCharacters {
    // T:O(n), S:O(1)
    public int maxPower(String s) {
        // input check
        int l = 0, r = 1;
        int max = 1;
        while (r < s.length()) {
            char prev = s.charAt(l);
            char c = s.charAt(r);
            if (prev == c) {
                r++;
                continue;
            }

            max = Math.max(max, r - l);
            l = r;
            r++;
        }

        // the last item handling
        max = Math.max(max, r - l);

        return max;
    }
}
