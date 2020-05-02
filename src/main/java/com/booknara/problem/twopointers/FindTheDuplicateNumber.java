package com.booknara.problem.twopointers;

/**
 * 287. Find the Duplicate Number (Medium)
 * https://leetcode.com/problems/find-the-duplicate-number/
 */
public class FindTheDuplicateNumber {
    // T: O(n), S:O(1)
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int slow = 0, fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }

        fast = 0;
        while (nums[slow] != nums[fast]) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return nums[slow];
    }
}
