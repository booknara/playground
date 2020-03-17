package com.booknara.problem.array;

import java.util.Arrays;

/**
 * 561. Array Partition I (Easy)
 * https://leetcode.com/problems/array-partition-i/
 */
public class ArrayPartition {
    // Simplify version without micro-optimization
    public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i += 2) {
            sum += nums[i];
        }

        return sum;
    }

    // Using Two-pointers
    public int arrayPairSum1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 2) {
            return Math.min(nums[0], nums[1]);
        }

        Arrays.sort(nums);
        int s = 0, e = nums.length - 1;
        int sum = 0;
        while (s < e) {
            sum += nums[s];
            sum += nums[e - 1];
            s += 2;
            e -= 2;
            if (s + 1 == e) {
                sum += nums[s];
                break;
            }
        }

        return sum;
    }
}
