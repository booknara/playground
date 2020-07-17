package com.booknara.problem.hash;

/**
 * 706. Design HashMap (Easy)
 * https://leetcode.com/problems/design-hashmap/
 */
class MyHashMap {
    // T:O(n/k), k: the number of bucket, S:O(k + m), m: the number of unique keys
    Node[] hash;
    /** Initialize your data structure here. */
    public MyHashMap() {
        hash = new Node[1000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int mod = key % hash.length;
        if (hash[mod] == null) {
            hash[mod] = new Node(key, value);
            return;
        }

        Node node = hash[mod];
        Node cur = node;
        Node prev = null;
        while (cur != null) {
            if (cur.key == key) {
                // replace the value
                cur.val = value;
                return;
            }
            prev = cur;
            cur = cur.next;
        }

        prev.next = new Node(key, value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int mod = key % hash.length;
        Node node = hash[mod];
        Node cur = node;
        while (cur != null) {
            if (cur.key == key) {
                return cur.val;
            }
            cur = cur.next;
        }

        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        //System.out.println(key);
        int mod = key % hash.length;
        Node node = hash[mod];
        // no head
        if (node == null) return;

        if (node.key == key) {
            // head match
            hash[mod] = node.next;
            return;
        }

        // after head
        Node cur = node;
        Node prev = null;
        while (cur != null) {
            if (cur.key == key) {
                prev.next = cur.next;
                return;
            }
            prev = cur;
            cur = cur.next;
        }
    }

    static class Node {
        int key;
        int val;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }
}

//class MyHashMap {
//    Integer[] hash;
//    /** Initialize your data structure here. */
//    public MyHashMap() {
//        hash = new Integer[1000001];
//    }
//
//    /** value will always be non-negative. */
//    public void put(int key, int value) {
//        hash[key] = value;
//    }
//
//    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
//    public int get(int key) {
//        if (hash[key] == null) return -1;
//        return hash[key];
//    }
//
//    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
//    public void remove(int key) {
//        hash[key] = null;
//    }
//}
