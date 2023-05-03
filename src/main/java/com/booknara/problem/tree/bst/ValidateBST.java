package com.booknara.problem.tree.bst;

import com.booknara.problem.common.TreeNode;

import java.util.Stack;

/**
 * 98. Validate Binary Search Tree (Medium)
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBST {
  // T:O(n), S:O(h)
  public boolean isValidBST(TreeNode root) {
    if (root == null) return true;

    return dfs(root, null, null);
  }

  public boolean dfs(TreeNode node, Integer min, Integer max) {
    if (node == null) return true;

    if (min != null && min >= node.val) return false;
    if (max != null && node.val >= max) return false;

    return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
  }

  public boolean isValidBST1(TreeNode root) {
    if (root == null) return true;

    // inorder traverse (ascending order)
    Integer num = null;
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = root;
    while (!stack.isEmpty() || cur != null) {
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }

      cur = stack.pop();
      //System.out.println(cur.val);
      if (num == null) {
        num = cur.val;
      } else {
        if (num >= cur.val) return false;
        num = cur.val;
      }
      cur = cur.right;
    }

    return true;
  }

  boolean res = true;
  Integer pre = null;

  // T:O(n), S:O(h)
  public boolean isValidBST2(TreeNode root) {
    dfs(root);
    return res;
  }

  public void dfs(TreeNode node) {
    // base case
    if (node == null) return;

    dfs(node.left);
    if (pre != null) {
      if (res) {
        res = pre < node.val;
      }
    }
    pre = node.val;
    // System.out.println(node.val);
    dfs(node.right);
  }
}
