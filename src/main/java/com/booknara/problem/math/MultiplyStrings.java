package com.booknara.problem.math;

import java.math.BigInteger;

/**
 * 43. Multiply Strings (Medium)
 * https://leetcode.com/problems/multiply-strings/
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.length() * num2.length() == 0) {
            return "";
        }

        int m = num1.length();
        int n = num2.length();
        int[] number = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = Character.getNumericValue(num1.charAt(i)) *
                        Character.getNumericValue(num2.charAt(j));
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + number[p2];

                number[p1] += sum / 10;     // carry
                number[p2] = sum % 10;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int value : number) {
            // // !(builber.length() == 0 && value == 0) is to skip the leading zeros.
            if (!(builder.length() == 0 && value == 0)) {
                builder.append(value);
            }
        }

        return builder.length() == 0 ? "0" : builder.toString();
    }

    public String multiply1(String num1, String num2) {
        if (num1 == null && num2 == null) return "";
        if (num1 == null) return num2;
        if (num2 == null) return num1;

        int len2 = num2.length() - 1;
        BigInteger level = BigInteger.ONE;
        BigInteger sum = BigInteger.ZERO;
        for (int i = len2; i >= 0; i--) {
            BigInteger n
                    = getMultiply(num1, Character.getNumericValue(num2.charAt(i)))
                    .multiply(level);
            sum = sum.add(n);
            level = level.multiply(BigInteger.TEN);
        }

        return sum.toString();
    }

    private BigInteger getMultiply(String s, int c) {
        if (c == 0) return BigInteger.ZERO;

        StringBuilder builder = new StringBuilder();
        int len = s.length() - 1;
        int carry = 0;
        while (len >= 0 || carry != 0) {
            int num = 1;
            int multi;
            if (len >= 0) {
                num = Character.getNumericValue(s.charAt(len));
                len--;
                multi = num * c + carry;
            } else {
                multi = carry;
            }

            carry = multi / 10;
            multi = multi % 10;
            builder.append(multi);
        }

        return new BigInteger(builder.reverse().toString());
    }

    // T:O(n * m), S:O(n + m)
    public String multiply2(String num1, String num2) {
        // input check
        if (num1.length() == 0 || num2.length() == 0) return "";

        int[] nums = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int multi = num1.charAt(i) - '0' * num2.charAt(j) - '0';  // can be two digits
                int mod = multi % 10 + nums[i + j + 1];
                int quo = multi / 10 + nums[i + j];
                if (mod > 9) {
                    mod -= 10;
                    quo++;
                }

                int carry = 0;
                if (quo > 9) {
                    quo -= 10;
                    carry = 1;
                }
                nums[i + j + 1] = mod;
                nums[i + j] = quo;
                if (carry == 1) nums[i + j - 1] += carry;
            }
        }

        StringBuilder builder = new StringBuilder();
        boolean start = false;
        for (int n: nums) {
            if (n == 0) {
                if (start) builder.append(n);

                continue;
            }

            start = true;
            builder.append(n);
        }

        return builder.length() == 0 ? "0" : builder.toString();
    }
}
