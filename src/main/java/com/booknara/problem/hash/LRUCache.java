package com.booknara.problem.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU Cache (Medium)
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCache {
    Map<Integer, Node> map;
    Node head;
    Node end;
    int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.head = null;
        this.end = null;
        this.capacity = capacity;
    }

    public int get(int key) {
        System.out.println(key);
        if (!map.containsKey(key)) {
            return -1;
        }

        // re-arrange doubly linked list
        Node n = map.get(key);
        remove(n);
        addAtTop(n);

        // the key exists
        return map.get(key).val;
    }

    public void put(int key, int value) {
        System.out.println(key + "," + value);
        Node n;
        if (map.containsKey(key)) {
            n = map.get(key);
            n.val = value;
            remove(n);
        } else {
            n = new Node(key, value);
            map.put(key, n);

            if (map.size() > capacity) {
                map.remove(end.key);
                remove(end);
            }
        }

        addAtTop(n);
    }

    public void remove(Node node) {
        // if the node is the first node
        if (node.prev == null) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }

        // if the node is the last node
        if (node.next == null) {
            end = node.prev;
        } else {
            node.next.prev = node.prev;
        }
    }

    public void addAtTop(Node node) {
        node.prev = null;

        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }

        if (end == null) {
            end = head;
        }
    }

    static class Node {
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
