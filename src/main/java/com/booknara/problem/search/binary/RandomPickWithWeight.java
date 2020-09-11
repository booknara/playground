package com.booknara.problem.search.binary;

import java.util.Random;

/**
 * 528. Random Pick with Weight (Medium)
 * https://leetcode.com/problems/random-pick-with-weight/
 */
public class RandomPickWithWeight {
    int[] sum;
    public RandomPickWithWeight(int[] w) {
        for (int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }

        sum = w;
    }

    // T:O(logn), S:O(1)
    public int pickIndex() {
        // edge case that there is the only one element, return 0 index
        if (sum.length == 1) return 0;

        int l = 0;
        int r = sum.length - 1;
        int random = new Random().nextInt(sum[sum.length - 1]) + 1; // [1 ~ r]

        // [0,1,4,8], [0,3], random = 2;, [0,1]
        while (l < r) {
            int m = l + (r - l) / 2;    // 4(1), 1(0)
            if (random == sum[m]) return m;

            if (random < sum[m]) {
                r = m;  // [0, 1]
            } else {
                l = m + 1;
            }
        }

        return r;
    }
}
