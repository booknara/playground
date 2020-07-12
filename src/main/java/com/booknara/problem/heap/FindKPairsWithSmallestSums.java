package com.booknara.problem.heap;

import java.util.*;

/**
 * 373. Find K Pairs with Smallest Sums (Medium)
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 */
public class FindKPairsWithSmallestSums {
    // T:O(k*logk) S:O(k)
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        // input check
        if (nums1 == null || nums2 == null || nums1.length * nums2.length == 0 || k == 0) {
            return res;
        }

        int m = nums1.length, n = nums2.length;
//        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> {
//            return Integer.compare(p1[0] + p1[1], p2[0] + p2[1]);
//        });

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p[0] + p[1]));

        // all the nums1 elements - nums2[0], num2 index
        for (int i = 0; i < m && i < k; i++) {
            pq.offer(new int[] {nums1[i], nums2[0], 0});
        }

        while (!pq.isEmpty()) {
            if (res.size() == k) {
                break;
            }

            int[] triple = pq.poll();
            res.add(Arrays.asList(triple[0], triple[1]));
            int prevIndex = triple[2];
            if (prevIndex == nums2.length - 1) {
                // can't increment nums2 index
                continue;
            }

            pq.offer(new int[] {triple[0], nums2[prevIndex + 1], prevIndex + 1});
        }

        return res;
    }
}
