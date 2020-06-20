package com.booknara.problem.math;

import org.junit.Assert;
import org.junit.Test;

public class NextPermutationTest {
    @Test
    public void nextPermutation() {
        NextPermutation nextPermutation = new NextPermutation();
        int[] input = new int[] {1,3,5,4,2};
        nextPermutation.nextPermutation(input);
        Assert.assertArrayEquals(new int[] {1,4,2,3,5}, input);
    }

    @Test
    public void nextPermutation1() {
        NextPermutation nextPermutation = new NextPermutation();
        int[] input = new int[] {1,3,5,4,2};
        nextPermutation.nextPermutationSinglePath(input);
        Assert.assertArrayEquals(new int[] {1,4,2,3,5}, input);
    }
}
