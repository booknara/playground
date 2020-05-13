package com.booknara.problem.string;

import java.util.ArrayList;
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
}
