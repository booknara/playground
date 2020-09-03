package com.booknara.problem.backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * 489. Robot Room Cleaner (Hard)
 * https://leetcode.com/problems/robot-room-cleaner/
 */
public class RobotRoomCleaner {
    Set<String> visited = new HashSet<>();
    // T:O(4^n-m), n: the total number of cell in the room, m: the number of blocked cell
    public void cleanRoom(Robot robot) {
        // start at [0, 0],
        // direction = 0 (top), 90 (right), 180(bottom), 270(left)
        // assume that the starting point[0,0] is accessible
        backtracking(robot, 0, 0, 0);
    }

    public void backtracking(Robot robot, int r, int c, int d) {
        String key = r + "-" + c;
        if (visited.contains(key)) {
            return;
        }

        visited.add(key);
        robot.clean();

        // visit 4 directions
        for (int i = 0; i < 4; i++) {
            if (robot.move()) {
                int newR = r;
                int newC = c;
                // direction = 0 (top), 1 (bottom), 2(left), 3(right)
                switch (d) {
                    case 0:
                        newR = r - 1;
                        break;
                    case 90:
                        newC = c + 1;
                        break;
                    case 180:
                        newR = r + 1;
                        break;
                    case 270:
                        newC = c - 1;
                        break;
                }

                backtracking(robot, newR, newC, d);
                goBack(robot);
            }

            robot.turnLeft();
            d += 90;
            d %= 360;
        }
    }

    public void goBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    interface Robot {
        boolean move();
        void turnLeft();
        void turnRight();
        void clean();
    }
}
