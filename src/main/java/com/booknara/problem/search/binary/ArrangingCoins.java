package com.booknara.problem.search.binary;

/**
 * 441. Arranging Coins (Easy)
 * https://leetcode.com/problems/arranging-coins/
 */
public class ArrangingCoins {
    // T:O(logn), S:O(1)
    public int arrangeCoins(int n) {
        // input check
        if (n <= 1) return n;

        int res = 0;
        long l = 1, r = n;
        while (l <= r) {
            long m = l + (r - l) / 2;
            //System.out.println(m);
            long sum = m * (m + 1) / 2;
            if (sum == n) return (int) m;

            if (n < sum) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return (int) r;
    }
}
