package com.booknara.problem.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1376. Time Needed to Inform All Employees (Medium)
 * https://leetcode.com/problems/time-needed-to-inform-all-employees/
 */
public class TimeNeededToInformAllEmployees {
    // T:O(n), S:O(n)
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // input check

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) graph[manager[i]].add(i); // manager: List of team members
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(headID, 0));

        int max = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node node = q.poll();

                int tempTime = node.time + informTime[node.managerId];
                max = Math.max(max, tempTime);
                for (int v: graph[node.managerId]) {
                    q.offer(new Node(v, tempTime));
                }
            }
        }

        return max;
    }

    static class Node {
        int managerId;
        int time;
        Node(int managerId, int time) {
            this.managerId = managerId;
            this.time = time;
        }
    }
}
/**
 11
 4

 [0,1,2, 3, 4,5,6,7,8,9,10]
 [5,9,6,10,-1,8,9,1,9,3, 4]
 .            .
 [0,  1,2,  3,  4,  5,  6,7,  8,  9, 10]
 [0,213,0,253,686,170,975,0,261,309,337]

 Output: 2560
 */