package com.booknara.problem.search.binary;

import org.junit.Assert;
import org.junit.Test;

public class SearchInRotatedSortedArrayTest {
    @Test
    public void search() {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        Assert.assertEquals(1, s.search(new int[] {3, 1}, 1));
        Assert.assertEquals(4, s.search(new int[] {4,5,6,7,0,1,2}, 0));
        Assert.assertEquals(-1, s.search(new int[] {4,5,6,7,0,1,2}, 3));
    }
}
