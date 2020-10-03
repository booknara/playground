package com.booknara.problem.dp;

import java.util.*;

/**
 * 140. Word Break II (Hard)
 * https://leetcode.com/problems/word-break-ii/
 */
public class WordBreakII {
    // T:O(n^2 + 2^n + w), w: the number of words
    public List<String> wordBreak(String s, List<String> wordDict) {
        // input check
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }

        Set<Character> stringCharacterSet = new HashSet<>();
        for (char c: s.toCharArray()) {
            stringCharacterSet.add(c);
        }

        Set<Character> wordCharacterSet = new HashSet<>();
        Set<String> wordSet = new HashSet<>();
        for (String w: wordDict) {
            wordSet.add(w);
            for (char c: w.toCharArray()) {
                wordCharacterSet.add(c);
            }
        }

        // quick check whether all the word character set covers all the string character set
        if (!wordCharacterSet.containsAll(stringCharacterSet)) {
            return res;
        }

        Map<Integer, List<String>> dp = new HashMap<>();
        dp.put(0, new ArrayList<>(Arrays.asList("")));

        for (int j = 1; j < s.length() + 1; j++) {
            List<String> list = new ArrayList<>();
            dp.put(j, list);

            for (int i = 0; i < j; i++) {
                String substring = s.substring(i, j);
                if (wordSet.contains(substring)) {
                    for (String sub: dp.get(i)) {
                        list.add((sub + " " + substring).trim());
                    }
                }
            }

            dp.put(j, list);
        }

        return dp.get(s.length());
    }

    public List<String> wordBreak1(String s, List<String> wordDict) {
        // input check, s = non-empty string, wordDict = non-empty list
        Set<String> set = new HashSet<>();
        // Character check
        int[] bucket = new int[128];
        for (String word: wordDict) {
            for (char c: word.toCharArray()) {
                bucket[c]++;
            }

            set.add(word);
        }

        for (char c: s.toCharArray()) {
            // a character in s not present in wordDict
            if (bucket[c] == 0) {
                return new ArrayList<>();
            }
        }

        Map<Integer, List<String>> map = new HashMap<>();
        map.put(0, new ArrayList<>());

        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(i)) continue;

            for (int j = i; j < n; j++) {
                String sub = s.substring(i, j + 1);
                if (set.contains(sub)) {
                    // get the previous i th list
                    List<String> cur = new ArrayList<>();
                    if (i == 0) {
                        cur.add(sub);
                    } else {
                        List<String> prev = map.get(i);
                        for (String str: prev) {
                            cur.add(str + " " + sub);
                        }
                    }

                    List<String> list = map.getOrDefault(j + 1, new ArrayList<>());
                    list.addAll(cur);
                    map.put(j + 1, list);
                }
            }
        }

        return map.containsKey(n) ? map.get(n) : new ArrayList<>();
    }

    // Backtracking, TLE
    public List<String> wordBreak2(String s, List<String> wordDict) {
        // input check
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }

        Set<String> set = new HashSet<>(wordDict);

        search(s, 0, new StringBuilder(), set, res);
        return res;
    }

    public void search(String s,
                       int index,
                       StringBuilder builder,
                       Set<String> set,
                       List<String> res) {
        // base case
        if (index == s.length()) {
            res.add(builder.substring(0, builder.length() - 1));
            return;
        }

        for (int i = index + 1; i <= s.length(); i++) {
            String substring = s.substring(index, i);
            if (set.contains(substring)) {
                StringBuilder b = new StringBuilder(builder);
                b.append(substring).append(" ");
                search(s, i, b, set, res);
            }
        }
    }
}
