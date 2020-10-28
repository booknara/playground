package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * 951. Flip Equivalent Binary Trees (Medium)
 * https://leetcode.com/problems/flip-equivalent-binary-trees/
 */
public class FlipEquivalentBinaryTrees {
    // T:O(n), S:(h)
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;

        if (root1 == null || root2 == null) return false;

        if (root1.val != root2.val) return false;

        // flip case
        boolean flip = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        // non-flip case
        boolean nonFlip = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);

        return flip || nonFlip;
    }
}
