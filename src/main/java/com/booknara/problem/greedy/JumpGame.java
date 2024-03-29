package com.booknara.problem.greedy;

/**
 * 55. Jump Game (Medium)
 * https://leetcode.com/problems/jump-game/
 */
public class JumpGame {
  // Backward checking (Linear greedy approach)
  // T:O(n), S:O(1)
  public boolean canJump(int[] nums) {
    // input check nums.length >= 1
    int guaranteeIdx = nums.length - 1; // 4
    for (int i = nums.length - 2; i >= 0; i--) {
      if (i + nums[i] >= guaranteeIdx) {
        guaranteeIdx = i;
      }
    }

    return guaranteeIdx == 0;
  }

  // Forward checking (Linear greedy approach)
  // T:O(n), S:O(1)
  public boolean canJump1(int[] nums) {
    // input check
    int n = nums.length;

    int maxPos = nums[0];
    for (int i = 1; i < n; i++) {
      if (maxPos < i) {
        return false;
      }

      if (i + nums[i] > maxPos) {
        // maintain the max step whether it can reach to the last index
        maxPos = i + nums[i];
      }
    }

    return true;
  }

  // Forward checking (too slow)
  public boolean canJump2(int[] nums) {
    if (nums == null || nums.length == 0) {
      return false;
    }

    boolean[] visited = new boolean[nums.length];
    return dfs(nums, 0, visited);
  }

  private boolean dfs(int[] nums, int index, boolean[] visited) {
    //System.out.println(index);
    // exit condition
    if (index >= visited.length || visited[index]) {
      return false;
    }
    if (index == nums.length - 1) {
      return true;
    }

    visited[index] = true;
    int maxSteps = nums[index];
    for (int i = maxSteps; i >= 1; i--) {
      int nextIndex = index + i;

      if (dfs(nums, nextIndex, visited)) {
        return true;
      }
    }

    return false;
  }
}
