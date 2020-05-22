package com.booknara.problem.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 451. Sort Characters By Frequency (Medium)
 * https://leetcode.com/problems/sort-characters-by-frequency/
 */
public class SortCharactersByFrequency {
    // Using bucket, T:O(n), S:O(1)
    public String frequencySort(String s) {
        int[] bucket = new int[128];
        for (char c: s.toCharArray()) {
            bucket[c]++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((b1, b2) -> Integer.compare(b2[1], b1[1]));
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] != 0) {
                pq.offer(new int[] {i, bucket[i]});
            }
        }

        StringBuilder builder = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] d = pq.poll();
            for (int i = 0; i < d[1]; i++) {
                int c = d[0];
                builder.append((char) c);
            }
        }

        return builder.toString();
    }

    // Using Map, T:O(n), S:O(1)
    public String frequencySort1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> {
            return a.getValue() < b.getValue() ? 1 : -1;
        });

        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            pq.add(entry);
        }

        StringBuilder builder = new StringBuilder();
        while(!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            char c = entry.getKey();
            int count = entry.getValue();
            for (int j = 0; j < count; j++) {
                builder.append(c);
            }
        }

        return builder.toString();
    }
}
