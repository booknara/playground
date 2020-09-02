package com.booknara.problem.bit;

/**
 * 405. Convert a Number to Hexadecimal (Easy)
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal/
 */
public class ConvertNumberToHexadecimal {
    public String toHex(int num) {
        if (num == 0) return "0";

        StringBuilder res = new StringBuilder();
        while (num != 0) {
            int mod = num & 15; // Oxf
            res.append(getHexNumber(mod));
            num = num >>> 4;    // Unsigned right shift
        }

        return res.reverse().toString();
    }

    public String getHexNumber(int num) {
        if (num < 10) return String.valueOf(num);

        if (num == 10) return "a";
        if (num == 11) return "b";
        if (num == 12) return "c";
        if (num == 13) return "d";
        if (num == 14) return "e";
        if (num == 15) return "f";

        return "";
    }
}
/**
 Input: 26
 Output: "1a"

 26 = 1(1) 1010(a)
 4 right shift for next hexadecimal
 */