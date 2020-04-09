package com.booknara.problem.array;

/**
 * 88. Merge Sorted Array (Easy)
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = m + n - 1;
        m = m - 1;
        n = n - 1;
        while (m >= 0 || n >= 0) {
            // System.out.println(idx);
            if (m >= 0 && n >= 0) {
                if (nums1[m] > nums2[n]) {
                    nums1[idx--] = nums1[m--];
                } else {
                    nums1[idx--] = nums2[n--];
                }
            } else if (m >= 0) {
                nums1[idx--] = nums1[m--];
            } else {
                nums1[idx--] = nums2[n--];
            }
        }

        return;
    }
}
