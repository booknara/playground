package com.booknara.problem.list;

import java.util.*;

/**
 * 380. Insert Delete GetRandom O(1) (Medium)
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 */
public class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public RandomizedSet() {
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
        // case 1: not the last index
        if (index != list.size() - 1) {
            // update the list
            int lastValue = list.get(list.size() - 1);
            list.set(index, lastValue);
            // update the map
            map.replace(lastValue, index);
        }
        // case 2: the last index
        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int random = new Random().nextInt(list.size());
        return list.get(random);
    }
}
/**
 [1,2] -> [2], delete 1

 [
 1:0,
 2:1
 ]

 1. get the index value (0)
 2. set the list the index(0) -> the last value[2]
 3. replace the map key, value -> the last value : the index of val[2:0]

 4. remove the last value of list
 5. remove the val from the map
 */

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */