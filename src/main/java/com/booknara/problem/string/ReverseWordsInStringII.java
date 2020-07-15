package com.booknara.problem.string;

import java.util.Arrays;

/**
 * 186. Reverse Words in a String II (Medium)
 * https://leetcode.com/problems/reverse-words-in-a-string-ii/
 */
public class ReverseWordsInStringII {
    // T:O(n), S:O(1)
    public void reverseWords(char[] s) {
        if (s == null || s.length <= 1) return;

        // reverse the entire string (ab cd -> dc ba)
        reverse(s, 0, s.length - 1);

        int l = 0, r = 0;
        while (r < s.length) {
            while (r < s.length && s[r] != ' ') r++;

            // reverse each word (dc -> cd, ba -> ab)
            reverse(s, l, r - 1);
            l = r + 1;

            r++;
        }

        // handling the last word
        reverse(s, l, r - 1);
    }

    // l, t, inclusive
    public void reverse(char[] s, int l, int r) {
        while (l <= r) {
            char c = s[l];
            s[l] = s[r];
            s[r] = c;
            l++;
            r--;
        }
    }

    // T:O(n), S:O(n)
    public void reverseWords1(char[] s) {
        if (s == null || s.length == 0) return;

        char[] res = new char[s.length];
        Arrays.fill(res, ' ');
        int l = s.length - 1, r = s.length;
        int resIdx = 0;
        while (l >= 0) {
            if (s[l] == ' ') {
                // copy (l + 1 ~ r, inclusive ~ exclusive)
                for (int i = l + 1; i < r; i++) {
                    res[resIdx++] = s[i];
                }
                resIdx++;   // space btw words
                r = l;
            }

            l--;
        }

        // handling for the last word
        for (int i = l + 1; i < r; i++) {
            res[resIdx++] = s[i];
        }


        for (int i = 0; i < s.length; i++) {
            s[i] = res[i];
        }
    }
}
