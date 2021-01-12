package com.booknara.problem.tree.traverse;

import com.booknara.problem.common.TreeNode;

/**
 * 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree (Medium)
 * https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
 */
public class FindCorrespondingNodeOfBinaryTreeInCloneOfThatTree {
  TreeNode res;

  // T:O(n), S:(logn)
  public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
    // input check, the number of original tree nodes >= 1
    dfs(original, cloned, target);

    return res;
  }

  public void dfs(TreeNode original, TreeNode cloned, TreeNode target) {
    // base case
    if (original == null) return;

    if (original == target) {
      res = cloned;
      return;
    }

    dfs(original.left, cloned.left, target);
    dfs(original.right, cloned.right, target);
  }
}
