package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 894. All Possible Full Binary Trees (Medium)
 * https://leetcode.com/problems/all-possible-full-binary-trees/
 */
public class AllPossibleFullBinaryTrees {
  Map<Integer, List<TreeNode>> map = new HashMap<>();

  // T:O(2^n), S:O(n*2^n)
  public List<TreeNode> allPossibleFBT(int n) {
    List<TreeNode> res = new ArrayList<>();
    if (n == 2) return res;

    if (n == 1) {
      res.add(new TreeNode(0));
      return res;
    }

    if (map.containsKey(n)) {
      return map.get(n);
    }

    n--;
    for (int i = 1; i < n; i = i + 2) {
      // left: i, right: n - i
      List<TreeNode> left = allPossibleFBT(i);
      List<TreeNode> right = allPossibleFBT(n - i);
      for (TreeNode l: left) {
        for (TreeNode r: right) {
          TreeNode cur = new TreeNode(0);
          cur.left = l;
          cur.right = r;
          res.add(cur);
        }
      }
    }

    map.put(n, res);
    return res;
  }
}
/**
 root (1)
 1      n - 1

 root (1)
 3      n - 3

 root (1)
 i      n - i
 loop i -> n

 5
 */
