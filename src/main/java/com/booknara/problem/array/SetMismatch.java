package com.booknara.problem.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 645. Set Mismatch (Easy)
 * https://leetcode.com/problems/set-mismatch/
 */
public class SetMismatch {
    // T: O(n), S: O(1)
    public int[] findErrorNums(int[] nums) {
        // input check
        if (nums == null || nums.length == 0) {
            return new int[] {};
        }

        int duplicate = -1;
        for (int n: nums) {
            // n can be negative or positive
            int abs = Math.abs(n);
            if (nums[abs - 1] < 0) {
                // already negative -> duplicated
                duplicate = abs;
            } else {
                nums[abs - 1] *= -1;
            }
        }

        int missing = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
            }
        }

        return new int[] {duplicate, missing};
    }

    // T: O(n), S: O(n)
    public int[] findErrorNums1(int[] nums) {
        // input check
        if (nums == null || nums.length == 0) {
            return new int[] {};
        }

        int duplicate = 0;
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for (int n: nums) {
            if (set.contains(n)) {
                duplicate = n;
            }
            set.add(n);
            sum += n;
        }

        int missing = (nums.length * (nums.length + 1) / 2) - sum + duplicate;

        return new int[] {duplicate, missing};
    }
}
