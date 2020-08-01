package com.booknara.problem.list;

import java.util.LinkedList;

/**
 * 362. Design Hit Counter (Medium)
 * https://leetcode.com/problems/design-hit-counter/
 */
class HitCounter {
    LinkedList<Integer> list;
    public HitCounter() {
        list = new LinkedList<>();
    }

    public void hit(int timestamp) {
        list.addLast(timestamp);
    }

    public int getHits(int timestamp) {
        while (!list.isEmpty() && timestamp - list.peekFirst() >= 300) {
            list.removeFirst();
        }

        return list.size();
    }
}
