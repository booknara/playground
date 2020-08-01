package com.booknara.algorithms.tree;

public class SegmentTree2 {
    int[] sg;
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        SegmentTree2 segmentTree = new SegmentTree2(nums);

        // range[1, 2]
        System.out.println(segmentTree.getSum(nums, 1, 3)); // 5
        segmentTree.updateSegmentTree(nums, 2, 1);
        System.out.println(segmentTree.getSum(nums, 1, 3)); // 3
    }

    public SegmentTree2(int[] nums) {
        sg = new int[2 * nums.length];  // simply use enough 2 * n (not 2 * 2^ceiling(logn / log2) - 1)
        buildSegmentTree(nums);
    }

    public void buildSegmentTree(int[] nums) {
        int n = nums.length;

        // insert leaf nodes in tree
        for (int i = 0; i < n; i++) {
            sg[n + i] = nums[i];
        }

        // For an index i , its left child will be at (2 * i) and right child will be at (2*i + 1) index.
        for (int i = n - 1; i > 0; --i) {
            int left = sg[i << 1];
            int right = sg[i << 1 | 1];
            sg[i] = left + right;
        }
    }

    /**
     *
     * @param nums original array
     * @param l left index, inclusive
     * @param r right index, exclusive
     * @return sum
     */
    public int getSum(int[] nums, int l, int r) {
        int n = nums.length;
        int res = 0;

        // loop to find the sum in the range
        l += n;
        r += n;
        while (l < r) {
            if ((l & 1) > 0) {
                res += sg[l++];
            }

            if ((r & 1) > 0) {
                res += sg[--r];
            }

            l >>= 1;
            r >>= 1;
        }

        return res;
    }

    public void updateSegmentTree(int[] nums, int idx, int value) {
        sg[nums.length + idx] = value;
        idx = nums.length + idx;

        // update parents (i = i >> 1)
        for (int i = idx; i > 1; i >>= 1) {
            sg[i >> 1] = sg[i] + sg[i ^ 1];
        }
    }
}
