package com.booknara.problem.array;

/**
 * 443. String Compression (Easy)
 * https://leetcode.com/problems/string-compression/
 */
public class StringCompression {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }

        char c = chars[0];
        int repeat = 1;
        int j = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == c) {
                repeat++;
            } else {
                // start compression
                chars[j++] = c;
                if (repeat != 1) {
                    char[] counts = String.valueOf(repeat).toCharArray();
                    for (int k = 0; k < counts.length; k++) {
                        chars[j++] = counts[k];
                    }

                    repeat = 1;
                }
                c = chars[i];
            }
        }

        // last expression
        chars[j++] = c;
        if (repeat != 1) {
            char[] counts = String.valueOf(repeat).toCharArray();
            for (int k = 0; k < counts.length; k++) {
                chars[j++] = counts[k];
            }
        }

        return j;
    }
}
