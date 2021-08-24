package com.booknara.problem.bfs;

import java.util.*;

/**
 * 1345. Jump Game IV (Hard)
 * https://leetcode.com/problems/jump-game-iv/
 */
public class JumpGameIV {
  public int minJumps(int[] arr) {
    if (arr.length <= 1) {
      return 0;
    }

    int result = 0;
    int cur = 0;

    Set<Integer> visited = new HashSet<>();
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int i = arr.length - 1; i >= 0; i--) {
      Set<Integer> indices = map.getOrDefault(arr[i], new HashSet<>());
      indices.add(i);
      map.put(arr[i], indices);
    }

    Queue<Integer> queue = new LinkedList<>();
    queue.add(cur);
    visited.add(cur);

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        cur = queue.poll();
        if (cur == arr.length - 1) {
          // reach to the last index
          return result;
        }


        // index of same values
        Set<Integer> indices = map.getOrDefault(arr[cur], new HashSet<>());
        for (Integer num : indices) {
          if (!visited.contains(num)) {
            queue.add(num);
            visited.add(num);
          }
        }

        map.get(arr[cur]).clear();

        // next
        int next = cur + 1;
        if (next < arr.length && !visited.contains(next)) {
          queue.add(next);
          visited.add(next);
        }

        // prev
        int prev = cur - 1;
        if (prev >= 0 && !visited.contains(prev)) {
          queue.add(prev);
          visited.add(prev);
        }
      }

      result++;
    }

    return result;
  }
}
