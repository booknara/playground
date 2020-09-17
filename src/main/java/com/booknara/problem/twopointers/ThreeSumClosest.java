package com.booknara.problem.twopointers;

import java.util.Arrays;

/**
 * 16. 3Sum Closest (Medium)
 * https://leetcode.com/problems/3sum-closest/
 */
public class ThreeSumClosest {
    // T:(n^2), S:O(1)
    public int threeSumClosest(int[] nums, int target) {
        // input check nums >= 3
        long sum = Integer.MAX_VALUE;
        Arrays.sort(nums);  // ascending order
        for (int i = 0; i < nums.length - 2; i++) {
            int pivot = nums[i];
            int l = i + 1, r = nums.length - 1;

            while (l < r) {
                int localSum = pivot + nums[l] + nums[r];
                if (localSum == target) return target;

                // check existing sum and current best sum
                if (Math.abs(localSum - target) < Math.abs(sum - target)) {
                    sum = localSum;
                }

                if (localSum < target) {
                    // increase
                    l++;
                } else {
                    // decrease
                    r--;
                }
            }
        }

        return (int) sum;
    }

    public int threeSumClosest1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int ans = 3 * 10 * 10 * 10; // max number of array element 10^3 * 3(numbers)
        int closest = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k]  == target) {
                    return target;
                }

                if (Math.abs(nums[i] + nums[j] + nums[k] - target) < closest) {
                    closest = Math.abs(nums[i] + nums[j] + nums[k] - target);
                    ans = nums[i] + nums[j] + nums[k];
                }

                if (nums[i] + nums[j] + nums[k] < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return ans;
    }
}
