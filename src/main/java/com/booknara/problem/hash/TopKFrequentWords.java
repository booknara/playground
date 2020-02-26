package com.booknara.problem.hash;

import java.util.*;

/**
 * 692. Top K Frequent Words (Medium)
 * https://leetcode.com/problems/top-k-frequent-words/
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();
        if (words == null || words.length == 0 || k == 0) {
            return ans;
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            //System.out.println(words[i]);
            int count = map.getOrDefault(words[i], 0);
            map.put(words[i], count + 1);
        }

        // Min Heap
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return a.getValue() > b.getValue() ? 1 : -1;
            }

            return b.getKey().compareTo(a.getKey());
        });

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            pq.add(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            ans.add(pq.poll().getKey());
        }

        Collections.reverse(ans);
        return ans;
    }
}
