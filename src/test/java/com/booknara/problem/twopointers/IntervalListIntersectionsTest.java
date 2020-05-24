package com.booknara.problem.twopointers;

import org.junit.Test;

public class IntervalListIntersectionsTest {
    @Test
    public void intervalIntersection() {
        IntervalListIntersections intervalListIntersections = new IntervalListIntersections();
        intervalListIntersections.intervalIntersection3(new int[][] {{0,2},{5,10},{13,23},{24,25}},
                new int[][] {{1,5},{8,12},{15,24},{25,26}});
    }
}
