package com.booknara.problem.string;

/**
 * 214. Shortest Palindrome (Hard)
 * https://leetcode.com/problems/shortest-palindrome/
 */
public class ShortestPalindrome {
    // T:O(n^2), S:O(1)
    public String shortestPalindrome(String s) {
        // input check
        if (s == null || s.length() == 0) return "";

        String reversed = new StringBuilder(s).reverse().toString();
        int count = 1;
        int len = 1;
        while (count <= s.length()) {
            if (s.substring(0, count).equals(reversed.substring(reversed.length() - count))) {
                len = count;
            }

            count++;
        }

        //System.out.println(len);

        return reversed.substring(0, reversed.length() - len) + s;
    }

    // T:O(n), S:O(n)
    public String shortestPalindrome1(String s) {
        // input check
        if (s == null || s.length() == 0) return "";

        String reversed = new StringBuilder(s).reverse().toString();
        String l = s + "#" + reversed;

        int[] p = new int[l.length()];
        prefix(p, l);

        return reversed.substring(0, s.length() - p[l.length() - 1]) + s;
    }

    //  012345678
    // "abab#baba"
    // [001200123]
    // KMP partial match table
    public void prefix(int[] p, String s) {
        int j = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = p[j - 1];
            }

            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }

            p[i] = j;
        }
    }
}
/**
 Input: "abcd"
 Output: "dcb abcd"

 "abcd" -> reverse(): "dcba"
 "abcd#dcba"

 find the longest length that the prfix of s AND the suffix of reversed are same

 */