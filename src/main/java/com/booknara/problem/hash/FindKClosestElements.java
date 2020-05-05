package com.booknara.problem.hash;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * 658. Find K Closest Elements (Medium)
 * https://leetcode.com/problems/find-k-closest-elements/
 */
public class FindKClosestElements {
    // T: O(n), S:O(1)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        LinkedList<Integer> res = new LinkedList<>();
        if (arr == null || arr.length == 0) {
            return res;
        }

        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] < x) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        int i = r - 1;
        int j = r;

        for (int m = 0; m < k; m++) {
            if (i < 0) {
                j++;
            } else if (j > arr.length - 1) {
                i--;
            } else if (Math.abs(x - arr[i]) <= Math.abs(x - arr[j])) {
                i--;
            } else {
                j++;
            }
        }

        for (int m = i + 1; m < j; m++) {
            res.add(arr[m]);
        }

        return res;
    }

    // T: O(nlogn), S:O(n)
    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        LinkedList<Integer> res = new LinkedList<>();
        if (arr == null || arr.length == 0) {
            return res;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            int c = map.getOrDefault(arr[i], 0);
            map.put(arr[i], c + 1);
        }

        for (int i = 0; i < k; i++) {
            Integer floor = map.floorKey(x);
            Integer ceiling = map.ceilingKey(x);
            if (floor == null) {
                res.addLast(ceiling);
                decrease(map, ceiling);
            } else if (ceiling == null) {
                res.addFirst(floor);
                decrease(map, floor);
            } else if (Math.abs(x - floor) <= Math.abs(x - ceiling)) {
                res.addFirst(floor);
                decrease(map, floor);
            } else {
                res.addLast(ceiling);
                decrease(map, ceiling);
            }
        }

        return res;
    }

    private void decrease(TreeMap<Integer, Integer> map, Integer i) {
        int v = map.get(i);
        if (v == 1) {
            map.remove(i);
        } else {
            map.put(i, v - 1);
        }
    }
}
