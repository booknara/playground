package com.booknara.problem.tree.bst;

/**
 * 34. Find First and Last Position of Element in Sorted Array (Medium)
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    // T:O(logn), S:O(1)
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        if (nums[r] != target) {
            return new int[] {-1, -1};
        }

        // System.out.println(l);
        // System.out.println(r);
        int start = l;
        int end = l + 1;
        while (end < nums.length) {
            if (nums[end] != target) {
                break;
            }
            end++;
        }

        return new int[] {start, end - 1};
    }
}
