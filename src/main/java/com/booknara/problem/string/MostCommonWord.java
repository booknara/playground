package com.booknara.problem.string;

import java.util.*;

/**
 * 819. Most Common Word (Easy)
 * https://leetcode.com/problems/most-common-word/
 */
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph == null || paragraph.length() == 0) {
            return "";
        }

        Set<String> bans = new HashSet<>(Arrays.asList(banned));

        StringBuilder builder = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        paragraph = paragraph + ".";    // single word paragraph
        for (char c: paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                builder.append(c);
            } else {
                if (builder.length() > 0) {
                    String w = builder.toString().toLowerCase();
                    if (!bans.contains(w)) {
                        map.put(w, map.getOrDefault(w, 0) + 1);
                    }

                    builder.setLength(0);
                }
            }
        }

        int max = 0;
        String res = "";
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                res = entry.getKey();
            }
        }

        return res;
    }

    public String mostCommonWord1(String paragraph, String[] banned) {
        if (paragraph == null || paragraph.length() == 0) {
            return "";
        }

        Set<String> bans = new HashSet<>(Arrays.asList(banned));

        StringBuilder builder = new StringBuilder();
        for (char c: paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                builder.append(c);
            } else {
                builder.append(' ');
            }
        }

        System.out.println(builder.toString());
        Map<String, Integer> map = new HashMap<>();
        String[] words = builder.toString().split(" ");
        for (String w: words) {
            if (w.trim().length() == 0) continue;
            if (bans.contains(w.toLowerCase())) continue;

            map.put(w.toLowerCase(), map.getOrDefault(w.toLowerCase(), 0) + 1);
        }

        int max = 0;
        String res = "";
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                res = entry.getKey();
            }
        }

        return res;
    }
}
