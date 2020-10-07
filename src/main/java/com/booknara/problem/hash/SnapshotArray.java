package com.booknara.problem.hash;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 1146. Snapshot Array (Medium)
 * https://leetcode.com/problems/snapshot-array/
 */
public class SnapshotArray {
    // index value history, TreeMap key: snap_id, value: value
    List<TreeMap<Integer, Integer>> history;
    int count = 0;
    public SnapshotArray(int length) {
        history = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            map.put(0, 0);  // initially add '0' by default
            history.add(map);

        }
    }

    public void set(int index, int val) {
        history.get(index).put(count, val);
    }

    public int snap() {
        int cur = count;
        count++;
        return cur;
    }

    public int get(int index, int snap_id) {
        TreeMap<Integer, Integer> map = history.get(index);
        return map.floorEntry(snap_id).getValue();
    }
}
