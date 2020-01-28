package com.booknara.problem.sort;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Leet code : 210. Course Schedule II(Medium)
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 *
 * Example 1:
 * Input: 2, [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
 *              course 0. So the correct course order is [0,1] .
 * Example 2:
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,1,2,3] or [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
 *              courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 *              So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
 */
public class CourseScheduleII {
    // TODO : Wrong answer
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Totological sort
        if (prerequisites == null || prerequisites.length == 0) {
            return null;
        }

        Stack<int[]> stack = new Stack<>();
        int[] res = new int[numCourses];
        int index = 0;
        Set<Integer> visited = new HashSet<>();
        stack.push(prerequisites[0]);

        while (!stack.empty()) {
            int[] course = stack.peek();
            if (visited.contains(course[1])) {
                res[index++] = course[0];
                stack.pop();
            } else {
                visited.add(course[1]);
                stack.push(course);
            }
        }

        return res;
    }
}
