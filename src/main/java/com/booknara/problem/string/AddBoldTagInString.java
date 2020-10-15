package com.booknara.problem.string;

import java.util.Arrays;

/**
 * 616. Add Bold Tag in String (Medium)
 * https://leetcode.com/problems/add-bold-tag-in-string/
 */
public class AddBoldTagInString {
    static final String OPEN_BOLD = "<b>";
    static final String CLOSE_BOLD = "</b>";

    // T:O(n*m*avg(the length of dic), S:O(n)
    public String addBoldTag(String s, String[] dict) {
        if (s == null || s.length() == 0) return "";
        if (dict.length == 0) return s;

        int[] tag = new int[s.length()];
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            for (String d: dict) {
                if (s.startsWith(d, i)) {
                    end = Math.max(end, i + d.length());
                }
            }

            if (i < end) {
                tag[i] = 1;
            }
        }

        boolean open = false;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (tag[i] == 1) {
                if (!open) {
                    // add open tag
                    builder.append(OPEN_BOLD);
                } else {
                    // already have open tage
                }

                open = true;
            } else {
                if (open) {
                    // already opened
                    builder.append(CLOSE_BOLD);
                }

                open = false;
            }

            // the end of string, check it's still open to close

            builder.append(s.charAt(i));
        }

        if (open) {
            builder.append(CLOSE_BOLD);
            open = false;
        }

        return builder.toString();
    }

    // T:O(n*m*avg(the length of dic), S:O(n)
    public String addBoldTag1(String s, String[] dict) {
        // input check
        if (s == null || s.length() == 0) return "";

        boolean[] mark = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int max = 0;
            for (String d: dict) {
                if (s.startsWith(d, i)) {
                    max = Math.max(max, d.length());
                }
            }

            if (max > 0) Arrays.fill(mark, i, i + max, true);
        }

        String startTag = "<b>";
        String endTag = "</b>";
        boolean start = false;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (mark[i]) {
                if (!start) {
                    builder.append(startTag);
                    start = true;
                }
            } else {
                if (start) {
                    builder.append(endTag);
                    start = false;
                }
            }

            builder.append(s.charAt(i));
        }

        if (start) {
            builder.append(endTag);
        }

        return builder.toString();
    }
}
/**
 Input:
 s = "abcxyz123"
 ...   ...
 dict = ["abc","123"]
 Output: "<b>abc</b>xyz<b>123</b>"

 Input:
 s = "aaabbcc"
 ......
 dict = ["aaa","aab","bc"]
 Output: "<b>aaabbc</b>c"

 */