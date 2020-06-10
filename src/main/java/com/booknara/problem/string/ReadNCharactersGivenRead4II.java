package com.booknara.problem.string;

import com.booknara.problem.common.Reader4;

/**
 * 158. Read N Characters Given Read4 II - Call multiple times (Hard)
 * https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/
 */
public class ReadNCharactersGivenRead4II extends Reader4 {
    private int pos = 0;
    private int res = 0;
    private char[] mBuf = new char[4];

    //T:O(n), S:O(1)
    public int read(char[] buf, int n) {
        int ptr = 0;
        while (ptr < n) {
            if (pos == 0) {
                res = read4(mBuf);
            }
            if (res == 0) break;

            while (ptr < n && pos < res) {
                buf[ptr++] = mBuf[pos++];
            }

            if (pos >= res) pos = 0;
        }

        return ptr;
    }
}
