package com.booknara.problem.string;

import java.util.Stack;

/**
 * 1249. Minimum Remove to Make Valid Parentheses (Medium)
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 */
public class MinimumRemoveValidParentheses {
    // T:O(n), S:O(1)
    public String minRemoveToMakeValid(String s) {
        // input check
        if (s == null || s.length() == 0) return "";

        int open = 0;
        StringBuilder builder = new StringBuilder();
        for (char c: s.toCharArray()) {
            // three cases
            if (c == '(') {
                open++;
                builder.append(c);
            } else if (c == ')') {
                if (open != 0) {
                    open--;
                    builder.append(c);
                }
            } else {
                builder.append(c);
            }
        }

        for (int i = 0; i < open; i++) {
            int idx = builder.lastIndexOf("(");
            builder.deleteCharAt(idx);
        }

        return builder.toString();
    }

    public String minRemoveToMakeValid1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') {
                count++;
                stack.push(c);
            } else if (c == ')') {
                if (count != 0) {
                    count--;
                    stack.push(c);
                }
            } else {
                // lowercase letter
                stack.push(c);
            }
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            char c = stack.pop();

            if (c == '(') {
                if (count > 0) {
                    count--;
                } else {
                    builder.insert(0, c);
                }
            } else {
                builder.insert(0, c);
            }
        }

        return builder.toString();
    }
}
