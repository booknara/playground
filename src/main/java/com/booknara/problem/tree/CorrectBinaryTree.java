package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 1660. Correct a Binary Tree (Medium)
 * https://leetcode.com/problems/correct-a-binary-tree/
 */
public class CorrectBinaryTree {
  // T:O(n), S:O(h)
  public TreeNode correctBinaryTree(TreeNode root) {
    // input check
    if (root == null) return null;

    Set<TreeNode> visited = new HashSet<>();
    Queue<TreeNode> q = new LinkedList<>();
    Queue<TreeNode> parent = new LinkedList<>();
    q.offer(root);
    parent.offer(null);

    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode n = q.poll();
        TreeNode p = parent.poll();
        if (n.right != null && visited.contains(n.right)) {
          // detect
          if (p.left == n) {
            p.left = null;
          } else {
            p.right = null;
          }

          return root;
        }

        //System.out.println(n.val);
        if (n.left != null) {
          visited.add(n.left);
          q.offer(n.left);
          parent.offer(n);
        }
        if (n.right != null) {
          visited.add(n.right);
          q.offer(n.right);
          parent.offer(n);
        }
      }
    }

    return root;
  }
}
