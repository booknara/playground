package com.booknara.problem.stack;

import java.util.Stack;

/**
 * 20. Valid Parentheses (Easy)
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {
    // version: 04/16/2020
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // open case
            if ((c == '(' || c == '{' || c == '[')) {
                stack.push(c);
                continue;
            }

            // close case
            if (stack.isEmpty()) return false;
            char e = stack.pop();
            if ((e == '(') != (c == ')')) return false;
            if ((e == '{') != (c == '}')) return false;
            if ((e == '[') != (c == ']')) return false;
        }

        return stack.isEmpty();
    }

    private boolean open(char c) {
        return (c == '(' || c == '{' || c == '[');
    }

    // version: 02/12/2020
    public boolean isValid1(String s) {
        if (s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        char i = s.charAt(0);
        if (i == ')' || i == '}' || i == ']') {
            return false;
        }

        for (char c: s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                // open case
                stack.push(c);
            } else {
                // close case
                if (stack.size() == 0) {
                    return false;
                }

                char o = stack.pop();
                if ((c == ')' && o != '(')
                        || (c == '}' && o != '{')
                        || (c == ']' && o != '[')) {
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }
}
