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

    // T:O(E + V), S:O(E + V)
    public List<String> findItinerary1(List<List<String>> tickets) {
        // input check
        List<String> res = new ArrayList<>();

        if (tickets == null || tickets.size() == 0) return res;

        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> t: tickets) {
            String from = t.get(0);
            String to = t.get(1);

            List<String> des = graph.getOrDefault(from, new ArrayList<>());
            des.add(to);
            graph.put(from, des);
        }

        for (String s: graph.keySet()) {
            // sorting the destinations
            Collections.sort(graph.get(s));
        }

        dfs(graph, "JFK", res);

        return res;
    }

    public boolean dfs(Map<String, List<String>> graph, String start, List<String> list) {
        // base case, no key valud in the map
        if (graph.keySet().size() == 0) {
            list.add(start);
            return true;
        }

        if (!graph.containsKey(start)) {
            // no route further
            return false;
        }

        List<String> des = graph.get(start);
        if (des == null) return false;

        for (int i = 0; i < des.size(); i++) {
            String to = graph.get(start).get(i);
            list.add(start);

            graph.get(start).remove(i);
            if (graph.get(start).size() == 0) graph.remove(start);

            if (dfs(graph, to, list)) return true;

            graph.putIfAbsent(start, new ArrayList<>());
            graph.get(start).add(i, to);

            list.remove(list.size() - 1);
        }

        return false;
    }
}
/**
 [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 from - to

 Map<String, List<String>> = new HashMap<>();
 "JFK" -> "ATL", "SFO",
 "SFO" -> "ATL",
 "ATL" -> "JFK", "SFO",

 "JFK" -> "ATL" -> "JFK" -> "SFO" -> "ATL" -> "SFO"
 -> "SFO" -> "ATL"

 -> "SFO" -> "ATL" -> "JFK"
 */