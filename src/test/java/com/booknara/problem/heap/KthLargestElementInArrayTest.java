package com.booknara.problem.heap;

import org.junit.Assert;
import org.junit.Test;

public class KthLargestElementInArrayTest {
    @Test
    public void findKthLargest() {
        KthLargestElementInArray kthLargestElementInArray = new KthLargestElementInArray();
        Assert.assertEquals(5, kthLargestElementInArray.findKthLargest(new int[] {3,2,1,5,6,4}, 2));
        Assert.assertEquals(4, kthLargestElementInArray.findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4));

        Assert.assertEquals(5, kthLargestElementInArray.findKthLargestFaster(new int[] {3,2,1,5,6,4}, 2));
        Assert.assertEquals(1, kthLargestElementInArray.findKthLargestFaster(new int[] {3,2,3,1,2,4,5,5,6}, 9));


    }
}
