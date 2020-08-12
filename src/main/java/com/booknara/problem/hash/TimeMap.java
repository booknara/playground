package com.booknara.problem.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 981. Time Based Key-Value Store (Medium)
 * https://leetcode.com/problems/time-based-key-value-store/
 */
public class TimeMap {
    Map<String, TreeMap<Integer, String>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> tree = map.getOrDefault(key, new TreeMap<>());
        tree.put(timestamp, value);

        map.put(key, tree);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        Integer i = map.get(key).floorKey(timestamp);
        return i == null ? "" : map.get(key).get(i);
    }
}
