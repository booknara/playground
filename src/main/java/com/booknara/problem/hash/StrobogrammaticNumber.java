package com.booknara.problem.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 246. Strobogrammatic Number (Easy)
 * https://leetcode.com/problems/strobogrammatic-number/
 */
public class StrobogrammaticNumber {
    // T:O(n), S:O(1)
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) return true;

        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');

        // only one character is also handled(e.g. 8=true, 2=false)
        int l = 0, r = num.length() - 1;
        while (l <= r) {
            // compare
            if (!map.containsKey(num.charAt(l))) {
                return false;
            }

            if (map.get(num.charAt(l)) != num.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}
/**
 6 -> 9
 9 -> 6
 8 -> 8
 1 -> 1
 0 -> 0

 "609"
 */