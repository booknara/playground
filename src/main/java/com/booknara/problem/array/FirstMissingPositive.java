package com.booknara.problem.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 41. First Missing Positive (Hard)
 * https://leetcode.com/problems/first-missing-positive/
 */
public class FirstMissingPositive {
    // T:O(N), S:O(1)
    public int firstMissingPositive(int[] nums) {
        // input check
        if (nums == null || nums.length == 0) return 1;

        // find 1
        boolean oneExist = false;
        for (int n: nums) {
            if (n == 1) {
                oneExist = true;
                break;
            }
        }
        if (!oneExist) return 1;

        // preprocessing for negative and zero, out of range
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }

        // Now, all the values are positive, then assing value to index to negative
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (index < nums.length) {
                // negative value indicates the index is not the answer
                nums[index] = -1 * Math.abs(nums[index]);
            } else {
                // out of range index
                nums[0] = -1 * Math.abs(nums[0]);
            }
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }

        // edge case. e.g. [0,1,2] -> [1,1,2] -> [1,-1,-2] -> 3
        if (nums[0] > 0) return nums.length;
        return nums.length + 1;
    }

    // Time: O(N), N: the length of input array, Space: O(1)
    public int firstMissingPositive1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] < 1) {
                nums[j] = Math.abs(nums[j]) + nums.length + 1;
            }
        }
        int i = 0;
        while (i < nums.length) {
            if (i == nums[i] - 1
                    || (i != 0 && nums[i] == nums[i - 1])) {
                i++;
            } else if (nums[i] >= 1
                    && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }

        int ans = nums[nums.length - 1] + 1;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != k + 1) {
                ans = k + 1;
                break;
            }
        }

        return ans;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // T:O(n), S:O(n)
    public int firstMissingPositive2(int[] nums) {
        // input check
        if (nums == null || nums.length == 0) return 1;

        Set<Integer> set = new HashSet<>();
        for (int n: nums) {
            set.add(n);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return nums.length + 1;
    }
}
