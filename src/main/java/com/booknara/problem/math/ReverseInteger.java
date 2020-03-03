package com.booknara.problem.math;

/**
 * 7. Reverse Integer (Easy)
 * https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {
    public int reverseSimpler(int x) {
        int positive = 1;
        if (x < 0) {
            positive = -1;
            x *= positive;
        }

        long value = 0;
        while (x > 0) {
            int mod = x % 10;
            value = value * 10 + mod;
            if (value > Integer.MAX_VALUE) {
                value = 0;
                break;
            }
            x /= 10;
        }

        return (int) value * positive;
    }

    public int reverse(int x) {
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
