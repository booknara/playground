package com.booknara.problem.hash;

import java.util.HashMap;
import java.util.Map;

public class FractionRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0 || denominator == 1) {
            return String.valueOf(numerator);
        }

        StringBuilder builder = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            builder.append("-");
        }

        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));

        builder.append(dividend / divisor);
        long remaining = dividend % divisor;
        if (remaining == 0) {
            return builder.toString();
        }
        builder.append(".");

        Map<Long, Integer> map = new HashMap<>();
        while (remaining != 0) {
            if (map.containsKey(remaining)) {
                // Repeat
                builder.insert(map.get(remaining), "(");
                builder.append(")");
                break;
            }

            map.put(remaining, builder.length());
            remaining *= 10;
            builder.append(remaining / divisor);
            remaining = remaining % divisor;
        }

        return builder.toString();
    }
}
