package com.booknara.problem.math;

/**
 * 7. Reverse Integer (Easy)
 * https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {
    public int reverse(int x) {
        if (x == 0) return 0;

        int positive = 1;
        if (x < 0) {
            positive = -1;
            x *= positive;
        }

        long res = 0;
        while (x > 0) {
            int mod = x % 10;
            res = res * 10 + mod;
            if (res > Integer.MAX_VALUE) {
                res = 0;
                break;
            }
            x /= 10;
        }

        return (int) res * positive;
    }

    public int reverse1(int x) {
        int positive = 1;
        if (x < 0) {
            positive = -1;
            x *= positive;
        }
        String s = String.valueOf(x);
        int res = 0;
        try {
            res = positive * Integer.parseInt(new StringBuilder(s).reverse().toString());
        } catch (Exception e) {
            //System.out.println("number exception");
        }

        return res;
    }
}
