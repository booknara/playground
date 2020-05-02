package com.booknara.problem.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 945. Minimum Increment to Make Array Unique (Medium)
 * https://leetcode.com/problems/minimum-increment-to-make-array-unique/
 */
public class MinimumIncrementToMakeArrayUnique {
    // T: O(nlogn), S: O(1) if in-place sort
    public int minIncrementForUnique(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        Arrays.sort(A);
        int res = 0, prev = A[0];
        for (int i = 1; i < A.length; i++) {
            int expected = prev + 1;
            if (A[i] < expected) {
                res += expected - A[i];
            }
            prev = Math.max(A[i], expected);
        }

        return res;
    }

    // NOT Accepted, Time exceed
    public int minIncrementForUnique1(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int n: A) {
            int count = map.getOrDefault(n, 0);
            map.put(n, count + 1);
        }

        int res = 0;
        for (int n: A) {
            if (map.get(n) == 1) {
                // Unique number
                continue;
            }

            int temp = n;
            temp++;
            int inc = 1;
            while (map.containsKey(temp)) {
                temp++;
                inc++;
            }

            map.put(n, map.get(n) - 1);
            map.put(temp, 1);
            res += inc;
        }

        return res;
    }
}
