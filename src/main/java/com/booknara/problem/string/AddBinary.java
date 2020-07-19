package com.booknara.problem.string;

/**
 * 67. Add Binary (Easy)
 * https://leetcode.com/problems/add-binary/
 */
public class AddBinary {
    // T:O(max length (a, b), S:O(max length (a, b)
    public String addBinary(String a, String b) {
        // input check(non-empty, only contains 1, 0, no leading zero)
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        while (i >= 0 || j >= 0 || carry == 1) {
            char x = '0', y = '0';
            if (i >= 0) {
                x = a.charAt(i);
            }
            if (j >= 0) {
                y = b.charAt(j);
            }

            //System.out.println(x + "," + y);
            if (x == '1' && y == '1') {
                if (carry == 0) {
                    builder.append("0");
                } else {
                    builder.append("1");
                }
                carry = 1;
            } else if (x == '1' || y == '1') {
                if (carry == 0) {
                    builder.append("1");
                    carry = 0;
                } else {
                    builder.append("0");
                    carry = 1;
                }
            } else {
                // x == 0 && y == 0
                if (carry == 0) {
                    builder.append("0");
                } else {
                    builder.append("1");
                }

                carry = 0;
            }

            i--;
            j--;
        }

        return builder.reverse().toString();
    }
}
