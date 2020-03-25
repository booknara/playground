package com.booknara.problem.dfs;

import org.junit.Assert;
import org.junit.Test;

public class MaxAreaOfIslandsTest {
    @Test
    public void maxAreaOfIslandTest() {
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();

        Assert.assertEquals(maxAreaOfIsland.maxAreaOfIsland(new int[][] {
                {1,1,1,1,0},
                {1,1,0,1,0},
                {1,1,0,0,0},
                {0,0,0,0,0}
        }), 9);
        Assert.assertEquals(maxAreaOfIsland.maxAreaOfIsland(new int[][] {
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,1}
        }), 4);
        Assert.assertEquals(maxAreaOfIsland.maxAreaOfIsland(new int[][] {
                {1,1,0,0,1},
                {1,1,0,0,1},
                {0,0,0,0,1},
                {0,0,0,1,1}
        }), 5);
    }
}
