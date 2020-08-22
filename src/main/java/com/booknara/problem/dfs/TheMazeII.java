package com.booknara.problem.dfs;

/**
 * 505. The Maze II (Medium)
 * https://leetcode.com/problems/the-maze-ii/
 */
public class TheMazeII {
    int[][] dirs = new int[][] { {0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // T:O(n*m) or O(n*m*max(m, n), S:O(n*m)
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] distance = new int[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        distance[start[0]][start[1]] = 0;
        dfs(maze, start, distance);

        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ?
                -1 : distance[destination[0]][destination[1]];
    }

    public void dfs(int[][] maze, int[] start, int[][] distance) {
        // base case (out of border)
        for (int[] dir: dirs) {
            int x = start[0] + dir[0];
            int y = start[1] + dir[1];
            int count = 0;
            while (x >= 0 && y >= 0 && x < maze.length && y < maze[x].length && maze[x][y] == 0) {
                x += dir[0];
                y += dir[1];
                count++;
            }

            if (distance[start[0]][start[1]] + count < distance[x - dir[0]][y - dir[1]]) {
                distance[x - dir[0]][y - dir[1]] = distance[start[0]][start[1]] + count;
                dfs(maze, new int[] {x - dir[0], y - dir[1]}, distance);
            }
        }
    }
}
