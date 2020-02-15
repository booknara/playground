package com.booknara.problem.stack;

import org.junit.Assert;
import org.junit.Test;

public class AsteroidCollisionTest {
    @Test
    public void asteroidCollision() {
        AsteroidCollision asteroidCollision = new AsteroidCollision();
        Assert.assertArrayEquals(new int[] {10}, asteroidCollision.asteroidCollision(new int[] {10, 2, -5}));
        Assert.assertArrayEquals(new int[] {-2, -1, 1, 2}, asteroidCollision.asteroidCollision(new int[] {-2, -1, 1, 2}));
        Assert.assertArrayEquals(new int[] {5, 10}, asteroidCollision.asteroidCollision(new int[] {5, 10, -5}));
        Assert.assertArrayEquals(new int[] {}, asteroidCollision.asteroidCollision(new int[] {8, -8}));

        Assert.assertArrayEquals(new int[] {10}, asteroidCollision.asteroidCollisionLinkedList(new int[] {10, 2, -5}));
        Assert.assertArrayEquals(new int[] {-2, -1, 1, 2}, asteroidCollision.asteroidCollisionLinkedList(new int[] {-2, -1, 1, 2}));
        Assert.assertArrayEquals(new int[] {5, 10}, asteroidCollision.asteroidCollisionLinkedList(new int[] {5, 10, -5}));
        Assert.assertArrayEquals(new int[] {}, asteroidCollision.asteroidCollisionLinkedList(new int[] {8, -8}));
    }
}
