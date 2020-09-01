package com.booknara.problem.stack;

import java.util.Stack;

/**
 * 1209. Remove All Adjacent Duplicates in String II (Medium)
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 */
public class RemoveAllAdjacentDuplicatesInStringII {
    // T:O(n), S:O(n)
    public String removeDuplicates(String s, int k) {
        // input check
        if (s == null || s.length() == 0) return "";
        // 2 <= k

        Stack<Element> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(new Element(c, 1));
            } else {
                Element e = stack.peek();
                if (e.c == c) {
                    stack.pop();
                    if (e.freq + 1 < k) {
                        stack.push(new Element(e.c, e.freq + 1));
                    }
                } else {
                    stack.push(new Element(c, 1));
                }
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            Element e = stack.pop();
            for (int i = 0; i < e.freq; i++) {
                res.append(e.c);
            }
        }

        return res.reverse().toString();
    }

    static class Element {
        char c;
        int freq;
        Element (char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }
}
