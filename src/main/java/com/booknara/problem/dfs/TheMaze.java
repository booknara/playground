package com.booknara.problem.dfs;

/**
 * 490. The Maze (Medium)
 * https://leetcode.com/problems/the-maze/
 */
public class TheMaze {
    // T:(n*m), S:O(n*m)
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start, destination, visited);
    }

    // [0,4] -> [4,4]
    public boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
        // base case (out of border)
        if (visited[start[0]][start[1]]) return false;

        if (start[0] == destination[0] && start[1] == destination[1]) return true;

        visited[start[0]][start[1]] = true;
        int r = start[1] + 1;
        while (r < maze[0].length && maze[start[0]][r] == 0) {
            r++;
        }
        if (dfs(maze, new int[] {start[0], r - 1}, destination, visited)) return true;

        int l = start[1] - 1;
        while (l >= 0 && maze[start[0]][l] == 0) {
            l--;
        }
        if (dfs(maze, new int[] {start[0], l + 1}, destination, visited)) return true;

        int u = start[0] - 1;
        while (u >= 0 && maze[u][start[1]] == 0) {
            u--;
        }
        if (dfs(maze, new int[] {u + 1, start[1]}, destination, visited)) return true;

        int d = start[0] + 1;
        while (d < maze.length && maze[d][start[1]] == 0) {
            d++;
        }
        if (dfs(maze, new int[] {d - 1, start[1]}, destination, visited)) return true;

        return false;
    }
}
