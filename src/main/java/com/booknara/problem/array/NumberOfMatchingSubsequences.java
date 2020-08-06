package com.booknara.problem.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 792. Number of Matching Subsequences (Medium)
 * https://leetcode.com/problems/number-of-matching-subsequences/
 */
public class NumberOfMatchingSubsequences {
    // T:O(S.length + sum of words.length), S:O(words.length)
    public int numMatchingSubseq(String S, String[] words) {
        // input check

        List<List<Node>> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add(new ArrayList<>());
        }

        for (String w: words) {
            List<Node> nodes = list.get(w.charAt(0) - 'a');
            nodes.add(new Node(w, 0));
        }

        int count = 0;
        for (char c: S.toCharArray()) {
            List<Node> nodes = list.get(c - 'a');
            list.set(c - 'a', new ArrayList<>());

            for (Node n: nodes) {
                n.index++;
                if (n.index == n.s.length()) {
                    count++;
                } else {
                    list.get(n.s.charAt(n.index) - 'a').add(new Node(n.s, n.index));
                }
            }
        }

        return count;
    }

    static class Node {
        String s;
        int index;
        Node(String s, int index) {
            this.s = s;
            this.index = index;
        }
    }

    public int numMatchingSubseq1(String S, String[] words) {
        // input check
        Map<String, Integer> map = new HashMap<>();
        for (String w: words) {
            int c = map.getOrDefault(w, 0);
            map.put(w, c + 1);
        }
        int count = 0;
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (subsequence(S, entry.getKey())) {
                count += entry.getValue();
            }
        }

        return count;
    }

    public boolean subsequence(String s, String w) {
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == w.charAt(idx)) {
                idx++;
            }

            if (idx == w.length()) return true;
        }

        return false;
    }
}
