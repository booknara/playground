package com.booknara.problem.hash;

import org.junit.Assert;
import org.junit.Test;

public class LFUCacheTest {
    @Test
    public void test() {
        LFUCache cache = new LFUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        Assert.assertEquals(1, cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        Assert.assertEquals(-1, cache.get(2));       // returns -1 (not found)
        Assert.assertEquals(3, cache.get(3));       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        Assert.assertEquals(-1, cache.get(1));       // returns -1 (not found)
        Assert.assertEquals(3, cache.get(3));       // returns 3
        Assert.assertEquals(4, cache.get(4));       // returns 4
    }

    /**
     * ["LFUCache","get","put","get","put","put","get","get"]
     * [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
     */
    @Test
    public void test1() {
        LFUCache cache = new LFUCache( 2 /* capacity */ );

        Assert.assertEquals(-1, cache.get(2));      // return -1
        cache.put(2, 6);
        Assert.assertEquals(-1, cache.get(1));      // return -1

        cache.put(1, 5);
        cache.put(1, 2);
        Assert.assertEquals(2, cache.get(1));       // returns 2
        Assert.assertEquals(6, cache.get(2));       // returns 6
    }
}
