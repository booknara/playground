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

    // O(n^2 * m), n : the number of word list, m : the length of word (Too slow)
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        // Input check
        if (beginWord.equalsIgnoreCase(endWord)) {
            return 0;
        }

        // Key: hot (word)
        Map<String, List<String>> map = new HashMap<>();
        // construct neighbor words
        for (int i = 0; i < wordList.size(); i++) {
            String key = wordList.get(i);
            if (key.equals(endWord)) {
                continue;
            }

            for (int j = 0; j < wordList.size(); j++) {
                if (i == j) {
                    continue;
                }

                String n = wordList.get(j);
                if (isNeighbor(key, n)) {
                    List<String> list = map.getOrDefault(key, new ArrayList<>());
                    list.add(n);
                    map.put(key, list);
                }
            }
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        // check beginWord neighbor
        for (int i = 0; i < wordList.size(); i++) {
            if (isNeighbor(beginWord, wordList.get(i))) {
                queue.offer(wordList.get(i));
                visited.add(wordList.get(i));
            }
        }
        queue.offer(null);
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
                if (s.equals(endWord)) {
                    return depth;
                }

                List<String> list = map.get(s);
                if (list == null || list.isEmpty()) {
                    continue;
                }

                for (String n: list) {
                    if (visited.contains(n)) {
                        continue;
                    }
                    queue.offer(n);
                    visited.add(n);
                }
            }
        }

        return 0;
    }

    private boolean isNeighbor(String s, String t) {
        int len = s.length();
        int diff = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                diff++;
            }

            if (diff > 1) {
                return false;
            }
        }

        return true;
    }
}
