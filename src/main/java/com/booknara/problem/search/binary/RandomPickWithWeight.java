package com.booknara.problem.search.binary;

import java.util.Random;

/**
 * 528. Random Pick with Weight (Medium)
 * https://leetcode.com/problems/random-pick-with-weight/
 */
public class RandomPickWithWeight {
    int[] prefixSum;
    public RandomPickWithWeight(int[] w) {
        for (int i = 1; i < w.length; i++) {
            // get prefix sum
            w[i] += w[i - 1];
        }
        prefixSum = w;
    }

    // T:O(logn), S:O(1)
    public int pickIndex() {
        if (prefixSum.length == 1) {
            // no need to check possiblity because of the only one element
            return 0;
        }

        Random r = new Random();
        // add 1 because nextInt() returns inclusive ~ exclusive
        int num = r.nextInt(prefixSum[prefixSum.length - 1]) + 1;
        // Use binary search because w(prefix sum) is ascending(prerequisite) and better than linear search
        int left = 0, right = prefixSum.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (num > prefixSum[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
