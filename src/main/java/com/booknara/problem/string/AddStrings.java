package com.booknara.problem.string;

/**
 * 415. Add Strings (Easy)
 * https://leetcode.com/problems/add-strings/
 */
public class AddStrings {
    // T:O(n), S:O(1)
    public String addStrings(String num1, String num2) {
        // input check
        if (num1.length() == 0 && num2.length() == 0) return "";
        if (num1.length() * num2.length() == 0) return num1.length() != 0 ? num1 : num2;

        // "123", "9"
        // max = 3
        int max = Math.max(num1.length(), num2.length());
        int i = 0, carry = 0;
        StringBuilder builder = new StringBuilder();
        // 0 ~ 2
        while (i < max || carry == 1) {
            int n1 = 0, n2 = 0;
            if (i < num1.length()) {
                n1 = Character.getNumericValue(num1.charAt(num1.length() - i - 1));
            }

            if (i < num2.length()) {
                n2 = Character.getNumericValue(num2.charAt(num2.length() - i - 1));
            }

            int sum = n1 + n2 + carry;
            int digit = sum % 10;
            // carry reset
            carry = sum > 9 ? 1 : 0;
            builder.append(digit);

            i++;
        }

        return builder.reverse().toString();
    }
}

/**
 Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 Input 0 ~ n
 Output : string

 "123"
 "789"
 carry
 each digit = previous digits from num1 and nums2 + carry(0 or 1)
 (sum + carry) % 10 = digit
 sum > 9 = carry (1)

 loop = 3
 "123"
 "889"
 3 + 9 +c(0) = 2
 carry = 1;

 2 + 8 + c(1) = 1
 carry = 1;

 1 + 8 + c(1) = 0
 carry = 1

 1012

 loop n(3) times
 "123"
 "009"
 */