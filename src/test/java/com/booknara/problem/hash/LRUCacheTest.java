package com.booknara.problem.hash;

import org.junit.Assert;
import org.junit.Test;

public class LRUCacheTest {
    @Test
    public void test() {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        Assert.assertEquals(1, cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        Assert.assertEquals(-1, cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        Assert.assertEquals(-1, cache.get(1));       // returns -1 (not found)
        Assert.assertEquals(3, cache.get(3));       // returns 3
        Assert.assertEquals(4, cache.get(4));       // returns 4

        LRUCache2 cache2 = new LRUCache2(2);

        cache2.put(1, 1);
        cache2.put(2, 2);
        Assert.assertEquals(1, cache2.get(1));       // returns 1
        cache2.put(3, 3);    // evicts key 2
        Assert.assertEquals(-1, cache2.get(2));       // returns -1 (not found)
        cache2.put(4, 4);    // evicts key 1
        Assert.assertEquals(-1, cache2.get(1));       // returns -1 (not found)
        Assert.assertEquals(3, cache2.get(3));       // returns 3
        Assert.assertEquals(4, cache2.get(4));       // returns 4
    }
}
