package com.booknara.problem.dp;

/**
 * Leet code : 198 (Easy)
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 *
 * Formula : sum[i] = max(sum[i - 1], sum[i - 2] + nums[i])
 */
public class HouseRobber {
    // Time complexity: O(n), Space complexity: O(n)
    public int rob1(int[] nums) {
        // error handling
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        sum[1] = Math.max(nums[0], nums[1]);
        int max = 0;
        for (int i = 2; i < nums.length; i++) {
            sum[i] = Math.max(sum[i - 1], sum[i - 2] + nums[i]);
            max = Math.max(sum[i], max);
        }

        return max;
    }

    // Time complexity: O(n), Space complexity: O(1)
    public int rob2(int[] nums) {
        // error handling
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int prev2 = nums[0];
        int prev = Math.max(nums[0], nums[1]);
        int max = 0;
        for (int i = 2; i < nums.length; i++) {
            int curMax = Math.max(prev, prev2 + nums[i]);
            max = Math.max(curMax, max);
            prev2 = prev;
            prev = curMax;
        }

        return max;
    }
}
