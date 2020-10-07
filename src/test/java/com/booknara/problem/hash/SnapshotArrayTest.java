package com.booknara.problem.hash;

import org.junit.Assert;
import org.junit.Test;

public class SnapshotArrayTest {
    @Test
    public void test1() {
        SnapshotArray snapshotArray = new SnapshotArray(1);
        snapshotArray.set(0, 15);
        Assert.assertEquals(0, snapshotArray.snap());
        Assert.assertEquals(1, snapshotArray.snap());
        Assert.assertEquals(2, snapshotArray.snap());
        Assert.assertEquals(15, snapshotArray.get(0, 2));
        Assert.assertEquals(3, snapshotArray.snap());
        Assert.assertEquals(4, snapshotArray.snap());
        Assert.assertEquals(15, snapshotArray.get(0, 0));
    }

    @Test
    public void test2() {
        SnapshotArray snapshotArray = new SnapshotArray(3);
        snapshotArray.set(0, 5);
        Assert.assertEquals(0, snapshotArray.snap());
        snapshotArray.set(0, 6);
        Assert.assertEquals(5, snapshotArray.get(0, 0));
    }
}
