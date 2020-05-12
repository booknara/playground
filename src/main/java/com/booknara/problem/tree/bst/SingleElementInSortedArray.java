package com.booknara.problem.tree.bst;

/**
 * 540. Single Element in a Sorted Array (Medium)
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 */
public class SingleElementInSortedArray {
    // T:O(log*n), S:O(1)
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            System.out.println(m);

            if (m % 2 == 0) {
                // even index
                if (nums[m] == nums[m + 1]) {
                    // {1,1,2,2,3}
                    l = m + 1;
                } else {
                    // {1,2,2,3,3}
                    r = m;
                }
            } else {
                // odd index
                if (nums[m] == nums[m - 1]) {
                    // {1,1,2}
                    l = m + 1;
                } else {
                    // {1,2,2}
                    r = m;
                }
            }
        }

        return nums[l];
    }
}
