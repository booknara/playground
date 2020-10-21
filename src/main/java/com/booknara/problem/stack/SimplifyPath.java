package com.booknara.problem.stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 71. Simplify Path (Medium)
 * https://leetcode.com/problems/simplify-path/
 */
public class SimplifyPath {
    // T:O(n), S:O(n)
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return path;
        }

        LinkedList<String> list = new LinkedList<>();
        String[] patterns = path.split("/");
        for (String s: patterns) {
            if (s.length() != 0) {
                // System.out.println(s);
                // Three cases
                if (s.equals(".")) {
                    // Nothing
                } else if (s.equals("..")) {
                    // go up to parent if available
                    if (!list.isEmpty()) list.pollLast();
                } else {
                    // add a path
                    list.addLast(s);
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        while (!list.isEmpty()) {
            builder.append("/" + list.pollFirst());
        }

        return builder.length() == 0 ? "/" : builder.toString();
    }

    // T:O(n), S:O(n)
    public String simplifyPath1(String path) {
        if (path == null || path.length() == 0) return "/";

        Stack<String> stack = new Stack<>();
        String[] array = path.split("/");

        for (String s: array) {
            // case 1: empty
            if (s.length() == 0) continue;
            // case 2: .
            if (s.equals(".")) continue;

            // case 3: ..
            if (s.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                // case 4: direction name
                stack.push(s);
            }
        }

        StringBuilder builder = new StringBuilder();

        // [a,b] => /a/b
        while (!stack.isEmpty()) {
            builder.insert(0, "/" + stack.pop());
        }

        return builder.length() == 0 ? "/" : builder.toString();
    }
}
/**
 Rule
 #1: no trailing /
 #2: // -> /
 #3: . -> current
 #4: .. -> directory up
 */
