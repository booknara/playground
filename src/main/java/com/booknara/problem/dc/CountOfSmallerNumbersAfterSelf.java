package com.booknara.problem.dc;

import java.util.ArrayList;
import java.util.List;

/**
 * 315. Count of Smaller Numbers After Self (Hard)
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 */
public class CountOfSmallerNumbersAfterSelf {
    int[] count;
    // T:O(n*logn), S:O(n)
    public List<Integer> countSmaller(int[] nums) {
        // input check
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        if (nums.length == 1) {
            res.add(0);
            return res;
        }

        int n = nums.length;
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        count = new int[n];
        mergeSort(nums, indices, 0, n - 1);

        for (int i = 0; i < n; i++) {
            res.add(count[i]);
        }

        return res;
    }

    public void mergeSort(int[] nums, int[] indices, int start, int end) {
        // base case
        if (start >= end) return;

        int m = start + (end - start) / 2;
        mergeSort(nums, indices, start, m);
        mergeSort(nums, indices, m + 1, end);

        merge(nums, indices, start, end);
    }

    // start, end : inclusive
    public void merge(int[] nums, int[] indices, int start, int end) {
        int m = start + (end - start) / 2;
        int left = start, right = m + 1;
        int rightCount = 0;
        int[] sortIndices = new int[end - start + 1];
        int sortedIndex = 0;

        while (left <= m && right <= end) {
            //System.out.println(left + "," + right);
            if (nums[indices[right]] < nums[indices[left]]) {
                sortIndices[sortedIndex] = indices[right];
                rightCount++;
                right++;
            } else {
                sortIndices[sortedIndex] = indices[left];
                count[indices[left]] += rightCount;
                left++;
            }

            sortedIndex++;
        }

        while (left <= m) {
            sortIndices[sortedIndex] = indices[left];
            count[indices[left]] += rightCount;
            left++;
            sortedIndex++;
        }

        while (right <= end) {
            sortIndices[sortedIndex] = indices[right];
            right++;
            sortedIndex++;
        }

        for (int i = start; i <= end; i++) {
            indices[i] = sortIndices[i - start];
        }
    }
}
