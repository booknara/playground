package com.booknara.problem.backtracking;

/**
 * 416. Partition Equal Subset Sum (Medium)
 * https://leetcode.com/problems/partition-equal-subset-sum/
 */
public class PartitionEqualSubsetSum {
    // T:O(n*m), S:O(n)
    public boolean canPartition(int[] nums) {
        // input check (non-empty from problem statement)
        int sum = 0;
        for (int n: nums) {
            sum += n;
        }

        // sum is odd number which can't be divided by 2
        if (sum % 2 != 0) return false;

        sum /= 2;

        boolean[] dp = new boolean[sum + 1];
        for (int i = 1; i < sum + 1; i++) {
            dp[i] = false;
        }
        dp[0] = true;

        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j >= nums[i - 1]) {         // possible and picked, otherwise use remaining value
                    dp[j] = dp[j] || dp[j - nums[i - 1]];
                }
            }
        }

        return dp[sum];
    }

    // T:O(2^n), S:O(2^n)
    public boolean canPartition1(int[] nums) {
        // input check (non-empty from problem statement)
        int sum = 0;
        for (int n: nums) {
            sum += n;
        }

        // sum is odd number which can't be divided by 2
        if (sum % 2 != 0) return false;

        sum /= 2;

        return backtracking(nums, 0, sum);
    }

    // backtracking
    private boolean backtracking(int[] nums, int index, int target) {
        if (target == 0) return true;
        if (index == nums.length || target < 0) return false;

        // used
        if (backtracking(nums, index + 1, target - nums[index])) {
            return true;
        }

        int j = index + 1;
        while (j < nums.length && nums[index] == nums[j]) {
            j++;
        }
        // recovery
        return backtracking(nums, j, target);
    }

    // T:O(n*m), S:O(n*m)
    public boolean canPartition2(int[] nums) {
        // input check (non-empty from problem statement)
        int sum = 0;
        for (int n: nums) {
            sum += n;
        }

        // sum is odd number which can't be divided by 2
        if (sum % 2 != 0) return false;

        sum /= 2;

        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for (int i = 1; i < nums.length + 1; i++) {
            dp[i][0] = true;
        }
        // no needed
        // for (int j = 1; j < sum + 1; j++) {
        //     dp[0][j] = false;
        // }
        dp[0][0] = true;

        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                dp[i][j] = dp[i - 1][j];    // not picked
                if (j >= nums[i - 1]) {         // possible and picked
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[nums.length][sum];
    }

}
