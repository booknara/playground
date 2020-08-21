package com.booknara.problem.twopointers;

/**
 * 905. Sort Array By Parity (Easy)
 * https://leetcode.com/problems/sort-array-by-parity/
 */
public class SortArrayByParity {
    // T:O(n), S:O(1)
    public int[] sortArrayByParity(int[] A) {
        // input check
        if (A.length == 0) return A;

        int l = 0, r = 0;
        while (r < A.length) {
            if (A[r] % 2 == 0) {
                // even number, then swap
                swap(A, l, r);
                l++;
            }
            r++;
        }

        return A;
    }

    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}

/**
 [3,1,2,4]
 using two pointers
 l, r,
 l: waiting for even number found
 r: searching the number
 if (r % 2 == 0) {
 // even number, then swap
 l++;
 }
 r++;

 public void swap(int[] nums, int l, int r) {
 int temp = nums[l];
 nums[l] = nums[r];
 nums[r] = temp;
 }
 */
