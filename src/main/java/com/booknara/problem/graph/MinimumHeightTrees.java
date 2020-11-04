package com.booknara.problem.graph;

import java.util.*;

/**
 * 310. Minimum Height Trees (Medium)
 * https://leetcode.com/problems/minimum-height-trees/
 */
public class MinimumHeightTrees {
    // T:O(V), S:O(V)
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // input check, n >= 1
        List<Integer> leaf = new ArrayList<>();
        if (n == 1) {
            leaf.add(0);
            return leaf;
        }

        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] degree = new int[n];
        for (int[] edge: edges) {
            // bi-directional
            Set<Integer> set1 = map.getOrDefault(edge[0], new HashSet<>());
            set1.add(edge[1]);
            map.put(edge[0], set1);

            Set<Integer> set2 = map.getOrDefault(edge[1], new HashSet<>());
            set2.add(edge[0]);
            map.put(edge[1], set2);

            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        // finding the leaf nodes which is the farthest node from the core node
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                leaf.add(i);
            }
        }

        while (n > 2) {
            int size = leaf.size();
            n -= size;

            for (int i = 0; i < size; i++) {
                int node = leaf.remove(0);  // check the first one and remove
                degree[node] = 0;

                Set<Integer> neighbors = map.get(node);
                for (int nei: neighbors) {
                    map.get(nei).remove(node);
                    degree[nei]--;
                    if (degree[nei] == 1) {
                        leaf.add(nei);
                    }
                }
            }
        }

        return leaf;
    }

    // T:O(V), S:O(V)
    public List<Integer> findMinHeightTrees1(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }

        if (edges == null || edges.length == 0) {
            // no edge case
            for (int i = 0; i < n; i++) res.add(i);
            return res;
        }

        // construct graph
        List<Set<Integer>> graph = constructGraph(edges, n);

        // initial leaf
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        // the answer will be come out when n is 1 or 2
        while (n > 2) {
            n -= leaves.size();

            List<Integer> newLeaves = new ArrayList<>();
            for (Integer i: leaves) {
                Set<Integer> neighbors = graph.get(i);
                for (Integer nei: neighbors) {
                    graph.get(nei).remove(i);
                    if (graph.get(nei).size() == 1) {
                        newLeaves.add(nei);
                    }
                }
            }

            leaves = newLeaves;
        }

        return leaves;
    }

    public List<Set<Integer>> constructGraph(int[][] edges, int n) {
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }

        for (int[] edge: edges) {
            // bi-directional
            // edge[0] -> edge[1]
            // edge[1] -> edge[0]
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return graph;
    }

    // TLE
    public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (edges == null || edges.length == 0) {
            // no edge case
            for (int i = 0; i < n; i++) res.add(i);
            return res;
        }

        // construct graph
        Map<Integer, List<Integer>> graph = constructGraph(edges);
        int totalMin = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            Set<Integer> visited = new HashSet<>();
            int min = getHeight(graph, i, visited);
            //System.out.println(i + ", height:" + min);
            if (min < totalMin) {
                res.clear();
                res.add(i);
                totalMin = min;
            } else if (min == totalMin) {
                res.add(i);
                totalMin = min;
            }
        }

        return res;
    }

    public int getHeight(Map<Integer, List<Integer>> graph, int v, Set<Integer> visited) {
        // base case
        if (visited.contains(v)) return 0;

        visited.add(v);
        List<Integer> list = graph.get(v);
        int h = 0;
        for (Integer i: list) {
            h = Math.max(h, getHeight(graph, i, new HashSet<Integer>(visited)) + 1);
        }

        return h;
    }

    public Map<Integer, List<Integer>> constructGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge: edges) {
            // bi-directional
            // edge[0] -> edge[1]
            // edge[1] -> edge[0]
            List<Integer> list = graph.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            graph.put(edge[0], list);

            list = graph.getOrDefault(edge[1], new ArrayList<>());
            list.add(edge[0]);
            graph.put(edge[1], list);
        }

        return graph;
    }
}
