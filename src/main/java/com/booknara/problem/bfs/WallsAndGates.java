package com.booknara.problem.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 286. Walls and Gates (Medium)
 * https://leetcode.com/problems/walls-and-gates/
 */
public class WallsAndGates {
    // DFS and update higher values
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }

        int rowMax = rooms.length;
        int colMax = rooms[0].length;
        for (int i = 0; i < rowMax; i++) {
            for (int j = 0; j < colMax; j++) {
                //System.out.println(rooms[i][j]);
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }

    public void dfs(int[][] rooms, int i, int j, int d) {
        // rooms[i][j] < d => it handles -1, 0 cases
        if (i < 0 || i >= rooms.length
                || j < 0 || j >= rooms[i].length
                || rooms[i][j] < d) {
            return;
        }

        rooms[i][j] = d;
        //System.out.println(i + "," + j);
        dfs(rooms, i + 1, j, d + 1);    // Bottom
        dfs(rooms, i - 1, j, d + 1);    // Top
        dfs(rooms, i, j + 1, d + 1);    // Right
        dfs(rooms, i, j - 1, d + 1);    // Left
    }

    private static final int INF = Integer.MAX_VALUE;
    // BFS O(mn)
    public void wallsAndGates1(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }

        Queue<Room> q = new LinkedList<>();
        int rowMax = rooms.length;
        int colMax = rooms[0].length;
        for (int i = 0; i < rowMax; i++) {
            for (int j = 0; j < colMax; j++) {
                //System.out.println(rooms[i][j]);
                if (rooms[i][j] == 0) {
                    q.add(new Room(i, j, 0));
                }
            }
        }

        while (!q.isEmpty()) {
            Room r = q.poll();
            int i = r.i;
            int j = r.j;
            int d = r.d;
            // Top
            if (i > 0 && rooms[i - 1][j] == INF) {
                q.add(new Room(i - 1, j, d + 1));
                rooms[i - 1][j] = d + 1;
            }
            // Bottom
            if (i < rowMax - 1 && rooms[i + 1][j] == INF) {
                q.add(new Room(i + 1, j, d + 1));
                rooms[i + 1][j] = d + 1;
            }
            // Left
            if (j > 0 && rooms[i][j - 1] == INF) {
                q.add(new Room(i, j - 1, d + 1));
                rooms[i][j - 1] = d + 1;
            }
            // Right
            if (j < colMax - 1 && rooms[i][j + 1] == INF) {
                q.add(new Room(i, j + 1, d + 1));
                rooms[i][j + 1] = d + 1;
            }
        }
    }

    class Room {
        int i;
        int j;
        int d;
        Room(int i, int j, int d) {
            this.i = i;
            this.j = j;
            this.d = d;
        }
    }
}
