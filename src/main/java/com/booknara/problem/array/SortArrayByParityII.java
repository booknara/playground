package com.booknara.problem.array;

/**
 * 922. Sort Array By Parity II (Easy)
 * https://leetcode.com/problems/sort-array-by-parity-ii/
 */
public class SortArrayByParityII {
    // T:O(n), S:O(1)
    public int[] sortArrayByParityII(int[] A) {
        if (A.length == 0) return new int[] { };

        int j = 1;
        for (int i = 0; i < A.length; i += 2) {
            if (A[i] % 2 == 1) {
                while (j < A.length && A[j] % 2 == 1) {
                    j += 2;
                }

                swap(A, i, j);
            }
        }

        return A;
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    // T:O(n), S:O(n)
    public int[] sortArrayByParityII1(int[] A) {
        if (A.length == 0) return new int[] { };

        int[] res = new int[A.length];
        int evenIdx = 0, oddIdx = 1;
        for (int n: A) {
            if (n % 2 == 0) {
                // even
                res[evenIdx] = n;
                evenIdx += 2;
            } else {
                // odd
                res[oddIdx] = n;
                oddIdx += 2;
            }
        }

        return res;
    }
}
