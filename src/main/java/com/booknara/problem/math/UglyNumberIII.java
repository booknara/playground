package com.booknara.problem.math;

/**
 * 1201. Ugly Number III (Medium)
 * https://leetcode.com/problems/ugly-number-iii/
 */
public class UglyNumberIII {
    // T:O(logn), S:O(1)
    public int nthUglyNumber(int n, int a, int b, int c) {
        // input check (1 <= n, a, b, c <= 10^9)
        int l = 1, r = Integer.MAX_VALUE;
        while (l < r) {
            int m = l + (r - l) / 2;
            long count = getCount(m, a, b, c);
            //System.out.println(count);
            if (count < n) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return r;
    }

    // calculate how many numbers are from 1 to n which are divisible by a or b or c
    public long getCount(int n, int a, int b, int c) {
        return (n / a) + (n / b) + (n / c)
                - (n / LCM.getLCM(a, b))
                - (n / LCM.getLCM(b, c))
                - (n / LCM.getLCM(c, a))
                + (n / LCM.getLCM(a, b, c));
    }

    // TLE
    public int nthUglyNumber1(int n, int a, int b, int c) {
        // input check (1 <= n, a, b, c <= 10^9)
        int res = 0;
        int pA = 1, pB = 1, pC = 1;
        for (int i = 1; i <= n; i++) {
            // divided by a or b or c
            int min = getMin(a * pA, b * pB, c * pC);
            //System.out.println(min);
            res = min;
            if (min == a * pA) pA++;
            if (min == b * pB) pB++;
            if (min == c * pC) pC++;
        }

        return res;
    }

    public int getMin(int i, int j, int k) {
        return Math.min(Math.min(i, j), k);
    }
}
