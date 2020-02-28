package com.booknara.problem.bit;

/**
 * 393. UTF-8 Validation (Medium)
 * https://leetcode.com/problems/utf-8-validation/
 */
public class UTF8Validation {
    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0) {
            return true;
        }

        boolean start = true;
        int children = 0;
        int i = 0;
        while (i < data.length) {
            if (start) {
                if (data[i] >= 0 && data[i] <= 127) {
                    // 0XXX XXXX (0000 0000 ~ 0111 1111)
                    children = 0;
                    start = true;
                } else if (data[i] >= 192 && data[i] <= 223) {
                    // 110X XXXX (1100 0000 ~ 1101 1111)
                    children = 1;
                    start = false;
                } else if (data[i] >= 224 && data[i] <= 239) {
                    // 1110 XXXX (1110 0000 ~ 1110 1111)
                    children = 2;
                    start = false;
                } else if (data[i] >= 240 && data[i] <= 247) {
                    // 1111 0XXX (1111 0000 ~ 1111 0111)
                    children = 3;
                    start = false;
                } else {
                    return false;
                }
                i++;
            } else {
                while (children != 0) {
                    // 10XX XXXX (1000 0000 ~ 1011 1111)
                    if (data[i] < 128 || data[i] > 191) {
                        return false;
                    }
                    i++;
                    children--;
                }

                start = true;
            }
        }

        return children == 0;
    }
}
