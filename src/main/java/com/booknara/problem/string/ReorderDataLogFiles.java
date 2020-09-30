package com.booknara.problem.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 937. Reorder Data in Log Files (Easy)
 * https://leetcode.com/problems/reorder-data-in-log-files/
 */
public class ReorderDataLogFiles {
    // T:O(m*logm), m is the length of letter logs, S:O(n)
    public String[] reorderLogFiles(String[] logs) {
        if (logs == null || logs.length <= 1) {
            return logs;
        }

        List<String> letters = new ArrayList<>();
        List<String> digits = new ArrayList<>();
        for (String s: logs) {
            int idx = s.indexOf(" ");
            if (Character.isDigit(s.charAt(idx + 1))) {
                digits.add(s);
            } else {
                letters.add(s);
            }
        }

        // Sorting rule
        // 1. letter-log lexicographically ignoring the identifier, with the identifier in case of ties
        // 2. digit-log with the existing order
        Collections.sort(letters, (a, b) -> {
            int x = a.substring(a.indexOf(" "))
                    .compareTo(b.substring(b.indexOf(" ")));
            if (x == 0) {
                return a.substring(0,a.indexOf(" "))
                        .compareTo(b.substring(0,b.indexOf(" ")));
            }

            return x;
        });

        int i = 0;
        for (String s: letters) {
            logs[i++] = s;
        }
        for (String s: digits) {
            logs[i++] = s;
        }

        return logs;
    }

    // T:O(m*logm), m is the length of letter logs, S:O(n)
    public String[] reorderLogFiles1(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            // -1: log1, log2
            // 1: log2, log1
            // 0: not change
            Element e1 = new Element(log1);
            Element e2 = new Element(log2);

            // both letters
            if ((e1.str.charAt(0) >= 'a' && e1.str.charAt(0) <= 'z')
                    && (e2.str.charAt(0) >= 'a' && e2.str.charAt(0) <= 'z')) {
                if (e1.str.equals(e2.str)) {
                    // id compare
                    return e1.id.compareTo(e2.id);
                }

                // str compare
                return e1.str.compareTo(e2.str);
            }

            // number, letter -> letter, number
            if (Character.isDigit(e1.str.charAt(0)) && (e2.str.charAt(0) >= 'a' && e2.str.charAt(0) <= 'z')) {
                return 1;
            }

            // letter, number -> letter, number
            if ((e1.str.charAt(0) >= 'a' && e1.str.charAt(0) <= 'z') && Character.isDigit(e2.str.charAt(0))) {
                return -1;
            }

            // both numbers
            if (Character.isDigit(e1.str.charAt(0)) && Character.isDigit(e2.str.charAt(0))) {
                return 0;
            }

            return 0;
        });

        return logs;
    }

    static class Element {
        String id;
        String str;
        Element (String input) {
            int idx = input.indexOf(" ");
            this.id = input.substring(0, idx);
            this.str = input.substring(idx + 1);
        }

        @Override
        public String toString() {
            return "Element{" +
                    "id='" + id + '\'' +
                    ", str='" + str + '\'' +
                    '}';
        }
    }
}
