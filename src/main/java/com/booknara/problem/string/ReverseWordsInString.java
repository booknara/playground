package com.booknara.problem.string;

/**
 * 151. Reverse Words in a String (Medium)
 * https://leetcode.com/problems/reverse-words-in-a-string/
 * Follow-up: lets go to 'new york' -> 'new york' to go lets
 */
public class ReverseWordsInString {
    // T:O(n), S:O(n)
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuilder builder = new StringBuilder();
        int len = s.length();
        int i = len - 1;
        while (i >= 0) {
            // remove spaces
            if (s.charAt(i) == ' ') {
                i--;
                continue;
            }
            int j = i - 1;
            while (j >= 0 && s.charAt(j) != ' ') j--;
            builder.append(" ");
            builder.append(s.substring(j + 1, i + 1));
            i = j - 1;
        }

        if (builder.length() > 0) builder.deleteCharAt(0);

        return builder.toString();
    }

    // T:O(n), S:O(n)
    public String reverseWords1(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuilder builder = new StringBuilder();
        String[] sArray = s.split(" ");
        for (int i = sArray.length - 1; i >= 0; i--) {
            if (sArray[i].length() == 0) continue;
            builder.append(sArray[i]).append(" ");
        }

        return builder.toString().trim();
    }
}
