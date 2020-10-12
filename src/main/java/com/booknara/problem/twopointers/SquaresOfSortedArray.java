package com.booknara.problem.twopointers;

/**
 * 977. Squares of a Sorted Array (Easy)
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 */
public class SquaresOfSortedArray {
    // T:O(n), S:O(n)
    public int[] sortedSquares(int[] A) {
        if (A == null || A.length == 0) return A;

        int l = 0, r = A.length - 1;
        int index = A.length - 1;
        int[] res = new int[A.length];
        while (l <= r) {
            int val;
            if (Math.abs(A[l]) < Math.abs(A[r])) {
                val = A[r];
                r--;
            } else {
                val = A[l];
                l++;
            }
            res[index--] = val * val;
        }

        return res;
    }
}
/**
 Input: [-4,-1,0, 3,10]
          .         .
 res :   [0,1,9,16,100]
 Output: [0,1,9,16,100]
 */