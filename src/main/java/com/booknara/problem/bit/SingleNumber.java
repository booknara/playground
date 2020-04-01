package com.booknara.problem.bit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 136. Single Number (Easy)
 * https://leetcode.com/problems/single-number/
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        for (int n : nums) {
            res ^= n;
            //System.out.println(res);
            //System.out.println(Integer.toBinaryString(res));
        }

        return res;
    }

    // Sort O(nlogn) without space
    public int singleNumberwithSort(int[] nums) {
        // Input check(Assume non-empty array of integers based on problem statement)
        Integer res = null;
        Arrays.sort(nums);
        for (int i = 0; i + 1 < nums.length; i += 2) {
            int n1 = nums[i];
            int n2 = nums[i + 1];
            if (n1 != n2) {
                res = n1;
                break;
            }
        }

        return res == null ? nums[nums.length - 1] : res;
    }

    // Sort O(n) with space (dictionary)
    public int singleNumberUsingHash(int[] nums) {
        // Input check(Assume non-empty array of integers based on problem statement)
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
