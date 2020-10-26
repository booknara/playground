package com.booknara.problem.iterator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * 341. Flatten Nested List Iterator (Medium)
 * https://leetcode.com/problems/flatten-nested-list-iterator/
 */
public class NestedIteratorII implements Iterator<Integer> {
    Deque<NestedInteger> dq;

    // T:O(n + m), S:O(n + m)
    public NestedIteratorII(List<NestedInteger> nestedList) {
        dq = new ArrayDeque<>();
        // [1,[4,[6]]]
        for (NestedInteger n: nestedList) {
            dq.addLast(n);
        }

        // 1, [4,[6]]
        while (!dq.isEmpty() && !dq.peekFirst().isInteger()) {
            List<NestedInteger> list = dq.pollFirst().getList();
            for (int i = list.size() - 1; i >= 0; i--) {
                dq.addFirst(list.get(i));
            }
        }
    }

    @Override
    public Integer next() {
        // 1
        int val = dq.pollFirst().getInteger();

        //System.out.println(val);
        // [4,[6]] -> 4,[6]
        while (!dq.isEmpty() && !dq.peekFirst().isInteger()) {
            List<NestedInteger> list = dq.pollFirst().getList();
            for (int i = list.size() - 1; i >= 0; i--) {
                dq.addFirst(list.get(i));
            }
        }

        return val;
    }

    @Override
    public boolean hasNext() {
        return !dq.isEmpty();
    }
}
