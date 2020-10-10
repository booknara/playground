package com.booknara.problem.stack;

import java.util.Stack;

/**
 * 1003. Check If Word Is Valid After Substitutions (Medium)
 * https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/
 */
public class CheckIfWordIsValidAfterSubstitutions {
    // T:O(n), S:O(n)
    public boolean isValid(String S) {
        // input check
        if (S == null || S.length() == 0) return true;
        // Assume S only contains 'a', 'b', 'c'

        Stack<Character> stack = new Stack<>();
        for (char c: S.toCharArray()) {
            stack.push(c);

            if (c == 'c') {
                if (stack.size() < 3) return false;
                char one = stack.pop(); // c
                char two = stack.pop();
                char three = stack.pop();
                if (two != 'b' || three != 'a') return false;
            }
        }

        return stack.isEmpty();
    }

    public boolean isValid1(String S) {
        // input check
        if (S == null || S.length() == 0) return true;
        // Assume S only contains 'a', 'b', 'c'

        Stack<Character> stack = new Stack<>();
        for (char c: S.toCharArray()) {
            stack.push(c);
            while (stack.size() >= 3 && stack.peek() == 'c') {
                char one = stack.pop();
                char two = stack.pop();
                char three = stack.pop();
                StringBuilder builder = new StringBuilder();
                builder.append(three);
                builder.append(two);
                builder.append(one);
                if (!builder.toString().equals("abc")) {
                    stack.push(three);
                    stack.push(two);
                    stack.push(one);
                    break;
                }
            }
        }

        return stack.isEmpty();
    }
}
