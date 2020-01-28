package com.booknara.problem.dfs;

import org.junit.Assert;
import org.junit.Test;

public class NumberOfIslandsTest {
    @Test
    public void numIslandsTest() {
        NumberOfIslands numberOfIslands = new NumberOfIslands();

        Assert.assertEquals(numberOfIslands.numIslands(new char[][] {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        }), 1);
        Assert.assertEquals(numberOfIslands.numIslands(new char[][] {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        }), 3);
    }
}
