package com.booknara.problem.dp;

import org.junit.Assert;
import org.junit.Test;

public class EditDistanceTest {
    @Test
    public void minDistance() {
        EditDistance editDistance = new EditDistance();
        Assert.assertEquals(5, editDistance.minDistance("intention", "execution"));
        Assert.assertEquals(3, editDistance.minDistance("horse", "ros"));
        Assert.assertEquals(10, editDistance.minDistance("zoologicoarchaeologist", "zoogeologist"));
    }
}
