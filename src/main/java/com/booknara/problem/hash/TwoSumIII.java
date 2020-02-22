package com.booknara.problem.hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Leet code: 170. Two Sum III - Data structure design (Easy)
 * https://leetcode.com/problems/two-sum-iii-data-structure-design/
 */
public class TwoSumIII {
    List<Integer> numbers;
    int min;
    int max;

    /** Initialize your data structure here. */
    public TwoSumIII() {
        numbers = new ArrayList<>();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        numbers.add(number);
        min = Math.min(min, number);
        max = Math.max(max, number);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        if (value < 2 * min || value > 2 * max) {
            return false;
        }

        if (numbers.size() == 1) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (set.contains(numbers.get(i))) {
                return true;
            }

            set.add(value - numbers.get(i));
        }

        return false;
    }
}
