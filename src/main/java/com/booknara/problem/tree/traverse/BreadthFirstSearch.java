package com.booknara.problem.tree.traverse;

import com.booknara.problem.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    public void search(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }

    }
}
