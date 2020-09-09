package com.booknara.problem.string;

import com.booknara.problem.common.Reader4;

/**
 * 157. Read N Characters Given Read4 (Easy)
 * https://leetcode.com/problems/read-n-characters-given-read4/
 */
public class ReadNCharactersGivenRead4 extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    // T:O(min(n, m), m: the total buffer size
    public int read(char[] buf, int n) {
        int totalRead = 0;
        char[] buf4 = new char[4];

        while (true) {
            int read = read4(buf4);
            if (read == 0) break;   // edge case: if totalRead is greater than n, e.g. totalRead : 8, n: 5

            for (int i = 0; i < read; i++) {
                if (totalRead == n) return totalRead;

                buf[totalRead++] = buf4[i];
            }
        }

        return totalRead;
    }
}
