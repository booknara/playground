package com.booknara.problem.graph;

import java.util.*;

/**
 * 332. Reconstruct Itinerary (Medium)
 * https://leetcode.com/problems/reconstruct-itinerary/
 */
public class ReconstructItinerary {
    LinkedList<String> ans = new LinkedList<>();
    Map<String, PriorityQueue<String>> map = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null || tickets.size() == 0) {
            return ans;
        }

        for (List<String> t: tickets) {
            if (!map.containsKey(t.get(0))) {
                map.put(t.get(0), new PriorityQueue<>());
            }

            PriorityQueue<String> set = map.get(t.get(0));
            set.add(t.get(1));

            map.put(t.get(0), set);
        }

        dfs("JFK");

        return ans;
    }

    public void dfs(String start) {
        PriorityQueue<String> pq = map.get(start);

        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll());
        }

        ans.addFirst(start);
    }
}
