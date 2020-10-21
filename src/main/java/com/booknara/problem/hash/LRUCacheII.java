package com.booknara.problem.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU Cache (Medium)
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCacheII {
    Map<Integer, Node> map;
    Node head;
    Node end;
    int capacity;

    public LRUCacheII(int capacity) {
        this.map = new HashMap<>();
        this.head = null;
        this.end = null;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node n = map.get(key);
        int res = n.value;
        remove(n);
        addToTop(n);
        return res;
    }

    public void put(int key, int value) {
        // if the key exists, update, Otherwise add
        if (map.containsKey(key)) {
            // update
            Node n = map.get(key);
            n.value = value;
            map.put(key, n);
            remove(n);
            addToTop(n);
        } else {
            Node n = new Node(key, value);
            map.put(key, n);
            addToTop(n);
            if (map.size() > capacity) {
                Node e = end;
                int removeKey = e.key;
                map.remove(removeKey);
                remove(e);
            }
        }
    }

    public void remove(Node n) {
        // 3 cases
        if (head == n) {
            // head remove
            head = head.next;
            if (head != null) head.prev = null;
        } else if (end == n) {
            // end remove
            end = end.prev;
            end.next = null;
        } else {
            // middle remove
            Node prev = n.prev;
            Node next = n.next;
            prev.next = next;
            next.prev = prev;
        }
    }

    public void addToTop(Node n) {
        if (head == null) {
            // head is null, initial time
            head = n;
            end = n;
        } else {
            n.next = head;
            head.prev = n;
            head = n;
        }
    }

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
