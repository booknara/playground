package com.booknara.problem.dc;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest {
    @Test
    public void sortTest() {
        int[] source = new int[] {5, 1, 6, 2, 3, 4 };
        int[] expect = new int[] {1, 2, 3, 4, 5, 6};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(source, 6);
        Assert.assertArrayEquals(source, expect);
    }
}
