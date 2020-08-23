package com.booknara.problem.topological;

import java.util.*;

/**
 * 207. Course Schedule (Medium)
 * https://leetcode.com/problems/course-schedule/
 */
public class CourseSchedule {
    // T:O(∣E∣+∣V∣), S:O(∣E∣+∣V∣)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        // generate graph (pre - list of courses)
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite: prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];
            graph.get(pre).add(course);
            inDegree[course]++;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                stack.push(i);
            }
        }

        int finished = 0;
        while (!stack.isEmpty()) {
            int course = stack.pop();
            finished++;
            for (int nei: graph.get(course)) {
                inDegree[nei]--;
                if (inDegree[nei] == 0) {
                    stack.push(nei);
                }
            }
        }

        return finished == numCourses;
    }

    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        // indegree array
        int[] inDegree = new int[numCourses];
        // graph edge (key: prerequisite, value: classes)
        Map<Integer, List<Integer>> edge = new HashMap<>();
        for (int[] c: prerequisites) {
            inDegree[c[0]]++;
            List<Integer> list = edge.getOrDefault(c[1], new ArrayList<>());
            list.add(c[0]);
            edge.put(c[1], list);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) q.offer(i);
        }

        int count = 0;
        while (!q.isEmpty()) {
            int n = q.poll();
            count++;
            if (!edge.containsKey(n)) continue;

            for (int nei: edge.get(n)) {
                inDegree[nei]--;
                if (inDegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        // the number of count means the number of courses finished
        return count == numCourses;
    }

    // T:O(∣E∣+∣V∣) where |V|∣V∣ is the number of courses, and |E|∣E∣ is the number of dependencies.
    // S:O(∣E∣+∣V∣)
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }

        // course -> list of prerequisites
        List<List<Integer>> edge = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edge.add(new ArrayList<>());
        }

        int [] inDegree = new int[numCourses];
        for (int[] pre: prerequisites) {
            inDegree[pre[1]]++;
            edge.get(pre[0]).add(pre[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int i = queue.poll();

            for (int p: edge.get(i)) {
                inDegree[p]--;
                if (inDegree[p] == 0) {
                    queue.add(p);
                }
            }
        }

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] != 0) {
                return false;
            }
        }

        return true;
    }

    // Need to improve, prerequisites -> List<List<Integer>>
    public boolean canFinish3(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }

        int [] inDegree = new int[numCourses];
        for (int[] pre: prerequisites) {
            inDegree[pre[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int i = queue.poll();
            for (int[] p: prerequisites) {
                if (i == p[0]) {
                    inDegree[p[1]]--;
                    if (inDegree[p[1]] == 0) {
                        queue.add(p[1]);
                    }
                }
            }
        }

        for (int d : inDegree) {
            if (d != 0) {
                return false;
            }
        }

        return true;
    }
}
