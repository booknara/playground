package com.booknara.problem.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Skyline {
    class Point {
        int x, h;

        Point(int x, int h) {
            this.x = x;
            this.h = h;
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        if (buildings == null || buildings.length == 0) {
            return ans;
        }

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            points.add(new Point(buildings[i][0], -buildings[i][2]));
            points.add(new Point(buildings[i][1], buildings[i][2]));
        }

        points.sort((a, b) -> {
            if (a.x != b.x)
                return a.x - b.x;

            return a.h - b.h;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int prev = 0;
        for (Point p: points) {
            System.out.println(p.x + ", " + p.h);
            if (p.h < 0) {
                // starting points
                pq.offer(-p.h);
            } else {
                // end points
                pq.remove(p.h);
            }

            int cur = pq.peek();
            if (prev != cur) {
                // System.out.println(p.x + ", " + cur);
                ans.add(Arrays.asList(p.x, cur));
                prev = cur;
            }
        }

        return ans;
    }
}
