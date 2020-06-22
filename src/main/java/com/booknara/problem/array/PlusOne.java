package com.booknara.problem.array;

import java.math.BigInteger;

/**
 * 66. Plus One (Easy)
 * https://leetcode.com/problems/plus-one/
 */
public class PlusOne {
    // input: one dimension array
    // output: one dimension array which is input + 1
    // 123 -> 124
    // 129 -> 130
    // 999 -> 1000 -> increase the number of digits
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        // in this point, the number increases the number of digits
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

    public int[] plusOne1(int[] digits) {
        // input check
        if (digits == null || digits.length == 0) return new int[] {1};

        StringBuilder builder = new StringBuilder();
        for (int d: digits) {
            builder.append(d);
        }

        BigInteger num = new BigInteger(builder.toString());
        num = num.add(BigInteger.ONE);

        //System.out.println(num);
        String s = num.toString();
        int[] res = new int[s.length()];
        for (int i = 0 ; i < s.length(); i++) {
            res[i] = Character.getNumericValue(s.charAt(i));
        }

        return res;
    }
}
