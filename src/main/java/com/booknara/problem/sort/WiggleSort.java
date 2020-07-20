package com.booknara.problem.sort;

import java.util.Arrays;

/**
 * 280. Wiggle Sort (Medium)
 * https://leetcode.com/problems/wiggle-sort/
 */
public class WiggleSort {
    // T:O(n), S:O(1)
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        // 2 requirements
        // odd element is equal to or bigger than the previous element
        // even element is equal to or smaller than the previous element except 0-index element
        for (int i = 1; i < nums.length; i++) {
            if ((i & 1) == 0) {
                // even
                if (nums[i] > nums[i - 1]) {
                    swap(nums, i, i - 1);
                }
            } else {
                // odd
                if (nums[i] < nums[i - 1]) {
                    swap(nums, i, i - 1);
                }
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // T:O(nlogn), S:O(1)
    public void wiggleSort1(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        Arrays.sort(nums);
        if (nums.length == 2) {
            return;
        }

        int l = 1, r = 2;
        while (r < nums.length) {
            // swap btw l and r
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l += 2;
            r += 2;
        }
    }
}
