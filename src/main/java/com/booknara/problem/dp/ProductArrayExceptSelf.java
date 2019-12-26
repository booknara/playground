package com.booknara.problem.dp;

/**
 * Given an array nums of n integers where n > 1,
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity?
 * (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductArrayExceptSelf {

    // Time complexity: O(n), Space complexity: O(n)
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }

        int[] left = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        int[] right = new int[nums.length];
        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            right[i] *= left[i];
        }

        return right;
    }

    // Time complexity: O(n), Space complexity: O(1)
    public int[] optimizedProductExceptSelf(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }

        int[] left = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        int r = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            r *= nums[i + 1];
            left[i] = left[i] * r;
        }

        return left;
    }
}
