package com.booknara.problem.list;

import java.util.Iterator;

/**
 * 284. Peeking Iterator (Medium)
 * https://leetcode.com/problems/peeking-iterator/
 */
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Integer last;
    // T:O(1), S:O(1)
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        last = null;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (last == null) {
            last = iterator.next();
        }

        return last;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (last == null) {
            return iterator.next();
        }

        Integer res = last;
        last = null;
        return res;
    }

    @Override
    public boolean hasNext() {
        return (last != null) || iterator.hasNext();
    }
}

//class PeekingIterator implements Iterator<Integer> {
//    LinkedList<Integer> list;
//    public PeekingIterator(Iterator<Integer> iterator) {
//        // initialize any member here.
//        list = new LinkedList<>();
//        while (iterator.hasNext()) {
//            list.addLast(iterator.next());
//        }
//    }
//
//    // Returns the next element in the iteration without advancing the iterator.
//    public Integer peek() {
//        return list.peekFirst();
//    }
//
//    // hasNext() and next() should behave the same as in the Iterator interface.
//    // Override them if needed.
//    @Override
//    public Integer next() {
//        return list.pollFirst();
//    }
//
//    @Override
//    public boolean hasNext() {
//        return !list.isEmpty();
//    }
//}