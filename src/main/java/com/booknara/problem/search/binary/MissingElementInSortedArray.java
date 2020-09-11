package com.booknara.problem.search.binary;

/**
 * 1060. Missing Element in Sorted Array (Medium)
 * https://leetcode.com/problems/missing-element-in-sorted-array/
 */
public class MissingElementInSortedArray {
    // T:O(logn), S:O(1)
    public int missingElement(int[] nums, int k) {
        // input check (1 <= nums)
        int l = 0, r = nums.length - 1;
        // [4,10], 10 - 4 = 6 - 1 = 5 (missing element)
        int missingNum = nums[r] - nums[l] - (r - l);
        if (missingNum < k) {
            // Input: A = [1,4], K = 3
            // [2,3] missing number, [5]
            return nums[r] + k - missingNum;
        }

        // [4,7,9,10], k = 1
        while (l + 1 < r) {
            int m = l + (r - l) / 2; // [0,3], m = 1
            missingNum = nums[m] - nums[l] - (m - l); // m = 1 (val:7)
            if (k > missingNum) {
                l = m;
                k -= missingNum;
            } else {
                r = m;
            }
        }

        return nums[l] + k;
    }

    // T:O(n), S:O(1)
    public int missingElement1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return 0;
        }

        for (int i = 1; i < nums.length; i++) {
            int gap = nums[i] - nums[i - 1] - 1;
            if (gap == 0) {
                continue;
            }

            if (gap - k >= 0) {
                // passed
                return nums[i - 1] + k;
            } else {
                k = k - gap;
            }
        }

        return nums[nums.length - 1] + k;
    }
}
