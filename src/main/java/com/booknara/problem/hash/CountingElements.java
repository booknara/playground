package com.booknara.problem.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 10003. Counting Elements (Easy)
 * https://leetcode.com/problems/counting-elements/
 */
public class CountingElements {
    // Time, Space: O(n)
    public int countElements(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int x: arr) {
            if (map.containsKey(x)) {
                map.put(x,map.get(x)+1);
            } else {
                map.put(x,1);
            }
        }

        int res = 0;
        for (int key: map.keySet()) {
            if (map.containsKey(key + 1)) {
                res += map.get(key);
            }
        }

        return res;
    }
}
