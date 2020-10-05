package com.booknara.problem.search.binary;

/**
 * 154. Find Minimum in Rotated Sorted Array II (Hard)
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimumInRotatedSortedArrayII {
    // T:O(n), S:O(1)
    public int findMin(int[] nums) {
        // input check
        if (nums == null || nums.length == 0) return 0;

        if (nums[0] < nums[nums.length - 1]) return nums[0];

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < nums[r]) {
                r = m;
            } else if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                // nums[m] == nums[r]
                r--;
            }
        }

        return nums[l];
    }

    // T:O(n), S:O(1)
    public int findMin1(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;

            if (nums[l] < nums[r]) return nums[l];

            if (nums[l] < nums[m]) {
                l = m + 1;
            } else if (nums[l] > nums[m]) {
                r = m;
            } else {
                l++;
            }
        }

        return nums[l];
    }

    // T:O(logn), S:O(1)
    public int findMin2(int[] nums) {
        // input check
        if (nums == null || nums.length == 0) return 0;

        if (nums[0] < nums[nums.length - 1]) return nums[0];

        int r = nums.length - 1;
        // e.g. [10,1,10,10,10] to remove all the same edge value
        while (r > 0 && nums[0] == nums[r]) {
            r--;
        }

        int l = 0;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return nums[l];
    }
}
