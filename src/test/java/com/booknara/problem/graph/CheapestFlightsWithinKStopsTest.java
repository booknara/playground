package com.booknara.problem.graph;

import org.junit.Assert;
import org.junit.Test;

public class CheapestFlightsWithinKStopsTest {
    @Test
    public void findCheapestPrice() {
        CheapestFlightsWithinKStops cheapestFlightsWithinKStops = new CheapestFlightsWithinKStops();
        int[][] flight = new int [][] {
            {0, 1, 100}, {1, 2, 100}, {0, 2, 500}
        };
        Assert.assertEquals(200, cheapestFlightsWithinKStops.findCheapestPrice(3, flight, 0, 2, 1));
    }
}
