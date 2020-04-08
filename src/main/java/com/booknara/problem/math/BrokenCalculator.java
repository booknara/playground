package com.booknara.problem.math;

/**
 * 991. Broken Calculator (Medium)
 * https://leetcode.com/problems/broken-calculator/
 */
public class BrokenCalculator {
    public int brokenCalc(int X, int Y) {
        if (X == Y) {
            return 0;
        }

        // Y -> X
        // If Y is odd -> Y/2 operation allowed
        // If Y is even -> Y/2 vs Y + 1
        //                 1) Y/2 -> Y/2 or Y/2 + 1(*)
        //                 2) Y + 1 -> Y + 1 + 1 -> Y + 1 + 1 + 1 (*)
        //                                       -> (Y + 1 + 1) / 2 (*)
        // Therefore, Y/2 + 1 == (Y + 1 + 1) / 2
        int res = 0;
        while (Y > X) {
            if (Y % 2 == 0) {
                // Even
                Y /= 2;
            } else {
                // Odd
                Y++;
            }
            res++;
        }

        // In this point, Y < X to escape while statement.
        // Then there are X - Y addition times required to reach X -> Y
        return res + X - Y;
    }
}
