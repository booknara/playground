package com.booknara.problem.string;

/**
 * 844. Backspace String Compare (Easy)
 * https://leetcode.com/problems/backspace-string-compare/
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        if (S.length() == 0 && T.length() == 0) return true;

        return getString(S).equals(getString(T));
    }

    private String getString(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c: s.toCharArray()) {
            // all lowercase cases
            if (Character.isLetter(c)) {
                builder.append(c);
            } else {
                // # case
                if (builder.length() > 0) {
                    builder.deleteCharAt(builder.length() - 1);
                }
            }
        }

        return builder.toString();
    }
}
