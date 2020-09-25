package com.booknara.problem.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 341. Flatten Nested List Iterator (Medium)
 * https://leetcode.com/problems/flatten-nested-list-iterator/
 */
public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack;

    // T:O(n + l), n: the number of integers, l: the number of nestedList)
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();

        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }

        makeIntegerOnTop();
    }

    public void makeIntegerOnTop() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            List<NestedInteger> list = stack.pop().getList();
            for (int i = list.size() - 1; i >= 0; i--) {
                stack.push(list.get(i));
            }
        }
    }

    // T:O(n + l), n: the number of integers, l: the number of nestedList)
    @Override
    public Integer next() {
        NestedInteger res = stack.pop();
        makeIntegerOnTop();

        return res.getInteger();
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}