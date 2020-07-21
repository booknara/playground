package com.booknara.problem.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 325. Maximum Size Subarray Sum Equals k (Medium)
 * https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
 */
public class MaximumSizeSubarraySumEqualsK {
    // T:O(n), S:O(n)
    public int maxSubArrayLen(int[] nums, int k) {
        // input check
        if (nums == null || nums.length == 0) return 0;

        // Key: sum, Value: index
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                max = i + 1;
            } else if (map.containsKey(sum - k)) {
                max = Math.max(max, i - map.get(sum - k));
            }

            map.putIfAbsent(sum, i);
        }

        return max;
    }
}
