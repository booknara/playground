package com.booknara.problem.math;

/**
 * Draw a Circle
 * https://leetcode.com/discuss/interview-question/513389/facebook-phone-screen-draw-a-circle
 */
public class ShapeHelper {
    public void drawCircle(int a, int b, int radius) {
        // Circle equation: (x-a)*(x-a) + (y-b)*(y-b) = radius*radius
        // x^2 + y^2 = radius^2;
        for (int x = 0; x < radius; x++) {
            int y = (int) Math.sqrt(radius * radius - x * x);
            // (x, y) coordination
            drawPoint(a + x, b + y);
            drawPoint(a + x, b - y);
            drawPoint(a - x, b + y);
            drawPoint(a - x, b - y);

            // (y, x) coordination
            drawPoint(a + y, b + x);
            drawPoint(a + y, b - x);
            drawPoint(a - y, b + x);
            drawPoint(a - y, b - x);
        }
    }

    public void drawPoint(int a, int b) {
        // This method draws (a, b) point.
    }
}
