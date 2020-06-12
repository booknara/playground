package com.booknara.problem.hash;

import java.util.*;

/**
 * 380. Insert Delete GetRandom O(1) (Medium)
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 */
public class InsertDeleteGetRandom {
    List<Integer> list;
    // Key: Value, Value: list index
    Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public InsertDeleteGetRandom() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);
        if (index < list.size() - 1) {
            // replace a deleted element with the last position element
            int lastValue = list.get(list.size() - 1);
            list.set(index, lastValue);
            map.put(lastValue, index);
        }
        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int size = list.size();
        //System.out.println(size);
        return list.get(new Random().nextInt(size));
    }
}
