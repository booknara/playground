package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 366. Find Leaves of Binary Tree
 * https://leetcode.com/problems/find-leaves-of-binary-tree/
 */
public class FindLeavesOfBinaryTree {
  // T:O(n*h)
  public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    // loop
    TreeNode parent = new TreeNode();
    parent.left = root;
    while (parent.left != null) {
      List<Integer> list = new ArrayList<>();
      dfs(parent, root, true, list);
      res.add(list);
    }

    return res;
  }

  public void dfs(TreeNode parent, TreeNode child, boolean left, List<Integer> list) {
    if (child == null) return;

    // leaf
    if (child.left == null && child.right == null) {
      list.add(child.val);
      if (left) {
        parent.left = null;
      } else {
        parent.right = null;
      }

      return;
    }
    dfs(child, child.left, true, list);     // left
    dfs(child, child.right, false, list);   // right
  }
}
/**
 loop until a leaf node is root
 1. find a leaf node
 2. remove a leaf node
 */
