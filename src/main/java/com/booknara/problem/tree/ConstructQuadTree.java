package com.booknara.problem.tree;

/**
 * 427. Construct Quad Tree (Medium)
 * https://leetcode.com/problems/construct-quad-tree/
 */
public class ConstructQuadTree {
    // T:O(logn), S:O(logn)
    public Node construct(int[][] grid) {
        if (grid == null || grid.length == 0) return null;

        return dfs(grid, 0, 0, grid.length - 1, grid[0].length - 1);
    }

    public Node dfs(int[][] grid, int top, int left, int bottom, int right) {
        //System.out.println(top + "," + left + "," + bottom + "," + right);
        if (top > bottom || left > right) {
            return null;
        }

        // search elements
        int v = grid[top][left];
        boolean isLeaf = true;
        for (int i = top; i <= bottom; i++) {
            for (int j = left; j <= right; j++) {
                if (v != grid[i][j]) {
                    isLeaf = false;
                    break;
                }
            }
        }

        Node node = new Node();
        if (isLeaf) {
            node.isLeaf = true;
            node.val = v == 1;
            node.topLeft = null;
            node.topRight = null;
            node.bottomLeft = null;
            node.bottomRight = null;
        } else {
            node.isLeaf = false;
            node.val = false;
            int rowMid = (top + bottom) / 2;
            int colMid = (left + right) / 2;

            node.topLeft = dfs(grid, top, left, rowMid, colMid);
            node.topRight = dfs(grid, top, colMid + 1, rowMid, right);
            node.bottomLeft = dfs(grid, rowMid + 1, left, bottom, colMid);
            node.bottomRight = dfs(grid, rowMid + 1, colMid + 1, bottom, right);
        }

        return node;
    }

    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
