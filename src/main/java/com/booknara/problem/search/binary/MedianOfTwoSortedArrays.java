package com.booknara.problem.search.binary;

/**
 * 4. Median of Two Sorted Arrays (Hard)
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class MedianOfTwoSortedArrays {
    // T:O(log (n+m)), S:O(log (n+m))
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length * nums2.length == 0) return 0.0;
        int total = nums1.length + nums2.length;
        int left = (total + 1) / 2; // left half of the combined median
        int right = (total + 2) / 2;   // right half of the combined median

        if ((total & 1) == 0) {
            // even length
            int first = findKthElement(nums1, 0, nums2, 0, left);
            int second = findKthElement(nums1, 0, nums2, 0, right);
            return (first + second) / 2.0;
        } else {
            // odd length
            return findKthElement(nums1, 0, nums2, 0, left);
        }
    }

    // find kth element in nums1 + nums2
    public int findKthElement(int[] nums1, int start1, int[] nums2, int start2, int k) {
        // if nums1 is too small, return kth number in nums2
        if (start1 > nums1.length - 1) return nums2[start2 + k - 1];
        // if nums2 is too small, return kth number in nums1
        if (start2 > nums2.length - 1) return nums1[start1 + k - 1];
        // if k == 1, return smaller number since nums1, nums2 are sorted.
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int mid1Value = Integer.MAX_VALUE;
        int mid2Value = Integer.MAX_VALUE;
        if (start1 + k/2 - 1 < nums1.length) mid1Value = nums1[start1 + k/2 - 1];
        if (start2 + k/2 - 1 < nums2.length) mid2Value = nums2[start2 + k/2 - 1];

        // Throw away half of the array from nums1 + nums2. And cut k in half
        if (mid1Value < mid2Value) {
            return findKthElement(nums1, start1 + k/2, nums2, start2, k - k/2); // nums1 right + nums2 left
        } else {
            return findKthElement(nums1, start1, nums2, start2 + k/2, k - k/2); // nums2 left + nums1 right
        }
    }
}
