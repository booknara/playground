package com.booknara.problem.array;

/**
 * 26. Remove Duplicates from Sorted Array (Easy)
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {
    // T:O(n), S:O(1)
    public int removeDuplicates(int[] nums) {
        // input check
        if (nums == null) return 0;
        if (nums.length <= 1) return nums.length;

        int l = 1, r = 1;
        while (r < nums.length) {
            if (nums[r] != nums[r - 1]) {
                nums[l] = nums[r];
                l++;
            }
            r++;
        }

        // return the new length
        return l;
    }
}
/**
 Given nums = [0,0,1,1,1,2,2,3,3,4]
 Method Two pointers
 l = 1, r = 1

 [0,0,1,1,1,2,2,3,3,4]
 [0,1,2,3,4]

 */