package com.booknara.problem.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    // Sort
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int count = 1;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // System.out.println(nums[i]);
            if (count == 1 && nums[i] == prev) {
                // reset
                count = 2;
                prev = nums[i];
            } else if (count == 2) {
                // first appearance
                count = 1;
                prev = nums[i];
            } else {
                return prev;
            }
        }

        return prev;
    }

    public int singleNumberUsingHash(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0);
            if (count == 0) {
                map.put(nums[i], 1);
            } else {
                map.remove(nums[i]);
            }
        }

        if (map.size() == 1) {
            for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                return entry.getKey();
            }
        }

        return -1;
    }
}
