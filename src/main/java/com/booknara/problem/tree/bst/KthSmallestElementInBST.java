package com.booknara.problem.tree.bst;

import com.booknara.problem.common.TreeNode;

import java.util.Stack;

/**
 * 230. Kth Smallest Element in a BST (Medium)
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class KthSmallestElementInBST {
  // T:O(h + k, h: the height of tree, k: kth element), S:O(n)
  public int kthSmallest(TreeNode root, int k) {
    // root is not null, 1 <= k <= a total elements
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = root;
    while (!stack.isEmpty() || cur != null) {
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }

      k--;
      cur = stack.pop();
      if (k == 0) return cur.val;
      cur = cur.right;
    }

    return -1;
  }

  int k = -1;
  int res = -1;

  // T:O(n, the number of nodes), S:O(logn)
  public int kthSmallest1(TreeNode root, int k) {
    // edge case
    if (root == null) return 0;
    this.k = k;
    inorder(root);

    return res;
  }

  public void inorder(TreeNode node) {
    // base case
    if (node == null) return;

    // left tree
    inorder(node.left);
    // root
    if (k == 1) {
      res = node.val;
    }
    k--;
    // right tree
    inorder(node.right);
  }
}

/**
 * 1. Recursive in-order traverse (left - root - right)
 * left < root < right
 * 1. List<Integer> list = new LinkedList<>();
 * 2. Result : [1, 2, 3, 4] -> poll() k times
 * Complexity T: O(n), S:O(n)
 * <p>
 * 2. Iterative in-order traverse (left - root - right)
 * left < root < right
 * traverse() k times, then return kth integer
 * Complexity T: O(n), S:O(1)
 */
