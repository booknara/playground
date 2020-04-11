package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.*;

/**
 * 863. All Nodes Distance K in Binary Tree (Medium)
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 */
public class AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // O distance node
        if (K == 0) {
            res.add(target.val);
            return res;
        }

        // Parent node
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        dfs(root, parents);
        parents.put(null, root);

        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(null);
        queue.add(target);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(null);
        visited.add(target);
        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();
            if (n == null) {
                if (depth == K) {
                    for (TreeNode i: queue) {
                        res.add(i.val);
                    }
                    return res;
                }
                depth++;
                queue.add(null);
            } else {
                // parent
                TreeNode p = parents.get(n);
                if (!visited.contains(p)) {
                    queue.add(p);
                    visited.add(p);
                }
                // left
                TreeNode l = n.left;
                if (!visited.contains(l)) {
                    queue.add(l);
                    visited.add(l);
                }
                // right
                TreeNode r = n.right;
                if (!visited.contains(r)) {
                    queue.add(r);
                    visited.add(r);
                }
            }

        }

        return res;
    }

    public void dfs(TreeNode node, Map<TreeNode, TreeNode> parents) {
        if (node.left != null) {
            parents.put(node.left, node);
            dfs(node.left, parents);
        }
        if (node.right != null) {
            parents.put(node.right, node);
            dfs(node.right, parents);
        }
    }
}
