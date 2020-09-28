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
        if (path == null || path.length() == 0) return "";

        Stack<String> stack = new Stack<>();
        // #2
        path = path.replaceAll("//", "/");
        String[] array = path.split("/");
        for (String s: array) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (s.equals(".")) {
                // skip
            } else {
                if (s.length() != 0) stack.push(s);
            }
        }

        if (stack.isEmpty()) return "/";

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            String dir = "/" + stack.pop();
            res.insert(0, dir);
        }

        return res.toString();
    }
}
/**
 Rule
 #1: no trailing /
 #2: // -> /
 #3: . -> current
 #4: .. -> directory up


 */
