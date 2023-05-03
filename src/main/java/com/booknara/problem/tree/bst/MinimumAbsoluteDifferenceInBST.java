package com.booknara.problem.tree.bst;

import com.booknara.problem.common.TreeNode;

/**
 * 530. Minimum Absolute Difference in BST (Easy)
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 */
public class MinimumAbsoluteDifferenceInBST {
  int pre = -1;
  int res = Integer.MAX_VALUE;

  //  T:O(n, the number of nodes), S:O(logn)
  public int getMinimumDifference(TreeNode root) {
    // edge case
    if (root == null) return 0;
    dfs(root);
    return res;
  }

  public void dfs(TreeNode root) {
    // base case
    if (root == null) return;

    dfs(root.left);
    if (pre != -1) {
      res = Math.min(res, Math.abs(root.val - pre));
    }

    pre = root.val;
    // System.out.println(root.val);
    dfs(root.right);
  }
}
