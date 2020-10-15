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

    // T:(n^2), S:O(1)
    public int threeSumClosest1(int[] nums, int target) {
        // input check, the element of nums * 3 <= Integer.MAX_VALUE;
        if (nums == null || nums.length < 3) return 0;

        // ascending
        Arrays.sort(nums);
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            int pivot = nums[i];
            if (i - 1 >= 0 && nums[i - 1] == nums[i]) continue;

            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = pivot + nums[l] + nums[r];
                if (sum == target) return target;

                if (Math.abs(sum - target) < diff) {
                    diff = Math.abs(sum - target);
                    res = sum;
                }

                if (sum < target) {
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    // increment
                    l++;
                } else {
                    while (l < r && nums[r - 1] == nums[r]) r--;
                    // decrement
                    r--;
                }
            }
        }

        return res;
    }
}
/**
 Input: nums = [-1,2,1,-4], target = 1
 Two pointers
 [-4,-1,1,2]
 .
 -4 + -1 + 2 = -3 < target(1)
 -4 + 1 + 2 = -1 < target (1)

 -1 + 1 + 2 = 2 > target(2)

 Output: 2
 Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */