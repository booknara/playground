package com.booknara.problem.stack;

import java.util.Stack;

public class BasicCalculatorIII {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int num;
        Stack<Integer> nums = new Stack<>();
        Stack<Character> operands = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = Character.getNumericValue(c);
                while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + Character.getNumericValue(s.charAt(i + 1));
                    i++;
                }
                nums.push(num);
                num = 0;
            } else if (c == '(') {
                operands.push(c);
            } else if (c == ')') {
                while (operands.peek() != '(') {
                    nums.push(operation(operands.pop(), nums.pop(), nums.pop()));
                }
                operands.pop(); // remove '('
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!operands.empty() && precedence(c, operands.peek())) {
                    nums.push(operation(operands.pop(), nums.pop(), nums.pop()));
                }

                if (c == '-') {
                    if (nums.isEmpty()) { // case1: 1st non-empty characer is the negative number
                        // To deal with "-1+4*3/3/3": add 0 to num stack if the first char is '-'; -> -1 + 4 => 0-1+4
                        nums.push(0);
                    } else { // case2: 1st non-empty characer in parentheses is the negative number
                        // To deal with "1-(-7)": add 0 to num stack if the first char after '(' is '-'. -> 1-(-7) => 1-(0-7)
                        int index = i - 1;
                        while (index >= 0 && s.charAt(index) == ' ') {
                            index--;
                        }
                        if (s.charAt(index) == '(') {
                            nums.push(0);
                        }
                    }
                }

                operands.push(c);
            }
        }

        while (!operands.isEmpty()) {
            nums.push(operation(operands.pop(), nums.pop(), nums.pop()));
        }

        return nums.pop();
    }

    public int operation(char op, int b, int a) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }

        return 0;
    }

    public boolean precedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') return false; // (, ) handling because they are higher priority than the other operands
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) return false; // *, / handling because they are higher priority than +, -
        return true;
    }
}
