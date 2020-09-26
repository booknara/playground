package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 297. Serialize and Deserialize Binary Tree (Hard)
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
public class SerializeDeserializeBinaryTree {

    // Encodes a tree to a single string.
    // T:O(n), S:O(n)
    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder res = new StringBuilder();
        convertTree(root, res);
        System.out.println(res.toString());

        return res.toString();
    }

    // pre-order traverse
    public void convertTree(TreeNode node, StringBuilder builder) {
        // base case
        if (node == null) {
            builder.append("#");
            return;
        }

        builder.append(node.val);
        builder.append(",");
        convertTree(node.left, builder);
        builder.append(",");
        convertTree(node.right, builder);
    }

    // Decodes your encoded data to tree.
    // T:O(n), S:O(n)
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;

        Queue<String> q = new LinkedList<>();
        String[] nodes = data.split(",");
        for (String s: nodes) {
            q.offer(s);
        }

        return dfs(q);
    }

    // [1,2,#,#,3,4,#,#,5,#,#] -> []
    public TreeNode dfs(Queue<String> q) {
        // base case
        if (q.isEmpty()) return null;

        String s = q.poll();
        if (s.equals("#")) {
            return null;
        }

        //      1
        //   2    3
        //      4   5
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = dfs(q);
        node.right = dfs(q);

        return node;
    }

    // BFS
    // T:O(n), S:O(n)
    public String serialize1(TreeNode root) {
        if (root == null) return "";

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        StringBuilder builder = new StringBuilder();
        builder.append(root.val).append(",");
        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node.left == null) {
                builder.append("#").append(",");
            } else {
                q.offer(node.left);
                builder.append(node.left.val).append(",");
            }

            if (node.right == null) {
                builder.append("#").append(",");
            } else {
                q.offer(node.right);
                builder.append(node.right.val).append(",");
            }
        }

        String res = builder.toString();
        //System.out.println(res);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize1(String data) {
        if (data.length() == 0) return null;

        int i = 0;
        String[] node = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(node[i++]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode tree = q.poll();

            if (node[i].equals("#")) {
                tree.left = null;
            } else {
                tree.left = new TreeNode(Integer.parseInt(node[i]));
                q.offer(tree.left);
            }
            i++;

            if (node[i].equals("#")) {
                tree.right = null;
            } else {
                tree.right = new TreeNode(Integer.parseInt(node[i]));
                q.offer(tree.right);
            }
            i++;
        }

        return root;
    }
}
/**
 1
 / \
 2   3
 / \
 4   5

 Pre-order traverse
 [1,2,#,#,3,4,#,#,5,#,#]
 */