package com.booknara.problem.dc;

import java.util.Arrays;

public class MergeSortII {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        return mergeSort(nums);
    }

    public int[] mergeSort(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }

        int mid = nums.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(nums, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(nums, mid, nums.length));
        return combine(left, right);
    }

    public int[] combine(int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        int[] res = new int[left.length + right.length];
        while (i < left.length && j < right.length) {
            int num = 0;
            if (left[i] < right[j]) {
                num = left[i];
                i++;
            } else {
                num = right[j];
                j++;
            }
            res[k] = num;
            k++;
        }

        while (i < left.length) {
            res[k] = left[i];
            k++;
            i++;
        }

        while (j < right.length) {
            res[k] = right[j];
            k++;
            j++;
        }

        return res;
    }
}
