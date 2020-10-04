package com.booknara.problem.search.binary;

/**
 * 4. Median of Two Sorted Arrays (Hard)
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class MedianOfTwoSortedArrays {
    // T:O(log (n+m)), S:O(1)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        // nums1 is smaller length array
        int n = nums1.length;
        int m = nums2.length;
        int start = 0, end = n;
        while (start <= end) {
            // partitionX + partitionY = (n + m + 1) / 2
            int partitionX = (start + end) / 2;     // 1
            int partitionY = ((n + m + 1) / 2) - partitionX;    // 3

            // 4 values check
            int nums1MaxLeft = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int nums1MinRight = partitionX == n ? Integer.MAX_VALUE : nums1[partitionX];
            int nums2Maxleft = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];;
            int nums2MinRight = partitionY == m ? Integer.MAX_VALUE : nums2[partitionY];

            if (nums1MaxLeft <= nums2MinRight && nums2Maxleft <= nums1MinRight) {
                // found
                if ((n + m) % 2 == 0) {
                    // even
                    return (Math.max(nums1MaxLeft, nums2Maxleft) + Math.min(nums1MinRight, nums2MinRight)) / 2.0;
                } else {
                    // odd
                    return Math.max(nums1MaxLeft, nums2Maxleft);
                }
            } else if (nums1MaxLeft > nums2MinRight) {
                end = partitionX - 1;
            } else {
                start = partitionX + 1;
            }
        }

        return -1;
    }
    /**
     Input: n = 3, m = 5
     [2 | 3,8]
     [1,3,4 | 6,7]

     [1,2,3,3,4,6,7,8] -> (3 + 4) / 2 = 3.5

     Output: 2.00000
     Explanation: merged array = [1,2,3] and median is 2.
     */

    // T:O(log (n+m)), S:O(log (n+m))
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
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
