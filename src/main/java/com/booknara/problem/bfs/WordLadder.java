package com.booknara.problem.bfs;

import java.util.*;

/**
 * 127. Word Ladder (Medium)
 * https://leetcode.com/problems/word-ladder/
 */
public class WordLadder {
    // O(n*m), n : the number of words, m : the length of word
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Input check
        if (beginWord.equalsIgnoreCase(endWord)) {
            return 0;
        }

        // Key: *ot (intermediate word)
        Map<String, List<String>> map = new HashMap<>();
        // construct neighbor words
        int len = beginWord.length();
        for (int i = 0; i < wordList.size(); i++) {
            String key = wordList.get(i);
            for (int j = 0; j < len; j++) {
                String nei = key.substring(0, j) + "*" + key.substring(j + 1, len);
                List<String> list = map.getOrDefault(nei, new ArrayList<>());
                list.add(key);
                map.put(nei, list);
            }
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        queue.offer(null);      // level delimeter
        int depth = 2;

        while (!queue.isEmpty()) {
            String s = queue.poll();
            //System.out.println(s);
            if (s == null) {
                depth++;
                queue.offer(null);
                if (queue.peek() == null) break;
                else continue;
            } else {
                // s : word
                for (int i = 0; i < len; i++) {
                    String newWord = s.substring(0, i) + "*" + s.substring(i + 1, len);
                    List<String> list = map.get(newWord);
                    if (list == null || list.isEmpty()) {
                        continue;
                    }

                    for (String n: list) {
                        if (n.equals(endWord)) {
                            return depth;
                        }
                        if (!visited.contains(n)) {
                            visited.add(n);
                            queue.offer(n);
                        }
                    }
                }
            }
        }

        return 0;
    }

    // T:O(m^2 * n, m: the length of word, n: the size of word list), S:O(m^2)
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) return 1;

        // build a graph
        Map<String, List<String>> graph = new HashMap<>();
        for (String s: wordList) {
            List<String> words = getWildWords(s);
            for (String wild: words) {
                List<String> list = graph.getOrDefault(wild, new ArrayList<>());
                list.add(s);
                graph.put(wild, list);
            }
        }

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        visited.add(beginWord);

        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String s = q.poll();
                if (s.equals(endWord)) return level;

                List<String> nextList = getWildWords(s);
                // nextList = the string contained '*'
                for (String nei: nextList) {
                    if (graph.containsKey(nei)) {
                        List<String> list = graph.get(nei);
                        for (String next: list) {
                            if (visited.contains(next)) continue;

                            q.offer(next);
                            visited.add(next);
                        }

                    }
                }
            }

            level++;
        }

        return 0;
    }

    public List<String> getWildWords(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            StringBuilder builder = new StringBuilder(s);
            builder.setCharAt(i, '*');
            res.add(builder.toString());
        }

        return res;
    }
}
/**
 Input:
 beginWord = "hit",
 endWord = "cog",
 wordList = ["hot","dot","dog","lot","log","cog"]

 Map<String, List<String>> map = new HashMap<>();
 *ot -> [hot,dot,lot]
 h*t -> [hot]
 ho* -> [hot]
 d*t -> [dot]
 do* -> [dot,dog]
 *og -> [dog,log,cog]
 d*g -> [dog]
 l*t -> [lot]
 lo* -> [lot,log]
 l*g -> [log]
 c*g -> [cog]
 *og -> [cog]

 hit - *it
 - h*t
 - hi*
 */
