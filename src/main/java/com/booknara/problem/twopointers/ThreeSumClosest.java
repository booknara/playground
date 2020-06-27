package com.booknara.problem.twopointers;

import java.util.Arrays;

/**
 * 16. 3Sum Closest (Medium)
 * https://leetcode.com/problems/3sum-closest/
 */
public class ThreeSumClosest {
    // input : integer array, integer target
    // output : the sum of the three integers which is the closest to target
    public int threeSumClosest(int[] nums, int target) {
        // input check, nums.length >= 3
        Arrays.sort(nums);  // sort ascending

        int sum = 3 * 10 * 10 * 10; // max number of array element 10^3 * 3(numbers)
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;  // no need to check i or less than i
            int r = nums.length - 1;
            int tempSum = 0;
            while (l < r) {
                tempSum = nums[i] + nums[l] + nums[r];
                if (tempSum == target) return target;

                // check existing sum and current best sum
                if (Math.abs(sum - target) > Math.abs(tempSum - target)) {
                    sum = tempSum;
                }

                if (nums[l] + nums[r] + nums[i] - target < 0) {
                    // increase
                    l++;
                    if (l == i) l++;
                } else {
                    // decrease
                    r--;
                    if (r == i) r--;
                }
            }
        }

        return sum;
    }

    public int threeSumClosest1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int ans = 0;
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
