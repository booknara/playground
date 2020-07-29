package com.booknara.problem.heap;

import java.util.*;

/**
 * 767. Reorganize String (Medium)
 * https://leetcode.com/problems/reorganize-string/
 */
public class ReorganizeString {
    // T:O(n), S:O(m, the distinct number of characters)
    public String reorganizeString(String S) {
        // input check, the length of s is in range [1, 500]
        Map<Character, Integer> map = new HashMap<>();
        for (char c: S.toCharArray()) {
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }

        // max heap
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((e1, e2) -> {
            return Integer.compare(e2.getValue(), e1.getValue());
        });

        pq.addAll(map.entrySet());

        char last = '0';
        StringBuilder builder = new StringBuilder();

        while (!pq.isEmpty()) {
            List<Map.Entry<Character, Integer>> list = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                if (pq.isEmpty()) {
                    break;
                }

                Map.Entry<Character, Integer> entry = pq.poll();
                if (last == entry.getKey()) {
                    return "";
                }

                last = entry.getKey();
                builder.append(last);
                entry.setValue(entry.getValue() - 1);

                if (entry.getValue() > 0) {
                    list.add(entry);
                }
            }

            pq.addAll(list);
        }

        return builder.toString();
    }

    public String reorganizeString1(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }

        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c: S.toCharArray()) {
            //System.out.println(c);
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
            max = Math.max(max, count + 1);
        }

        if (max == 1) {
            return S;
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((entry1, entry2) -> {
            return entry2.getValue() - entry1.getValue();
        });

        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            pq.add(entry);
        }

        StringBuilder builder = new StringBuilder();
        while (pq.size() >= 2) {
            Map.Entry<Character, Integer> entry1 = pq.poll();
            Map.Entry<Character, Integer> entry2 = pq.poll();

            builder.append(entry1.getKey());
            builder.append(entry2.getKey());
            if (entry1.getValue() - 1 != 0) {
                entry1.setValue(entry1.getValue() - 1);
                pq.add(entry1);
            }

            if (entry2.getValue() - 1 != 0) {
                entry2.setValue(entry2.getValue() - 1);
                pq.add(entry2);
            }
        }

        if (pq.size() > 0) {
            Map.Entry<Character, Integer> last = pq.poll();
            if (last.getValue() != 1) return "";
            builder.append(last.getKey());
        }

        return builder.toString();
    }
}
