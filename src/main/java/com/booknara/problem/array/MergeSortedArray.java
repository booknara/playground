package com.booknara.problem.array;

/**
 * 88. Merge Sorted Array (Easy)
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {
    // T:O(n+m), S:O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // input check
        if (m == 0 && n == 0) return;

        m--;
        n--;
        for (int i = m + n + 1; i >= 0; i--) {
            if (m < 0) {
                nums1[i] = nums2[n];
                n--;
            } else if (n < 0) {
                nums1[i] = nums1[m];
                m--;
            } else if (nums1[m] < nums2[n]) {
                nums1[i] = nums2[n];
                n--;
            } else {
                nums1[i] = nums1[m];
                m--;
            }
        }
    }
}
/**
 Input:
 nums1 = [1,2,3,0,0,0], m = 3
 nums2 = [2,5,6],       n = 3

 Output: [1,2,2,3,5,6]
 Merge the values from the end
 */