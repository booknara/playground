package com.booknara.problem.math;

import org.junit.Assert;
import org.junit.Test;

public class ReachingPointsTest {
    @Test
    public void reachingPoints() {
        ReachingPoints reachingPoints = new ReachingPoints();
        Assert.assertTrue(reachingPoints.reachingPointsRecursive(1, 1, 3, 5));
        Assert.assertFalse(reachingPoints.reachingPointsRecursive(1, 1, 2, 2));
        Assert.assertTrue(reachingPoints.reachingPointsRecursive(1, 1, 1, 1));

        Assert.assertTrue(reachingPoints.reachingPointsDP(1, 1, 3, 5));
        Assert.assertFalse(reachingPoints.reachingPointsDP(1, 1, 2, 2));
        Assert.assertTrue(reachingPoints.reachingPointsDP(1, 1, 1, 1));
        // StackOverflowError
        // Assert.assertFalse(reachingPoints.reachingPointsDP(35, 13, 455955547, 420098884));

        Assert.assertTrue(reachingPoints.reachingPointsBackward(1, 1, 3, 5));
        Assert.assertFalse(reachingPoints.reachingPointsBackward(1, 1, 2, 2));
        Assert.assertTrue(reachingPoints.reachingPointsBackward(1, 1, 1, 1));
        Assert.assertFalse(reachingPoints.reachingPointsBackward(35, 13, 455955547, 420098884));
        // Time Limit Exceeded
        // Assert.assertTrue(reachingPoints.reachingPointsBackward(1, 3, 1000000000, 3));

        Assert.assertTrue(reachingPoints.reachingPointsBackwardModulo(1, 1, 3, 5));
        Assert.assertFalse(reachingPoints.reachingPointsBackwardModulo(1, 1, 2, 2));
        Assert.assertTrue(reachingPoints.reachingPointsBackwardModulo(1, 1, 1, 1));
        Assert.assertFalse(reachingPoints.reachingPointsBackwardModulo(35, 13, 455955547, 420098884));
        Assert.assertFalse(reachingPoints.reachingPointsBackwardModulo(10, 1, 17, 17));
    }
}
