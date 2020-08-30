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

    // T:O(max length (a, b), S:O(max length (a, b)
    public String addBinary1(String a, String b) {
        if (a.length() == 0) return b;
        if (b.length() == 0) return a;

        // a = "1010"
        // b = "1011"
        StringBuilder res = new StringBuilder();
        int m = a.length() - 1; // 3
        int n = b.length() - 1; // 3
        int carry = 0;
        while (m >= 0 || n >= 0 || carry == 1) {
            int f = 0;
            if (m >= 0) {
                f = Character.getNumericValue(a.charAt(m));    // 0
            }
            int s = 0;
            if (n >= 0) {
                s = Character.getNumericValue(b.charAt(n));    // 1
            }

            int sum = f + s + carry;    // 1 + 0 + 0 (carry)
            if (sum == 3) {
                res.insert(0, "1");
                carry = 1;
            } else if (sum == 2) {
                res.insert(0, "0");
                carry = 1;
            } else if (sum == 1) {
                res.insert(0, "1");
                carry = 0;
            } else {
                res.insert(0, "0");
                carry = 0;
            }
            m--;
            n--;
        }

        // "10101"
        return res.toString();
    }
}
