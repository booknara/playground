package com.booknara.problem.array;

/**
 * 344. Reverse String (Easy)
 * https://leetcode.com/problems/reverse-string/
 */
public class ReverseString {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        int l = 0, r = s.length - 1;
        while (l < r) {
            swap(s, l, r);
            l++;
            r--;
        }
    }

    public void swap(char[] s, int l, int r) {
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
    }
}
