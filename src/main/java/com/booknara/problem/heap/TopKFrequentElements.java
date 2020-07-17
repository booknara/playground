package com.booknara.problem.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 347. Top K Frequent Elements (Medium)
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements {
    // T:O(nlogn), S:O(n)
    public int[] topKFrequent(int[] nums, int k) {
        // input check
        if (nums == null || nums.length == 0) return new int[]{};

        // Key: element, Value: the number of elements
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums) {
            int c = map.getOrDefault(n, 0);
            map.put(n, c + 1);
        }

        // min heap based on value
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((e1, e2) -> {
            return e1.getValue() - e2.getValue();
        });

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // the only k elements remains
        int[] res = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            res[i] = pq.poll().getKey();
            i++;
        }

        return res;
    }
}
