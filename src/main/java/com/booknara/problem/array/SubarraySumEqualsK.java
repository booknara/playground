package com.booknara.problem.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. Subarray Sum Equals K (Medium)
 * https://leetcode.com/problems/subarray-sum-equals-k/
 */
public class SubarraySumEqualsK {
    // T:O(n), S:O(n)
    public int subarraySum(int[] nums, int k) {
        // input check, nums = non-empty array
        int n = nums.length;
        // Key: Sum, Value: the count of sum
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, res = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];

            // check sum - k
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }

            // update the map
            int count = map.getOrDefault(sum, 0);
            map.put(sum, count + 1);
        }

        return res;
    }
}
/**
 Input:nums =
 [1,1,1], k = 2
 [0,1,2,3]

 [
 0:1
 1:1 -> sum = 1,
 2:1 -> sum = 2, 2 - k(2) = 0, res = 1
 3:1 -> sum = 3, 3 - k(2) = 1, res = 2
 ]

 [0,0], k = 0
 [
 0:2 // init
 sum = 0 res = 1
 sum = 0 res = 1 + 2 = 3
 ]

 Output: 2
 */