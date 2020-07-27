package com.booknara.problem.twopointers;

/**
 * 713. Subarray Product Less Than K (Medium)
 * https://leetcode.com/problems/subarray-product-less-than-k/
 */
public class SubarrayProductLessThanK {
    // T:O(n), S:O(1)
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // input check, the length of nums is larger than 0
        if (k <= 1) return 0;

        int res = 0;
        int prod = 1;
        int l = 0, r = 0;
        while (r < nums.length) {
            prod *= nums[r];
            while (prod >= k) {
                prod /= nums[l];
                l++;
            }

            // Note: TLE without it
            res += r - l + 1;
            r++;
        }

        return res;
    }

    // TLE
    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        // input check, the length of nums is larger than 0
        int res = 0;
        int prod = 1;
        int l = 0, r = 0;
        while (l < nums.length) {
            prod *= nums[r];
            if (prod < k) {
                res++;
                r++;
            } else {
                l++;
                r = l;
                prod = 1;
            }

            // r reaches out of range
            if (r == nums.length) {
                l++;
                r = l;
                prod = 1;
            }
        }

        return res;
    }
}
