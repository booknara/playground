package com.booknara.problem.graph;

import java.util.*;

/**
 * 332. Reconstruct Itinerary (Medium)
 * https://leetcode.com/problems/reconstruct-itinerary/
 */
public class ReconstructItinerary {
    // input : list of list string(from, to)
    // output : list (itinerary)
    // T:O(E*logE/V), S:O(E + V)
    public List<String> findItinerary(List<List<String>> tickets) {
        // input check : ticket is not null or empty
        // 1. create map for ticket
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> t: tickets) {
            String from = t.get(0);
            String to = t.get(1);
            PriorityQueue<String> pq = map.getOrDefault(from, new PriorityQueue<>());
            pq.add(to);
            map.put(from, pq);
        }

        LinkedList<String> res = new LinkedList<>();
        dfs("JFK", map, res);

        return res;
    }

    // Bottom up dfs
    public void dfs(String start, Map<String, PriorityQueue<String>> map, LinkedList<String> res) {
        PriorityQueue<String> pq = map.get(start);

        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll(), map, res);
        }

        // if there is no flight heading to, add string here
        res.addFirst(start);
    }
}
