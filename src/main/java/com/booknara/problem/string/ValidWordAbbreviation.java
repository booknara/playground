package com.booknara.problem.string;

/**
 * 408. Valid Word Abbreviation (Easy)
 * https://leetcode.com/problems/valid-word-abbreviation/
 */
public class ValidWordAbbreviation {
    // T:O(n), S:O(1)
    public boolean validWordAbbreviation(String word, String abbr) {
        // input check, non-empty word, abbr string
        if (word.length() < abbr.length()) return false;

        int count = 0;
        int num = 0;
        for (int i = 0; i < abbr.length(); i++) {
            char c = abbr.charAt(i);
            // two cases
            if (Character.isDigit(c)) {
                // number
                if (num == 0 && c == '0') return false; // "hi", "02"
                num = num * 10 + (c - '0');
            } else {
                // the previous number handling
                if (num != 0) {
                    count += num;
                    if (count > word.length()) return false;    // out of range
                }

                // letter ("hi", "2i")
                if (count >= word.length() || word.charAt(count) != c) return false;
                count++;
                num = 0;
            }
        }

        // "a", "2"
        if (num != 0) {
            count += num;
            if (count != word.length()) return false;    // out of range or not enough index
        }

        return true;
    }
}
