package com.booknara.problem.bit;

import java.util.HashMap;
import java.util.Map;

/**
 * 137. Single Number II (Medium)
 * https://leetcode.com/problems/single-number-ii/
 */
public class SingleNumberII {
    // Using bit operator
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int res = 0;
        // 32 bit integer
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += nums[j] >> i & 1;
            }

            res |= (sum % 3) << i;
        }

        return res;
    }

    // With Space(dictionary)
    public int singleNumber1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums) {
            int count = map.getOrDefault(n, 0);
            map.put(n, count + 1);
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == 1) {
                res = entry.getKey();
                break;
            }
        }

        return res;
    }
}
