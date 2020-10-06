package com.booknara.problem.stack;

import java.util.Stack;

/**
 * 946. Validate Stack Sequences (Medium)
 * https://leetcode.com/problems/validate-stack-sequences/
 */
public class ValidateStackSequences {
    // T:O(n), S:O(n)
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // input
        if (pushed.length == 0 && popped.length == 0) return true;
        if (pushed.length != popped.length) return false;

        Stack<Integer> stack = new Stack<>();
        int index = 0;
        // Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);  // [], index = 5

            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }

        return stack.isEmpty();
    }
}
/**
 Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 Output: true
 Explanation: We might do the following sequence:
 push(1), push(2), push(3), push(4), pop() -> 4,
 push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1

 pushed.length() != popped.length -> false

 Input: pushed = [1,2,3,4,5], popped = [3,2,1] : Queue
 [1,2]
 stack -> push()
 while (stack.peek() == q.peek()) {
 stack.pop();
 index++;
 }

 return stack.isEmpty()
 */