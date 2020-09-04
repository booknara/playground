package com.booknara.problem.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 969. Pancake Sorting (Medium)
 * https://leetcode.com/problems/pancake-sorting/
 */
public class PancakeSorting {
    // T:O(n^2), S:O(n)
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        // input check
        if (A == null || A.length == 0) return res;

        // already sorted case
        boolean sorted = true;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] > A[i]) {
                sorted = false;
                break;
            }
        }

        if (sorted) return res;

        // [3,2,4,1]
        int max = A.length; // 4
        for (int val = max; val >= 1; val--) {
            // find the index of the value
            int index = getIndex(A, val);   // 2
            if (index == val - 1) {
                // already placed correctly
                continue;
            }

            if (index != 0) {
                swap(A, 0, index);  // [4,2,3,1]
                res.add(index + 1); // [3]
            }
            swap(A, 0, val - 1);// [0, 3], [1,3,2,4]
            res.add(val); //
        }

        return res;
    }

    public void swap(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public int getIndex(int[] A, int val) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == val) return i;
        }

        return -1;
    }
}
/**
 arr = [3,2,4,1], k = 3(1 ~ 3)
 1. find the largest number index = 2 (4)
 2. swap(0 ~ 2)
 3. swap(0 ~ k - 1)

 2. find the next larget number index = idx
 2. swap(0 ~ idx)
 3. swap(0 ~ k - 1)
 ..
 reverse [0 ~ k-1] index
 */