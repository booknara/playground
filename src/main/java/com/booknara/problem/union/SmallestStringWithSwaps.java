package com.booknara.problem.union;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 1202. Smallest String With Swaps (Medium)
 * https://leetcode.com/problems/smallest-string-with-swaps/
 */
public class SmallestStringWithSwaps {
  public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
    // input check
    int n = s.length();
    int[] root = new int[n];
    for (int i = 0; i < n; i++) {
      root[i] = i;
    }

    for (List<Integer> p: pairs) {
      union(root, p.get(0), p.get(1));
    }

    Map<Integer, PriorityQueue<Character>> pq = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int r = find(root, i);
      pq.putIfAbsent(r, new PriorityQueue<>());
      pq.get(r).offer(s.charAt(i));
    }

    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < n; i++) {
      int r = find(root, i);
      builder.append(pq.get(r).poll());
    }

    return builder.toString();
  }

  public int find(int[] root, int node) {
    while (root[node] != node) {
      root[node] = root[root[node]];
      node = root[node];
    }

    return node;
  }

  public void union(int[] root, int node1, int node2) {
    int root1 = find(root, node1);
    int root2 = find(root, node2);
    if (root1 < root2) {
      root[root2] = root1;
    } else {
      root[root1] = root2;
    }
  }
}
