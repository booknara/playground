package com.booknara.problem.list;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * First Unique Number
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3313/
 */
// LinkedHashSet, Map
class FirstUnique {
    Set<Integer> set;
    Map<Integer, Integer> map;
    public FirstUnique(int[] nums) {
        set = new LinkedHashSet<>();
        map = new HashMap<>();
        for (int n: nums) {
            add(n);
        }
    }

    public int showFirstUnique() {
        if (set.size() == 0) {
            return -1;
        }
        return set.iterator().next();
    }

    public void add(int value) {
        int count = map.getOrDefault(value, 0);
        if (count == 0) {
            set.add(value);
        } else {
            set.remove(value);
        }

        map.put(value, count + 1);
    }
}

// Doubly-linked list and Map
//class FirstUnique {
//    private final ListNode head = new ListNode(999);
//    private final ListNode tail = new ListNode(999);
//
//    // Key: value, Value: ListNode of Key
//    private final Map<Integer, ListNode> map;
//    private int nodesCount;
//
//    public FirstUnique(int[] nums) {
//        this.map = new HashMap<>();
//        head.next = tail;
//        tail.previous = head;
//        this.nodesCount = 0;
//
//        for (int i: nums) {
//            add(i);
//        }
//    }
//
//    public int showFirstUnique() {
//        if (isEmpty()) return -1;
//        return head.next.value;
//    }
//
//    public void add(int value) {
//        if (map.containsKey(value)) {
//            ListNode node = map.get(value);
//            deleteNode(node);
//        } else {
//            ListNode newNode = new ListNode(value);
//            map.put(value, newNode);
//            insertAtTheTail(newNode);
//        }
//    }
//
//    private void deleteNode(ListNode node) {
//        ListNode next = node.next;
//        ListNode previous = node.previous;
//        if (previous != null && next != null) {
//            previous.next = next;
//            next.previous = previous;
//            node.next = null;
//            node.previous = null;
//            nodesCount--;
//        }
//    }
//
//    private void insertAtTheTail(ListNode newNode) {
//        ListNode previous = tail.previous;
//        newNode.previous = previous;
//        previous.next = newNode;
//        newNode.next = tail;
//        tail.previous = newNode;
//        nodesCount++;
//    }
//
//    private boolean isEmpty() {
//        return nodesCount == 0;
//    }
//
//    class ListNode {
//        final int value;
//        ListNode next;
//        ListNode previous;
//
//        ListNode(int value) {
//            this.value = value;
//        }
//    }
//}