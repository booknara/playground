package com.booknara.problem.hash;
/**
 * 705. Design HashSet (Easy)
 * https://leetcode.com/problems/design-hashset/
 */
class MyHashSet {
    final int BUCKET_SIZE = 1000001;
    boolean[] bucket;
    /** Initialize your data structure here. */
    public MyHashSet() {
        bucket = new boolean[BUCKET_SIZE];
    }

    public void add(int key) {
        bucket[key] = true;
    }

    public void remove(int key) {
        bucket[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return bucket[key];
    }
}
