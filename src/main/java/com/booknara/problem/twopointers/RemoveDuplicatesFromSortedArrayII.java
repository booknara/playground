package com.booknara.problem.twopointers;

/**
 * 80. Remove Duplicates from Sorted Array II (Medium)
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class RemoveDuplicatesFromSortedArrayII {
    // T:O(n), S:O(1)
    public int removeDuplicates(int[] nums) {
        // input check
        if (nums == null) return 0;
        if (nums.length <= 2) return nums.length;

        int l = 1, r = 1;
        int count = 0;
        while (r < nums.length) {
            if (nums[r] != nums[r - 1]) {
                nums[l] = nums[r];
                r++;
                l++;
                count = 0;
                continue;
            }

            if (count >= 1) {
                // skip
                r++;
                count++;
            } else {
                nums[l] = nums[r];
                r++;
                l++;
                count++;
            }
        }

        return l;
    }
}
