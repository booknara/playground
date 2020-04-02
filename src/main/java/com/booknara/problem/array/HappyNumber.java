package com.booknara.problem.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Leet code: 202 Happy Number(Easy)
 * https://leetcode.com/problems/happy-number/
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        // N is positive
        if (n <= 0) return false;
        if (n == 1) return true;

        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getValue(n);
        }

        return n == 1;
    }

    // Sum of (Each digit ^ 2)
    private int getValue(int n) {
        int sum = 0;
        while (n != 0) {
            int mod = n % 10;
            n = n / 10;
            sum += mod * mod;
        }

        return sum;
    }
}
