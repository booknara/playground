package com.booknara.problem.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 1361. Validate Binary Tree Nodes (Medium)
 * https://leetcode.com/problems/validate-binary-tree-nodes/
 */
public class ValidateBinaryTreeNodes {
    // T:O(n), S:O(n)
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        // input check n >= 1
        Set<Integer> visited = new HashSet<>();
        // Find a root
        int root = getRoot(leftChild, rightChild);
        Queue<Integer> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int node = q.poll();
                if (visited.contains(node)) return false;
                visited.add(node);

                // left child
                if (leftChild[node] != -1) {
                    q.offer(leftChild[node]);
                }
                // right child
                if (rightChild[node] != -1) {
                    q.offer(rightChild[node]);
                }
            }
        }

        return visited.size() == n;
    }

    public int getRoot(int[] leftChild, int[] rightChild) {
        int root = 0;
        for (int i = 0; i < leftChild.length; i++) {
            int left = leftChild[i];
            int right = rightChild[i];
            if (left == root || right == root) root = i;
        }

        return root;
    }
}
/**
 Input: n = 4,
 leftChild = [1,-1,3,-1]
 rightChild = [2,-1,-1,-1]

 0 -> [1,2]
 1 -> []
 2 -> [3]
 3 -> []
 [t,t,t,t]
 BFS
 0
 1,2
 3

 Input: n = 2, leftChild = [1,0], rightChild = [-1,-1]
 0 -> [1]
 1 -> [0]
 [t,t]
 0
 1
 0 -> false because 0 is already true
 Output: false
 Output: true

 Input: n = 6, leftChild = [1,-1,-1,4,-1,-1], rightChild = [2,-1,-1,5,-1,-1]
 0 -> [1,2]
 1 -> []
 2 -> []

 3 -> [4,5]
 4 -> []
 5 -> []

 Output: false
 */