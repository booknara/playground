package com.booknara.problem.dp;

import org.junit.Assert;
import org.junit.Test;

public class UniquePathsTest {
    @Test
    public void uniquePaths() {
        UniquePaths uniquePaths = new UniquePaths();
        Assert.assertEquals(3, uniquePaths.uniquePaths(3, 2));
        Assert.assertEquals(6, uniquePaths.uniquePaths(3, 3));
        Assert.assertEquals(28, uniquePaths.uniquePaths(7, 3));
    }
}
