package com.booknara.problem.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 207. Course Schedule (Medium)
 * https://leetcode.com/problems/course-schedule/
 */
public class CourseSchedule {
    // T:O(∣E∣+∣V∣) where |V|∣V∣ is the number of courses, and |E|∣E∣ is the number of dependencies.
    // S:O(∣E∣+∣V∣)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
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