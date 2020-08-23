package com.booknara.problem.topological;

import java.util.*;

/**
 * 269. Alien Dictionary (Hard)
 * https://leetcode.com/problems/alien-dictionary/
 */
public class AlienDictionary {
    // T:O(c, the total number of characters in the words), S:O(1)
    public String alienOrder(String[] words) {
        if (words.length == 0) return "";
        if (words.length == 1) return words[0];

        // only lower case
        int[] inDegree = new int[26];
        Arrays.fill(inDegree, -1);
        Map<Character, List<Character>> graph = new HashMap<>();
        for (String w: words) {
            for (char c: w.toCharArray()) {
                inDegree[c - 'a'] = 0;
                if (!graph.containsKey(c)) {
                    graph.put(c, new ArrayList<>());
                }
            }
        }

        for (int i = 1; i < words.length; i++) {
            // compare words[i - 1] vs words[i]
            int j = 0;
            int len = Math.min(words[i - 1].length(), words[i].length());
            while (j < len) {
                if (words[i - 1].charAt(j) != words[i].charAt(j)) {
                    char out = words[i - 1].charAt(j);
                    char in = words[i].charAt(j);
                    List<Character> list = graph.get(out);
                    list.add(in);
                    graph.put(out, list);
                    inDegree[in - 'a']++;
                    break;
                }

                // edge case: "abc", "ab" -> invalid
                if (j + 1 == len && words[i - 1].length() > words[i].length()) {
                    return "";
                }

                j++;
            }
        }

        /**
         out -> in
         t -> f
         w -> e
         r -> t
         e -> r
         indegree array(26) = [-1,-1,...]
          e,f,r,t,w
         [1,1,1,1,0] -> [0,1,1,1,0] -> [0,1,0,1,0] -> [0,1,0,0,0] -> [0,0,0,0,0]
         */
        StringBuilder builder = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.offer((char) (i + 'a'));
            }
        }

        // q = {w}
        while (!q.isEmpty()) {
            char c = q.poll();
            builder.append(c);
            List<Character> nei = graph.get(c);
            for (char n: nei) {
                inDegree[n - 'a']--;
                if (inDegree[n - 'a'] == 0) {
                    q.offer(n);
                }
            }
        }

        return builder.length() == graph.size() ? builder.toString() : "";
    }
}
/**
 There is a new alien language which uses the latin alphabet.
 However, the order among letters are unknown to you.
 You receive a list of "non-empty words" from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.
 Input:
 [
 "wrt",
 "wrf",
 "er",
 "ett",
 "rftt"
 ]
 Output: "wertf"

 t -> f
 w -> e
 r -> t
 e -> r

 w -> e -> r -> t -> f

 Map<Character, List<Character>> graph = new HashMap<>();
 indegree array =
 w,e,r,t,f
 [0,1,1,1,1] -> [0,0,1,1,1] -> [0,0,0,1,1] -> [0,0,0,0,1] -> [0,0,0,0,0]
 Queue<Character> q = new LinkedList<>();
 q = {w} -> {e} -> {r} -> {t} -> {f}

 if StringBuilder.size() == graph.size() ? builder.toString() : ""
 */