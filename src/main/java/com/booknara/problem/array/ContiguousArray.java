package com.booknara.problem.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. Contiguous Array (Medium)
 * https://leetcode.com/problems/contiguous-array/
 */
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        // For edge case: (0, 1), it doesn't get maxLen because '0' or '1' appears once.
        map.put(0, -1);
        int maxLen = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count--;
            } else {
                count++;
            }

            if (map.containsKey(count)) {
                maxLen = Math.max(maxLen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }

        return maxLen;
    }
}
