package com.booknara.problem.heap;

import org.junit.Assert;
import org.junit.Test;

public class TaskSchedulerTest {
    @Test
    public void leastInterval() {
        TaskScheduler taskScheduler = new TaskScheduler();
        Assert.assertEquals(8, taskScheduler.leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
        Assert.assertEquals(10, taskScheduler.leastInterval(new char[]{'A','A','A','B','B','B'}, 3));
    }
}
