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
        // edge case
        if (prefixSum.length == 1) {
            return 0;
        }

        int sum = prefixSum[prefixSum.length - 1];
        int random = new Random().nextInt(sum) + 1; // randomly generate a number(0 ~ sum - 1) + 1

        int l = 0, r = prefixSum.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;

            // if random value is greater than prefixSum[m], then the answer is surely greater than m
            if (random > prefixSum[m]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }
}
