package com.booknara.problem.dp;

/**
 * 238. Product of Array Except Self (Medium)
 *  https://leetcode.com/problems/product-of-array-except-self/
 */
public class ProductArrayExceptSelf {
    // Time complexity: O(n), Space complexity: O(1)
    public int[] productExceptSelf(int[] nums) {
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
    public int[] productExceptSelf1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] left = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                left[i] = nums[i];
            } else {
                left[i] = left[i - 1] * nums[i];
            }
            //System.out.print(left[i] + ",");
        }

        System.out.println();
        int[] right = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                right[i] = nums[nums.length - 1];
            } else {
                right[i] = nums[i] * right[i + 1];
            }
            //System.out.print(right[i] + ",");
        }

        for (int i = 0; i < nums.length; i++) {
            int l = 1;
            if (i > 0) {
                l = left[i - 1];
            }
            int r = 1;
            if (i < nums.length - 1) {
                r = right[i + 1];
            }
            nums[i] = l * r;
        }

        return nums;
    }
}
