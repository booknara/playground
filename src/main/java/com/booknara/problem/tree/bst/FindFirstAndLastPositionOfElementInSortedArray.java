package com.booknara.problem.tree.bst;

/**
 * 34. Find First and Last Position of Element in Sorted Array (Medium)
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    // T:O(logn), S:O(1)
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[] {-1, -1};
        if (nums == null || nums.length == 0) return res;

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        // Not exist
        if (nums[r] != target) return res;

        // r = the first position of element
        res[0] = r;
        res[1] = r;
        for (int i = r + 1; i < nums.length; i++) {
            if (nums[i] != target) {
                break;
            }
            res[1] = i;
        }

        return res;
    }
}
/**
 Input: nums = [5,7,7,8,8,10], target = 8
 Output: [3,4]

 [0,1,2,3,4, 5] , [0,5] m = 2, value = 7 l = m + 1
 [5,7,7,8,8,10]   [3,5] m = 4, value = 8 r = m;
 [3,4] m = 3, value = 8, r = m;
 */