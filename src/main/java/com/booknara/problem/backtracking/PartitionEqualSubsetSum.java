package com.booknara.problem.backtracking;

/**
 * 416. Partition Equal Subset Sum (Medium)
 * https://leetcode.com/problems/partition-equal-subset-sum/
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        // TODO DP solution
        return false;
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
}
