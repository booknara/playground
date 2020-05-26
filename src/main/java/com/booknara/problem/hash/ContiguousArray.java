package com.booknara.problem.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. Contiguous Array (Medium)
 * https://leetcode.com/problems/contiguous-array/
 */
public class ContiguousArray {
    // T:O(n), S:O(n)
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == 0 ? -1 : 1;

            // count is the same of the count when starting
            if (count == 0) {
                maxLen = Math.max(maxLen, i + 1);
                continue;
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
