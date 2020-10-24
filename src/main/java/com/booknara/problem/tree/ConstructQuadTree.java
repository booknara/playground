package com.booknara.problem.tree;

/**
 * 427. Construct Quad Tree (Medium)
 * https://leetcode.com/problems/construct-quad-tree/
 */
public class ConstructQuadTree {
    // T:O(logn), S:O(logn)
    public Node construct(int[][] grid) {
        // input check
        if (grid == null || grid.length == 0) return null;

        int m = grid.length;
        int n = grid[0].length;
        return helper(grid, 0, 0, m - 1, n - 1);
    }

    // 0, 0, 3, 3
    public Node helper(int[][] grid, int top, int left, int bottom, int right) {
        if (top == bottom || left == right) {
            return new Node(grid[top][left] != 0, true);
        }

        int rowMid = top + (bottom - top) / 2;
        int colMid = left + (right - left) / 2;
        Node topLeft = helper(grid, top, left, rowMid, colMid);
        Node topRight = helper(grid, top, colMid + 1, rowMid, right);
        Node bottomLeft = helper(grid, rowMid + 1, left, bottom, colMid);
        Node bottomRight = helper(grid, rowMid + 1, colMid + 1, bottom, right);

        // leaf node
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
                && topLeft.val == topRight.val && topRight.val == bottomLeft.val
                && bottomLeft.val == bottomRight.val) {
            return new Node(topLeft.val, true);
        }

        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    /**
     n is even number
     Bottom up approach
     1. Divide four parts
     (n,n) -> n = 4, (0,1,2,3)
     (0,0) - (3,3)
     0 1 |2 3
     0    |
     1    |
     -----------
     2    |
     3    |
     top left    (0,0) (1,1) top right     (0,2) (1,3)
     bottom left (2,0), (3,1) bottom right (2,2), (3,3)

     top, left, bottom, right
     topLeft: top, left, bottom / 2, right / 2
     topRight: top, right / 2 + 1, bottom / 2, right
     bottomLeft: bottom / 2 + 1, left, bottom, right / 2
     bottomRight: bottom / 2 + 1, right / 2 + 1, bottom, right
     */

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
