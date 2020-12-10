package com.booknara.problem.tree.bst;

import com.booknara.problem.common.ListNode;
import com.booknara.problem.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 109. Convert Sorted List to Binary Search Tree (Medium)
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class ConvertSortedListToBinarySearchTree {
    // T:O(n*logn), S:O(logn)
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return dfs(list, 0, list.size() - 1);
    }

    public TreeNode dfs(List<Integer> list, int left, int right) {
        // base condition
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = dfs(list, left, mid - 1);
        node.right = dfs(list, mid + 1, right);

        return node;
    }
}
