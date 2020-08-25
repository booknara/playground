package com.booknara.problem.string;

import java.util.Stack;

/**
 * 1249. Minimum Remove to Make Valid Parentheses (Medium)
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 */
public class MinimumRemoveValidParentheses {
    // T:O(n), S:O(1)
    public String minRemoveToMakeValidBetter(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        int count = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') {
                count++;
                builder.append(c);
            } else if (c == ')') {
                if (count != 0) {
                    count--;
                    builder.append(c);
                }
            } else {
                // lowercase letter
                builder.append(c);
            }
        }

        for (int i = 0; i < count; i++) {
            int idx = builder.lastIndexOf("(");
            builder.deleteCharAt(idx);
        }

        return builder.toString();
    }

    public String minRemoveToMakeValid(String s) {
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
