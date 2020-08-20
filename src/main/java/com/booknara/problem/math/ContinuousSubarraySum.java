package com.booknara.problem.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 523. Continuous Subarray Sum (Medium)
 * https://leetcode.com/problems/continuous-subarray-sum/
 */
public class ContinuousSubarraySum {
    // T:O(n), S:O(n)
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                // except k = 0
                sum %= k;
            }

            if (map.containsKey(sum)) {
                // to check a continuous subarray of size at least 2
                if (i - map.get(sum) > 1) return true;
            } else {
                map.put(sum, i);
            }
        }

        return false;
    }
}

/**
 Given a list of non-negative numbers and a target integer k,
 write a function to check if the array has a continuous subarray of size at least 2 that sums up to a multiple of k, that is, sums up to n*k where n is also an integer.

 Input: 0 ~ N (integer)
 subarray (2 ~ N)
 [23, 2, 4, 6, 7],  k = 6

 n*k = 6, 6*2, 6*3...
 subarray sum % 6 == 0 -> true
 how to get subarray sum, n % k = (0 ~ k - 1)
 23 % k(6) = 5
 26 % k(6) = 2
 30 % k(6) = 0
 36 % k(6) = 0
 43 % k(6) = 1
 [0, -1] -> initial input
 [5, 0] -> check whether key 5 exists in the map (no)
 [2, 1] -> check whether key 2 exists in the map (no)
 [0, 2] -> check whether key 0 exists in the map (yes) and check the index difference is more than 1 (subarray at least 2 size)
 */
