package com.booknara.problem.stack;

import java.util.Stack;

/**
 * 1047. Remove All Adjacent Duplicates In String (Easy)
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 */
public class RemoveAllAdjacentDuplicatesInString {
    // T:O(n), S:O(n)
    public String removeDuplicates(String S) {
        if (S == null || S.length() <= 1) return S;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            if (stack.peek() != c) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }
}
/**
 Input: "abbaca"
 Output: "ca"

 c -> a
 */