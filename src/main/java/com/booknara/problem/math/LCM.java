package com.booknara.problem.math;

/**
 * Least Common Multiple
 */
public class LCM {
    public static int getLCM(int x, int y) {
        return Math.abs(x * y) / new GCD().getGCD2(x, y);
    }

    public static int getLCM(int x, int y, int z) {
        return getLCM(getLCM(x, y), z);
    }
}
