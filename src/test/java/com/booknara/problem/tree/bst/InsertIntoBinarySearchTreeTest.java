package com.booknara.problem.tree.bst;

import com.booknara.problem.common.TreeNode;
import org.junit.Test;

public class InsertIntoBinarySearchTreeTest {
    @Test
    public void insertIntoBST() {
        TreeNode root = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7));

        InsertIntoBinarySearchTree tree = new InsertIntoBinarySearchTree();
        TreeNode root1 = tree.insertIntoBST(root, 5);
        System.out.println(root1.val);
    }
}

/**
 * [4,2,7,1,3]
 * 5
 * Given the tree:
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 * And the value to insert: 5
 */
