package com.booknara.problem.stack;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
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
