package com.booknara.problem.dp;

/**
 * 264. Ugly Number II (Medium)
 * https://leetcode.com/problems/ugly-number-ii/
 */
public class UglyNumberII {
    // T:O(n), S:O(n)
    public int nthUglyNumber(int n) {
        if (n <= 2) return n;

        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            // the previous prime number * 2/3/5 each
            int min = getMin(2 * dp[p2], 3 * dp[p3], 5 * dp[p5]);
            dp[i] = min;

            if (min == 2 * dp[p2]) p2++;
            if (min == 3 * dp[p3]) p3++;
            if (min == 5 * dp[p5]) p5++;
        }

        return dp[n - 1];
    }

    public int getMin(int i, int j, int k) {
        return Math.min(Math.min(i, j), k);
    }

    // TLE
    public int nthUglyNumber1(int n) {
        int i = 1;
        int cnt = 0;
        while (true) {
            if (isUglyNumber(i)) {
                //System.out.println(i);
                cnt++;
            }

            if (cnt == n) break;
            i++;
        }

        return i;
    }

    public boolean isUglyNumber(int n) {
        // System.out.println(n);
        if (n == 1) return true;

        while (n > 0) {
            if (n % 2 == 0 || n % 3 == 0 || n % 5 == 0) {
                if (n % 5 == 0) n /= 5;
                if (n % 3 == 0) n /= 3;
                if (n % 2 == 0) n /= 2;


                if (n == 1) break;
                continue;
            }

            return false;
        }

        return true;
    }
}
