package com.booknara.problem.tree;

import org.junit.Assert;
import org.junit.Test;

public class UniqueBinarySearchTreeTest {
    @Test
    public void numTreesTest() {
        UniqueBinarySearchTree uniqueBinarySearchTree = new UniqueBinarySearchTree();

        Assert.assertEquals(2, uniqueBinarySearchTree.numTrees(2));
        Assert.assertEquals(5, uniqueBinarySearchTree.numTrees(3));
        Assert.assertEquals(14, uniqueBinarySearchTree.numTrees(4));
    }
}
