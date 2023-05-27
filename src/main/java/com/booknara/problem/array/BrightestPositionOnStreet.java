package com.booknara.problem.array;

import java.util.Arrays;

/**
 * 2021. Brightest Position on Street (Medium)
 * https://leetcode.com/problems/brightest-position-on-street
 */
public class BrightestPositionOnStreet {
  // T:O(n*logn), S:O(n)
  public int brightestPosition(int[][] lights) {
    // edge case
    if (lights == null || lights.length == 0) return 0;

    int[][] ranges = new int[lights.length * 2][2];
    for (int i = 0; i < lights.length; i++) {
      int pos = lights[i][0];
      int range = lights[i][1];
      int start = pos - range;
      int end = pos + range;
      ranges[i * 2][0] = start;
      ranges[i * 2][1] = 0;   // start indicator
      ranges[i * 2 + 1][0] = end;
      ranges[i * 2 + 1][1] = 1;   // end indicator
    }
    // ascending sort
    Arrays.sort(ranges, (int[] a, int[] b) -> {
      if (a[0] == b[0]) {
        return Integer.compare(a[1], b[1]);
      }
      return Integer.compare(a[0], b[0]);
    });

    int max = 0;
    int step = 0;
    int res = 0;
    for (int i = 0; i < ranges.length; i++) {
      if (ranges[i][1] == 0) {
        // start
        step++;
        if (step > max) {
          max = step;
          res = ranges[i][0];
        }
      } else {
        // end
        step--;
      }
    }

    return res;
  }
}
/**
 Input: lights = [[-3,2],[1,2],[3,3]]
 range: [-5, -1], [-1, 3], [0, 6]

 -5(0), -1(0), -1(1), 0(0), 3(1), 6(1)
 1       2      1     2      1     0
 s = 0, e = 1
 Output: -1

 int[][] ranges = new int[lights.length][2]
 ranges[]
 */
