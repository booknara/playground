package com.booknara.problem.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 752. Open the Lock (Medium)
 * https://leetcode.com/problems/open-the-lock/
 */
public class OpenTheLock {
    // T:O(n^2*m^n+d), S:O(m^n + d), n: the number of digit(10), m: the length of rotating key, d:the number of dead-end
    public int openLock(String[] deadends, String target) {
        // input check
        Set<String> set = new HashSet<>();
        for (String dead: deadends) {
            set.add(dead);
        }

        String start = "0000";
        // edge case
        if (set.contains(start) || set.contains(target)) return -1;

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        q.add(start);
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String s = q.poll();
                //System.out.println(s);
                if (s.equals(target)) return steps;

                for (int j = 0; j < 4; j++) {
                    StringBuilder plus = new StringBuilder(s);
                    char p = plus.charAt(j);
                    if (p == '9') {
                        plus.setCharAt(j, '0');
                    } else {
                        plus.setCharAt(j, (char)(p + 1));
                    }

                    if (!set.contains(plus.toString()) && !visited.contains(plus.toString())) {
                        q.offer(plus.toString());  // plus
                        visited.add(plus.toString());
                    }

                    StringBuilder minus = new StringBuilder(s);
                    char m = minus.charAt(j);
                    if (m == '0') {
                        minus.setCharAt(j, '9');
                    } else {
                        minus.setCharAt(j, (char)(m - 1));
                    }

                    if (!set.contains(minus.toString()) && !visited.contains(minus.toString())) {
                        q.offer(minus.toString());  // minus
                        visited.add(minus.toString());
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}
/**
 * 0123
 *  each wheel 0 ~ 9
 BFS
 '0000'
 one move candidates
 1: '9000' or '1000'
 2: '0900' or '0100'
 3: '0090' or '0010'
 4: '0009' or '0001'

 but two things to need
 deads check
 visited check
 */