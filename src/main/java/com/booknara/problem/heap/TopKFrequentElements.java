package com.booknara.problem.heap;

import java.util.*;

/**
 * 347. Top K Frequent Elements (Medium)
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0 || k == 0) {
            return res;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //System.out.println(nums[i]);
            int count = map.getOrDefault(nums[i], 0);
            map.put(nums[i], count + 1);
        }

        // Min Heap
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((entry1, entry2)
                -> entry1.getValue() < entry2.getValue() ? -1 : 1);

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            pq.add(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            res.add(pq.poll().getKey());
        }

        return res;
    }
}
