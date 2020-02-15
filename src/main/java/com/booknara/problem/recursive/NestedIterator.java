package com.booknara.problem.recursive;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 341. Flatten Nested List Iterator (Medium)
 * https://leetcode.com/problems/flatten-nested-list-iterator/
 */
public class NestedIterator implements Iterator<Integer> {
    private Queue<Integer> list;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.list = new LinkedList<>();
        for (NestedInteger n: nestedList) {
            getInteger(n);
        }
    }

    @Override
    public Integer next() {
        return list.poll();
    }

    @Override
    public boolean hasNext() {
        return list.size() != 0;
    }

    private void getInteger(NestedInteger integer) {
        if (integer.isInteger()) {
            list.offer(integer.getInteger());
            return;
        }

        List<NestedInteger> list = integer.getList();
        for (NestedInteger n: list) {
            getInteger(n);
        }

        return;
    }
}
