package com.booknara.problem.search.binary;

/**
 * 162. Find Peak Element (Medium)
 * https://leetcode.com/problems/find-peak-element/
 */
public class FindPeakElement {
    // T:O(logn), S:O(1)
    public int findPeakElement(int[] nums) {
        // input check
        if (nums == null || nums.length == 0) return -1;

        int l = 0, r = nums.length - 1;
        while (l < r) {     // [0,1]
            int m = l + (r - l) / 2;    // m = 0

            if (m == 0) {
                if (nums[m] > nums[m + 1]) return m;
            } else if (m == nums.length - 1) {
                if (nums[m - 1] < nums[m]) return m;
            } else if (nums[m - 1] < nums[m] && nums[m] > nums[m + 1]) {
                return m;
            }

            // e.g. [1,2]
            if (nums[m] > nums[m + 1]) {
                // ascending
                r = m;
            } else {
                // desending
                l = m + 1;
            }
        }

        return r;
    }
}
/**
 Input: nums = [1,2,3,1]
 Output: 2

 [0,1,2,3]
 [1,2,3,1], [0,3], m = 1, [1,3], m = 2
 int m = l + (r - l) / 2;
*/