package com.booknara.problem.list;

import java.util.HashMap;
import java.util.Map;

/**
 * 432. All O`one Data Structure (Hard)
 * https://leetcode.com/problems/all-oone-data-structure/
 */
public class AllOne {
    Map<String, Node> map;
    Node head, tail;
    /** Initialize your data structure here. */
    public AllOne() {
        map = new HashMap<>();
        head = null;
        tail = null;
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        Node n = map.get(key);
        if (n == null) {
            n = new Node(key);
            map.put(key, n);
        }
        n.count++;
        if (head == null) {
            head = n;
            tail = n;
        } else if (n.count == 1) {
            // the first node
            n.right = head;
            head.left = n;
            head = n;
        } else {
            // the middle or tail, move forward
            while (n.right != null && n.count > n.right.count) {
                swap(n, n.right);
            }
        }
    }


    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        Node n = map.get(key);
        if (n == null) return;
        if (n.count == 1) {
            // to delete
            map.remove(key);
            remove(n);
        } else {
            // move backward
            n.count--;
            while (n.left != null && n.left.count > n.count) {
                swap(n.left, n);
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (tail == null) {
            return "";
        }
        return tail.key;
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (head == null) {
            return "";
        }

        return head.key;
    }

    // two new internal methods
    private void swap(Node left, Node right) {
        // pre-left
        if (left.left != null) left.left.right = right;
        // post-right
        if (right.right != null) right.right.left = left;

        Node tempR = right.right;
        right.left = left.left;
        right.right = left;

        left.left = right;
        left.right = tempR;

        // head and tail setting
        if (left == head) head = right;
        if (right == tail) tail = left;
    }

    private void remove(Node n) {
        Node tempL = n.left;
        Node tempR = n.right;

        // Not the first node
        if (tempL != null) tempL.right = tempR;
        // Not the last node
        if (tempR != null) tempR.left = tempL;

        if (n == head) head = tempR;
        if (n == tail) tail = tempL;
    }

    class Node {
        String key;
        int count;
        Node left, right;
        Node(String key) {
            this.key = key;
            this.count = 0;
        }
    }
}
