package com.booknara.problem.stack;

import java.util.Stack;

public class MinStack {
    class Element {
        int val;
        int min;

        Element(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    Stack<Element> stack;
    int totalMin;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        Element e;
        if (stack.empty()) {
            e = new Element(x, x);
            totalMin = x;
        } else {
            totalMin = Math.min(totalMin, x);
            e = new Element(x, totalMin);
        }

        stack.push(e);
    }

    public void pop() {
        stack.pop();
        if (!stack.empty()) {
            totalMin = stack.peek().min;
        }
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }
}
