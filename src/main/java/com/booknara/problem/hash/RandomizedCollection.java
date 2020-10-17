package com.booknara.problem.hash;

import java.util.*;

/**
 * 381. Insert Delete GetRandom O(1) - Duplicates allowed (Hard)
 * https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 */
class RandomizedCollection {
    // Key: val, Value: the list of indices
    Map<Integer, Set<Integer>> map;
    List<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res;
        Set<Integer> set;
        if (map.containsKey(val)) {
            res = false;
            // already map has the value
            set = map.get(val);
        } else {
            res = true;
            // the first appearance
            set = new HashSet<>();
        }
        set.add(list.size());
        map.put(val, set);
        list.add(val);

        return res;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        // val -> index set handling
        Set<Integer> set = map.get(val);
        int indexToRemove = set.iterator().next();  // first element
        set.remove(indexToRemove);
        if (set.isEmpty()) {
            map.remove(val);
        }

        // list handling
        if (indexToRemove == list.size() - 1) {
            // the last index
            list.remove(indexToRemove);
        } else {
            int lastValue = list.get(list.size() - 1);
            list.set(indexToRemove, lastValue);

            // last value -> set update
            map.get(lastValue).remove(list.size() - 1);
            map.get(lastValue).add(indexToRemove);

            list.remove(list.size() - 1);
        }


        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        //System.out.println(list.size());
        int random = new Random().nextInt(list.size());     // 0 ~ size() - 1
        return list.get(random);
    }
}
