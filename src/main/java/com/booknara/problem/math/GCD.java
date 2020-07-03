package com.booknara.problem.math;

/**
 * Greatest Common Divisor (GCD)
 */
public class GCD {
    public static int getGCD(int x, int y) {
        int min = Math.min(x, y);
        int gcd = 1;
        for (int i = 1; i <= min; i++) {
            if (x % i == 0 && y % i == 0) {
                gcd = i;
            }
        }

        return gcd;
    }

    public static int getGCD1(int x, int y) {
        while (x != y) {
            if (x > y) {
                x = x - y;
            } else {
                y = y - x;
            }
        }

        return x;
    }

    public static int getGCD2(int x, int y) {
        if (y == 0) return x;

        return getGCD2(y, x % y);
    }

    public static int getGCD(int x, int y, int z) {
        return getGCD(x, getGCD(y, z));
    }
}
