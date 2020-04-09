package com.booknara.problem.sort;

import java.util.*;

/**
 * Leet code : 210. Course Schedule II(Medium)
 * https://leetcode.com/problems/course-schedule-ii/
 */
public class CourseScheduleII {
    // In-degree solution O(N + E)
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses != 0 && (prerequisites == null || prerequisites.length == 0)) {
            // not prerequisites required
            int[] ans = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                ans[i] = i;
            }
            return ans;
        }

        int[] indegree = new int[numCourses];
        int[] res = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] p: prerequisites) {
            int dst = p[0];
            int src = p[1];
            List<Integer> list = map.getOrDefault(src, new ArrayList<>());
            list.add(dst);
            map.put(src, list);
            indegree[dst]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                // 0 indegree
                q.add(i);
            }
        }

        int i = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            res[i++] = node;

            if (map.containsKey(node)) {
                for (int neighbor: map.get(node)) {
                    indegree[neighbor]--;

                    if (indegree[neighbor] == 0) {
                        q.add(neighbor);
                    }
                }
            }
        }

        if (i == numCourses) {
            return res;
        }

        return new int[0];
    }
}
