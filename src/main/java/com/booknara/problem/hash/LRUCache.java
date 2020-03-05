package com.booknara.problem.hash;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146. LRU Cache (Medium)
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCache {
    private Map<Integer, Integer> map;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<Integer, Integer>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int value = map.get(key);
            map.remove(key);
            map.put(key, value);
            return value;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        }

        map.put(key, value);
    }
}
