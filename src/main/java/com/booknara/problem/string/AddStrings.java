package com.booknara.problem.string;

/**
 * 415. Add Strings (Easy)
 * https://leetcode.com/problems/add-strings/
 */
public class AddStrings {
    // T:O(n), S:O(1)
    public String addStrings(String num1, String num2) {
        // input check
        if (num1.equals("0")) return num2;
        if (num2.equals("0")) return num1;

        // move backward
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0) {
            int f = 0;
            if (i >= 0) f = num1.charAt(i) - '0';
            int s = 0;
            if (j >= 0) s = num2.charAt(j) - '0';

            int sum = f + s + carry;
            if (sum > 9) {
                carry = 1;
                sum -= 10;
            } else {
                carry = 0;
            }

            builder.append(sum);
            i--;
            j--;
        }

        return builder.reverse().toString();
    }
}
/**
 Input clarification
 1. num1, num2 = non-negative integers, they can be 0 or higher
 2. There is no leading zero on num1, num2

 19
 181
 200
 */