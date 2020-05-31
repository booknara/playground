package com.booknara.problem.graph;

import java.util.*;

/**
 * 399. Evaluate Division (Medium)
 * https://leetcode.com/problems/evaluate-division/
 */
public class EvaluateDivision {
    // T:O(v + e), S:O(v + e)
    public double[] calcEquation(List<List<String>> equations,
                                 double[] values,
                                 List<List<String>> queries) {
        double[] res = new double[queries.size()];
        Arrays.fill(res, -1.0);
        if (equations.size() == 0) {
            return res;
        }

        Map<String, List<Vertex>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> edge = equations.get(i);
            double v = values[i];

            List<Vertex> list1 = graph.getOrDefault(edge.get(0), new ArrayList<>());
            list1.add(new Vertex(edge.get(1), v));
            graph.put(edge.get(0), list1);

            List<Vertex> list2 = graph.getOrDefault(edge.get(1), new ArrayList<>());
            list2.add(new Vertex(edge.get(0), 1 / v));
            graph.put(edge.get(1), list2);
        }

        for (int i = 0; i < queries.size(); i++) {
            List<String> list = queries.get(i);
            if (!graph.containsKey(list.get(0)) || !graph.containsKey(list.get(1))) {
                // non-existed vertex
                res[i] = -1.0;
            } else if (list.get(0).equals(list.get(1))) {
                // self point vertex
                res[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                res[i] = dfs(graph, visited, list.get(0), list.get(1), 1.0);
            }
        }

        return res;
    }

    public double dfs(Map<String, List<Vertex>> graph,
                      Set<String> visited,
                      String start,
                      String end,
                      double value) {
        if (start.equals(end)) return value;

        // cycle and can't reach to the end
        if (visited.contains(start)) return -1;

        visited.add(start);

        // non-existed vertex
        if (!graph.containsKey(start)) return -1;

        for (Vertex edge: graph.get(start)) {
            double res = dfs(graph, visited, edge.node, end, value * edge.weight);
            if (res != -1) {
                return res;
            }
        }

        return -1.0;
    }

    class Vertex {
        String node;
        double weight;

        Vertex(String node, double weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "node=" + node +
                    ", weight=" + weight +
                    '}';
        }
    }
}
