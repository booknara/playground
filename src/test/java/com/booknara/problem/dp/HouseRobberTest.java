package com.booknara.problem.dp;

import org.junit.Assert;
import org.junit.Test;

public class HouseRobberTest {
    @Test
    public void robTest() {
        HouseRobber houseRobber = new HouseRobber();
        Assert.assertEquals(houseRobber.rob1(new int[]{1,2,3,1}), 4);
        Assert.assertEquals(houseRobber.rob1(new int[]{2,7,9,3,1}), 12);
        Assert.assertEquals(houseRobber.rob1(new int[]{2,1,1,2}), 4);

        Assert.assertEquals(houseRobber.rob2(new int[]{1,2,3,1}), 4);
        Assert.assertEquals(houseRobber.rob2(new int[]{2,7,9,3,1}), 12);
        Assert.assertEquals(houseRobber.rob2(new int[]{2,1,1,2}), 4);
    }
}
