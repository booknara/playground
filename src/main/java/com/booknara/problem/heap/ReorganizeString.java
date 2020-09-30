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

    // T:O(n*logn), S:O(m, the distinct number of characters)
    public String reorganizeString1(String S) {
        // input check
        if (S == null || S.length() == 0) return "";

        // Max heap
        PriorityQueue<Element> pq = new PriorityQueue<>((e1, e2) -> {
            return Integer.compare(e2.count, e1.count);
        });

        // n
        int[] bucket = new int[26];
        for (char c: S.toCharArray()) {
            bucket[c - 'a']++;
        }

        // n * logn
        // "abbbc"
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] != 0) {
                pq.offer(new Element(bucket[i], (char)('a' + i)));
            }
        }
        // [1,3,1] -> [2,1] -> [1]
        StringBuilder builder = new StringBuilder();
        while (!pq.isEmpty()) {
            if (pq.size() == 1) {
                if (pq.peek().count >= 2) {
                    return "";
                } else {
                    builder.append(pq.poll().c);
                    return builder.toString();
                }
            }

            // [1,3,1] -> [2,1]
            List<Element> list = new ArrayList<>();
            Element e1 = pq.poll();
            Element e2 = pq.poll();
            builder.append(e1.c);
            builder.append(e2.c);   // babc


            e1.count--;
            e2.count--;
            if (e1.count > 0) {
                list.add(e1);
            }
            if (e2.count > 0) {
                list.add(e2);
            }
            // [1]
            pq.addAll(list);
        }

        return builder.toString();
    }

    static class Element {
        int count;
        char c;
        Element (int count, char c) {
            this.count = count;
            this.c = c;
        }
    }
}
/**
 "abbbc"
 Input: S = "aab"
 Output: "aba"

 Input: S = "abaca" -> true
 Output: ""

 a -> z
 bucket[26]
 [3,1,1] -> [2,0,0] -> [] -> false;

 [1]
 [3,1] -> [2,1] ->
 PriorityQueue Max heap
 two items poll()
 [3,1,1] -> [3] -> [a,2]
 prev = 'a' list = [a,2]
 [2,1,1]
 [1,1] -> b,1
 prev = 'b'
 [2,1] -> [a,1]
 prev = 'a'
 [c,1] -> []
 prev = 'c'
 [a,1] -> []

 true;

 "aab"
 [3,1]->[2] -> return "";
 [2,1]->[1] -> return
 [1,1]->[] ->
 */