package com.booknara.problem.hash;

import java.util.*;

/**
 * 347. Top K Frequent Elements (Medium)
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements {
    class Pair {
        int num;
        int count;
        Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0);
            map.put(nums[i], count + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> {
            if (a.count < b.count) {
                return -1;
            } else {
                return 1;
            }
        });
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            ans.add(pq.poll().num);
        }

        return ans;
    }
}
