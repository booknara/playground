package com.booknara.problem.stack;

import java.util.Stack;

/**
 * 155. Min Stack (Easy)
 * https://leetcode.com/problems/min-stack/
 */
public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            int min = minStack.peek();
            if (min < x) {
                minStack.push(min);
            } else {
                minStack.push(x);
            }
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    // 3/20/2020 version
//    class Element {
//        int val;
//        int min;
//
//        Element(int val, int min) {
//            this.val = val;
//            this.min = min;
//        }
//    }
//
//    Stack<Element> stack;
//    int totalMin;
//
//    /** initialize your data structure here. */
//    public MinStack() {
//        stack = new Stack<>();
//    }
//
//    public void push(int x) {
//        Element e;
//        if (stack.empty()) {
//            e = new Element(x, x);
//            totalMin = x;
//        } else {
//            totalMin = Math.min(totalMin, x);
//            e = new Element(x, totalMin);
//        }
//
//        stack.push(e);
//    }
//
//    public void pop() {
//        stack.pop();
//        if (!stack.empty()) {
//            totalMin = stack.peek().min;
//        }
//    }
//
//    public int top() {
//        return stack.peek().val;
//    }
//
//    public int getMin() {
//        return stack.peek().min;
//    }
}
