package com.booknara.problem.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 166. Fraction to Recurring Decimal (Medium)
 * https://leetcode.com/problems/fraction-to-recurring-decimal/
 */
public class FractionRecurringDecimal {
    // T:O(n), S:(m, the length of divisor times)
    public String fractionToDecimal(int numerator, int denominator) {
        // input check
        if (numerator == 0) return "0";
        if (denominator == 1) return String.valueOf(numerator);

        StringBuilder res = new StringBuilder();
        // negative handling
        if (numerator < 0 && denominator > 0) res.append("-");
        if (numerator > 0 && denominator < 0) res.append("-");

        // Edge case [-1, -2147483648]
        Long dividend = Math.abs(Long.valueOf(numerator));
        Long divisor = Math.abs(Long.valueOf(denominator));

        // integer part
        res.append(dividend / divisor);
        long remaining = dividend % divisor;
        if (remaining == 0) {
            return res.toString();
        }
        res.append(".");
        Map<Long, Integer> map = new HashMap<>();
        // floating part
        // [0.] 2,3
        while (remaining != 0) {
            if (map.containsKey(remaining)) {
                int idx = map.get(remaining);
                res.insert(idx, "(");
                res.append(")");
                break;
            }
            // 2, length = 2
            map.put(remaining, res.length());
            remaining *= 10;
            res.append(remaining / divisor);
            remaining %= divisor;
        }

        return res.toString();
    }
}
