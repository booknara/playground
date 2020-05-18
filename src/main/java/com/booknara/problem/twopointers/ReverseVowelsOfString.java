package com.booknara.problem.twopointers;

/**
 * 345. Reverse Vowels of a String (Easy)
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 */
public class ReverseVowelsOfString {
    // T:O(n), S:O(1)
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char[] input = s.toCharArray();
        int l = 0, r = input.length - 1;
        while (l < r) {
            // find vowel from the front
            while (l < r && !isVowel(input[l])) {
                l++;
            }
            // find vowel from the back
            while (l < r && !isVowel(input[r])) {
                r--;
            }

            if (l >= r) break;
            // swap
            char temp = input[l];
            input[l] = input[r];
            input[r] = temp;
            l++;
            r--;
        }

        return new String(input);
    }

    private boolean isVowel(char c) {
        return c == 'A' || c == 'a' ||
                c == 'E' || c == 'e' ||
                c == 'I' || c == 'i' ||
                c == 'O' || c == 'o' ||
                c == 'U' || c == 'u';
    }
}
