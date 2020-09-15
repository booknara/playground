package com.booknara.problem.greedy;

import java.util.Arrays;

/**
 * 1580. Put Boxes Into the Warehouse II (Medium)
 * https://leetcode.com/problems/put-boxes-into-the-warehouse-ii/
 */
public class PutBoxesIntoTheWarehouseII {
    // T:O(max(nlogn, mlogm), S:O(n)
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        // input check
        int[] height = new int[warehouse.length];

        height[0] = warehouse[0];
        int min = height[0];
        for (int i = 0; i < warehouse.length; i++) {
            min = Math.min(min, warehouse[i]);
            height[i] = min;
        }

        min = warehouse[warehouse.length - 1];
        for (int i = warehouse.length - 1; i >= 0; i--) {
            min = Math.min(min, warehouse[i]);
            height[i] = Math.max(height[i], min);
        }

        Arrays.sort(boxes);
        Arrays.sort(height);

        int res = 0;
        int j = 0;
        for (int i = 0; i < boxes.length; i++) {
            int num = boxes[i]; // 2
            while (j < height.length && num > height[j]) {
                j++;
            }

            if (j >= height.length) return res;
            res++;  // 1,2,3
            j++;
        }

        return res;
    }
}
