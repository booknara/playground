package com.booknara.problem.hash;

import java.util.*;

/**
 * 350. Intersection of Two Arrays II (Easy)
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
public class IntersectionOfTwoArraysII {
    // T:O(max(m, n)), S:O(min(m, n))
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) return new int[0];
        if (nums2 == null || nums2.length == 0) return new int[0];

        int[] smaller = null;
        int[] longer = null;

        if (nums1.length < nums2.length) {
            smaller = nums1;
            longer = nums2;
        } else {
            smaller = nums2;
            longer = nums1;
        }

        // Key: number, value: count
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: smaller) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int n: longer) {
            if (map.containsKey(n) && map.get(n) > 0) {
                map.put(n, map.get(n) - 1);
                list.add(n);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    // T:O(max(mlogm, nlogn)), S:O(1)
    public int[] intersect1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) return new int[0];
        if (nums2 == null || nums2.length == 0) return new int[0];

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            // Three cases
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] res = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }

        return res;
    }
}
