package com.booknara.problem.hash;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * 460. LFU Cache (Hard)
 * https://leetcode.com/problems/lfu-cache/
 */
public class LFUCache {
    Map<Integer, Integer> values;
    Map<Integer, Integer> counters;
    Map<Integer, Set<Integer>> frequencies;

    int capacity;
    int min;

    public LFUCache(int capacity) {
        values = new HashMap<>();
        counters = new HashMap<>();
        frequencies = new HashMap<>();
        frequencies.put(1, new LinkedHashSet<>());

        this.capacity = capacity;
        this.min = 1;
    }

    public int get(int key) {
        if (!values.containsKey(key)) {
            return -1;
        }

        Integer c = counters.get(key);
        counters.put(key, c + 1);
        frequencies.get(c).remove(key);
        if (c == min && frequencies.get(c).size() == 0) {
            min++;
        }

        if (!frequencies.containsKey(c + 1)) {
            frequencies.put(c + 1, new LinkedHashSet<>());
        }

        frequencies.get(c + 1).add(key);

        return values.get(key);
    }

    public void put(int key, int value) {
        if (capacity < 1) {
            return;
        }

        if (values.containsKey(key)) {
            get(key);
            values.put(key, value);
            return;
        }

        if (values.size() == capacity) {
            // Find victim
            Integer evict = frequencies.get(min).iterator().next();
            frequencies.get(min).remove(evict);
            counters.remove(evict);
            values.remove(evict);
        }

        counters.put(key, 1);
        min = 1;
        frequencies.get(1).add(key);
        values.put(key, value);
    }
}
