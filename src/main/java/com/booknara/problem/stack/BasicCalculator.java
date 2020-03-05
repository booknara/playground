package com.booknara.problem.stack;

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int num = 0;
        int sign = 1;
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + Character.getNumericValue(c);
            } else if (c == '+') {
                result = result + sign * num;
                sign = 1;
                num = 0;
            } else if (c == '-') {
                result = result + sign * num;
                sign = -1;
                num = 0;
            } else if (c == '(') {
                // push result, sign
                stack.push(result);
                stack.push(sign);
                num = 0;
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result = result + sign * num;
                // push sign, result
                result = result * stack.pop();
                result = result + stack.pop();
                num = 0;
            }
        }

        return result + sign * num;
    }
}