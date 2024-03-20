package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * 2265. Count Nodes Equal to Average of Subtree (Medium)
 * https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
 */
public class CountNodesEqualToAverageOfSubtree {
  int res;
  // T:O(n), S:O(h)
  public int averageOfSubtree(TreeNode root) {
    res = 0;
    dfs(root);

    return res;
  }

  public SubTree dfs(TreeNode node) {
    if (node == null) {
      return new SubTree(0, 0);
    }

    SubTree left = dfs(node.left);
    SubTree right = dfs(node.right);
    int sum = left.sum + right.sum + node.val;
    int count = left.count + right.count + 1;
    if (sum / count == node.val) {
      res++;
    }

    return new SubTree(sum, count);
  }

  public class SubTree {
    int sum;
    int count;
    SubTree(int sum, int count) {
      this.sum = sum;
      this.count = count;
    }
  }
}
