package com.booknara.problem.math;

/**
 * 1041. Robot Bounded In Circle (Medium)
 * https://leetcode.com/problems/robot-bounded-in-circle/
 */
public class RobotBoundedInCircle {
  // T: O(n), S:(1)
  public boolean isRobotBounded(String instructions) {
    // input is not empty
    int dir = 0;
    Point point = new Point(0, 0);
    for (int i = 0; i < instructions.length(); i++) {
      char c = instructions.charAt(i);
      if (c == 'L') {
        dir--;
        continue;
      }
      if (c == 'R') {
        dir++;
        continue;
      }

      if (c == 'G') {
        int mod = Math.abs(dir) % 4;
        switch (mod) {
          case 0:
            // North
            point.y++;
            break;
          case 1:
            // East
            point.x++;
            break;
          case 2:
            // South
            point.y--;
            break;
          case 3:
            point.x--;
            // West
            break;
        }
      }

      //System.out.println(point.x + "," + point.y);
    }

    // two conditions to make cycle (returning the initial (0, 0) and not pointing to north)
    return (point.x == 0 && point.y == 0) || (Math.abs(dir) % 4 != 0);
  }

  class Point {
    int x;
    int y;
    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
