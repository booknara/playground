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
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                int idx = map.get(sum - k);
                max = Math.max(max, i - idx);
            }

            map.putIfAbsent(sum, i);
        }

        return max;
    }
}
/**
 Input: nums = [1, -1, 5, -2, 3], k = 3
 Output: 4
 Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
 Input: [1,-1,5,-2,3], k = 3
 prefix [1, 0,5, 3,6]
 [0,-1]
 [-2, 0]
 [-3, 1]
 [-1, 2]
 [0, 3]

 [-2, -1, 2, 1], k = 1
 [0,-1]
 [-2, 0]
 [-3, 1]
 [-1, 2]
 [0, 3]
 */