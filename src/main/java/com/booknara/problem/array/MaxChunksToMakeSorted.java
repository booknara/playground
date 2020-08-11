package com.booknara.problem.array;

/**
 * 769. Max Chunks To Make Sorted (Medium)
 * https://leetcode.com/problems/max-chunks-to-make-sorted/
 */
public class MaxChunksToMakeSorted {
    // T:O(n), S:O(1)
    public int maxChunksToSorted(int[] arr) {
        // input check
        int max = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);

            if (max == i) count++;
        }

        return count;
    }
}
