package com.booknara.problem.hash;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146. LRU Cache (Medium)
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCache {
    Map<Integer, Integer> cache;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<Integer, Integer>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                boolean evict = size() > capacity;
                if (evict) {
                    //System.out.println("remove " + eldest.getKey());
                }

                return evict;
            }
        };
    }

    public int get(int key) {
        int res = cache.getOrDefault(key, -1);
        if (res != -1) {
            cache.remove(key);
            cache.put(key, res);
        }

        return res;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        }
        cache.put(key, value);
    }
}
