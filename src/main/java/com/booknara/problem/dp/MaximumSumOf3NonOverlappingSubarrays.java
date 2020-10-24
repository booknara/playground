package com.booknara.problem.dp;

import java.util.Arrays;

/**
 * 689. Maximum Sum of 3 Non-Overlapping Subarrays (Hard)
 * https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/
 */
public class MaximumSumOf3NonOverlappingSubarrays {
    // T:O(n), S:O(n)
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        // input check
        if (k == 0) throw new IllegalArgumentException("k == 0");

        if (nums == null || nums.length == 0) return new int[0];

        int m = nums.length;
        int n = m - k + 1;
        int[] dp = new int[n];
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += nums[i];
            if (i - k >= 0) {
                sum -= nums[i - k];
            }

            if (i - k + 1 >= 0) {
                dp[i - k + 1] = sum;
            }
        }

        // store index value for max value
        int[] left = new int[n];
        int maxIdx = 0;
        for (int i = 0; i < left.length; i++) {
            // only greater than
            if (dp[i] > dp[maxIdx]) {
                maxIdx = i;
            }
            left[i] = maxIdx;
        }

        int[] right = new int[n];
        maxIdx = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            // equal or greater because of return the lexicographically smallest one.
            if (dp[i] >= dp[maxIdx]) {
                maxIdx = i;
            }
            right[i] = maxIdx;
        }

        int[] res = new int[3];
        Arrays.fill(res, -1);
        for (int i = k; i < n - k; i++) {
            if (res[0] == -1
                    || dp[res[0]] + dp[res[1]] + dp[res[2]] < dp[left[i - k]] + dp[i] + dp[right[i + k]]) {
                res[0] = left[i - k];
                res[1] = i;
                res[2] = right[i + k];
            }
        }

        return res;
    }
}
/**
 Input: [1,2,1,2,6,7,5,1], 2
 Output: [0,3,5]

 int m = nums.length;
 int[] dp = new int[m - k + 1];  // 8 - 2 + 1 = 7
   [1,2,1,2,6, 7, 5,1], 2
     [3,3,3,8,13,12,6] // sum of k length slice
 l = [0,0,0,3, 4, 4,4]
 r = [4,4,4,4, 4, 5,6]
 */
