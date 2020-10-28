package com.booknara.problem.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 773. Sliding Puzzle (Hard)
 * https://leetcode.com/problems/sliding-puzzle/
 */
public class SlidingPuzzle {
    // T:O((m * n)!), S:O((m * n)!)
    public int slidingPuzzle(int[][] board) {
        // input, board = 2 x 3

        String initStatus = getArrayStatus(board);
        String finalStatus = "123450";

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(initStatus);
        visited.add(initStatus);

        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String s = q.poll();
                if (s.equals(finalStatus)) return step;

                // 123
                // 405
                int index = s.indexOf('0');
                int vertical;
                if (index < 3) {
                    // top line
                    vertical = index + 3;
                } else {
                    // bottom line
                    vertical = index - 3;
                }
                String can1 = swap(new StringBuilder(s), index, vertical).toString();
                if (!visited.contains(can1)) {
                    q.offer(can1);
                    visited.add(can1);
                }

                // left
                if (index != 0 && index != 3) {
                    String can2 = swap(new StringBuilder(s), index, index - 1).toString();
                    if (!visited.contains(can2)) {
                        q.offer(can2);
                        visited.add(can2);
                    }
                }
                // right
                if (index != 2 && index != 5) {
                    String can3 = swap(new StringBuilder(s), index, index + 1).toString();
                    if (!visited.contains(can3)) {
                        q.offer(can3);
                        visited.add(can3);
                    }
                }
            }

            step++;
        }

        return -1;
    }

    public String getArrayStatus(int[][] board) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                res.append(board[i][j]);
            }
        }

        return res.toString();
    }

    public StringBuilder swap(StringBuilder builder, int i, int j) {
        char temp = builder.charAt(i);
        builder.setCharAt(i, builder.charAt(j));
        builder.setCharAt(j, temp);

        return builder;
    }
}
/**
 [
 [1,2,3]
 [4,0,5]

 [1,2,3]
 [5,4,0]

 [4,1,2]
 [5,0,3]

 [1,2,3]
 [4,5,0]
 ]
 */