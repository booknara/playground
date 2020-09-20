package com.booknara.problem.hash;

import java.util.*;

/**
 * 349. Intersection of Two Arrays (Easy)
 * https://leetcode.com/problems/intersection-of-two-arrays/
 */
public class IntersectionOfTwoArrays {
    // T:O(m + n), S:O(m + n)
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) return new int[0];
        if (nums2 == null || nums2.length == 0) return new int[0];

        Set<Integer> set1 = new HashSet<>();
        for (int n: nums1) {
            set1.add(n);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int n: nums2) {
            set2.add(n);
        }

        List<Integer> list = new ArrayList<>();
        for (int n: set1) {
            if (set2.contains(n)) {
                list.add(n);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    // T:O(mlogm + nlogn), S:O(1)
    public int[] intersection1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) return new int[0];
        if (nums2 == null || nums2.length == 0) return new int[0];

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            while (i != 0 && i < nums1.length && nums1[i - 1] == nums1[i]) i++;
            while (j != 0 && j < nums2.length && nums2[j - 1] == nums2[j]) j++;

            if (i == nums1.length) break;
            if (j == nums2.length) break;

            int n1 = nums1[i];
            int n2 = nums2[j];
            if (n1 == n2) {
                list.add(n1);
                i++;
                j++;
            } else if (n1 < n2) {
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
