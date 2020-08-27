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

    // Time complexity: O(n), Space complexity: O(1)
    public int[] productExceptSelf1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                res[i] = nums[i];
            } else {
                res[i] = res[i - 1] * nums[i];
            }
            //System.out.print(res[i] + ",");
        }

        //System.out.println();
        int product = 1;
        for (int i = res.length - 1; i >= 0; i--) {
            if (i == 0) {
                res[i] = product;
            } else {
                res[i] = res[i - 1] * product;
            }
            product *= nums[i];
            //System.out.print(res[i] + ",");
        }

        return res;
    }

    // Time complexity: O(n), Space complexity: O(n)
    public int[] productExceptSelf2(int[] nums) {
        // input check, n > 1
        int[] left = new int[nums.length];
        left[0] = 1;
        int[] right = new int[nums.length];
        right[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            left[i] = left[i] * right[i];
        }

        return left;
    }
}
/**
 Given an array nums of n integers where n > 1,
 return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 Input:  [ 1, 2,3,4]
 Output: [24,12,8,6]

 left:   [ 1, 1,2,6]
 right:  [24,12,4,1]
 Output: [24,12,8,6] left[i] * right[i]
 */