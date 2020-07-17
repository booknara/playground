package com.booknara.problem.heap;

import java.util.*;

/**
 * 692. Top K Frequent Words (Medium)
 * https://leetcode.com/problems/top-k-frequent-words/
 */
public class TopKFrequentWords {
    // T:O(nlogk), S:(n)
    public List<String> topKFrequent(String[] words, int k) {
        LinkedList<String> res = new LinkedList<>();
        if (words == null || words.length == 0) return res;

        // get words frequency
        Map<String, Integer> map = new HashMap<>();
        for (String w: words) {
            int c = map.getOrDefault(w, 0);
            map.put(w, c + 1);
        }

        // Min heap
        Queue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((e1, e2) -> {
            if (e1.getValue() == e2.getValue()) {
                // Note: reverse alphabetical order because for result (min heap & reverse order)
                return e2.getKey().compareTo(e1.getKey());
            }

            return e1.getValue() - e2.getValue();
        });

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // return the result by frequency from highest to lowest
        while (!pq.isEmpty()) {
            res.addFirst(pq.poll().getKey());
        }

        return res;
    }
}
