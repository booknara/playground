package com.booknara.problem.hash;

/**
 * 75. Sort Colors (Medium)
 * https://leetcode.com/problems/sort-colors/
 */
public class SortColors {
    // T:O(n), S:O(1)
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int[] bucket = new int[3];
        for (int n: nums) {
            bucket[n]++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (bucket[0] != 0) {
                nums[i] = 0;
                bucket[0]--;
            } else if (bucket[1] != 0) {
                nums[i] = 1;
                bucket[1]--;
            } else {
                nums[i] = 2;
                bucket[2]--;
            }
        }
    }
}
