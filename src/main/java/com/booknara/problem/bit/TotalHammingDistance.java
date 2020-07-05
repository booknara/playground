package com.booknara.problem.bit;

/**
 * 477. Total Hamming Distance (Medium)
 * https://leetcode.com/problems/total-hamming-distance/
 */
public class TotalHammingDistance {
    // T:O(n), S:O(1)
    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length == 1) return 0;

        int res = 0;
        // check the max bit of Integer(32 bit)
        for (int i = 0; i < 32; i++) {
            int ones = 0;
            for (int num: nums) {
                // move bit to right based on i times
                ones += (num >>> i) & 1;
            }

            // Key point (the number of one * the number of zero)
            res += ones * (nums.length - ones);
        }

        return res;
    }

    // TLE,  T:O(n^2*logM), M is the largest number among nums[i]
    public int totalHammingDistance1(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                res += getHammingDistance(nums[i], nums[j]);
            }
        }

        return res;
    }

    public int getHammingDistance(int num1, int num2) {
        int xor = num1 ^ num2;
        int res = 0;
        while (xor > 0) {
            res++;
            xor = xor & (xor - 1);
        }

        return res;
    }
}
