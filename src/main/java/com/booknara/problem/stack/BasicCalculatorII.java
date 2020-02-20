package com.booknara.problem.stack;

import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char sign = '+';
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num *= 10;
                num += Character.getNumericValue(c);
            }

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                // In case of symbols and last element
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }

                sign = c;
                num = 0;
            }
        }

        int total = 0;
        for (Integer i: stack) {
            total += i;
        }

        return total;
    }
}
