package com.booknara.problem.stack;

import java.util.LinkedList;

/**
 * 71. Simplify Path (Medium)
 * https://leetcode.com/problems/simplify-path/
 */
public class SimplifyPath {
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
}
