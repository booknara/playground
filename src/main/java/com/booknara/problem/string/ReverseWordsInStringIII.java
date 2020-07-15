package com.booknara.problem.string;

/**
 * 557. Reverse Words in a String III (Easy)
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 */
public class ReverseWordsInStringIII {
    // T:O(n), S:O(n)
    public String reverseWords(String s) {
        if (s == null || s.length() <= 1) return s;

        char[] array = s.toCharArray();
        int l = 0, r = 0;
        while (r < array.length) {
            if (array[r] == ' ') {
                // space case
                reverse(array, l, r - 1);
                l = r + 1;
            }

            r++;
        }

        // for last word
        reverse(array, l, r - 1);

        return new String(array);
    }

    public void reverse(char[] array, int l, int r) {
        while (l <= r) {
            char c = array[l];
            array[l] = array[r];
            array[r] = c;
            l++;
            r--;
        }
    }
}
