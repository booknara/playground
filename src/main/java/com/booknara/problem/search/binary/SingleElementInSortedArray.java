package com.booknara.problem.search.binary;

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

    // T:O(n), S:O(1)
    public int singleNonDuplicate1(int[] nums) {
        // input check
        if (nums.length == 1) return nums[0];

        int index = 0;
        while (index + 1 < nums.length) {
            // pick two element
            int first = nums[index];
            int second = nums[index + 1];
            if (first != second) return first;
            index += 2;
        }

        return nums[index];
    }
}
/**
 Input: nums =
 [0,1,2,3,4,5,6,7,8]
 [1,1,2,3,3,4,4,8,8]
 Output: 2

 [1,1,2,2,3]
 */