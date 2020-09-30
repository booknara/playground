package com.booknara.problem.dp;

/**
 * 238. Product of Array Except Self (Medium)
 *  https://leetcode.com/problems/product-of-array-except-self/
 */
public class ProductArrayExceptSelf {
    // T: O(n), S: O(1)
    public int[] productExceptSelf(int[] nums) {
        // input check, n > 1
        int[] left = new int[nums.length];
        left[0] = 1;
        int right = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            right = right * nums[i + 1];
            left[i] = left[i] * right;
        }

        return left;
    }

    // T: O(n), S: O(1)
    public int[] productExceptSelf1(int[] nums) {
        // input check
        if (nums == null) return new int[0];
        if (nums.length <= 1) return nums;

        int n = nums.length;
        int[] left = new int[n];
        int product = 1;
        for (int i = 0; i < n; i++) {
            product *= nums[i];
            left[i] = product;
        }

        product = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                left[i] = left[i - 1];
            } else if (i == 0) {
                left[i] = product;
            } else {
                left[i] = left[i - 1] * product;
            }

            product *= nums[i];

        }

        return left;
    }

    // T: O(n), S: O(n)
    public int[] productExceptSelf2(int[] nums) {
        // input check
        if (nums == null) return new int[0];
        if (nums.length <= 1) return nums;

        int n = nums.length;
        int product = 1;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            product *= nums[i];
            left[i] = product;
        }

        product = 1;
        int[] right = new int[n];
        for (int i = nums.length - 1; i >= 0; i--) {
            product *= nums[i];
            right[i] = product;
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                res[i] = right[i + 1];
            } else if (i == n - 1) {
                res[i] = left[i - 1];
            } else {
                res[i] = left[i - 1] * right[i + 1];
            }
        }

        return res;
    }
}
/**
 /**
 Input:  [1,2,3, 4]
 left    [ 1, 2, 6,24]
 right   [24,24,12, 4]

 Output: [24,12,8,6]
 */