package com.booknara.problem.stack;

import java.util.Stack;

/**
 * Leet code : 735. Asteroid Collision (Medium)
 * We are given an array asteroids of integers representing asteroids in a row.
 * For each asteroid, the absolute value represents its size, and the sign represents its direction
 * (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 *
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode.
 * If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 *
 * Example 1:
 * Input:
 * asteroids = [5, 10, -5]
 * Output: [5, 10]
 * Explanation:
 * The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
 *
 * Example 2:
 * Input:
 * asteroids = [8, -8]
 * Output: []
 * Explanation:
 * The 8 and -8 collide exploding each other.
 *
 * Example 3:
 * Input:
 * asteroids = [10, 2, -5]
 * Output: [10]
 * Explanation:
 * The 2 and -5 collide resulting in -5.  The 10 and -5 collide resulting in 10.
 *
 * Example 4:
 * Input:
 * asteroids = [-2, -1, 1, 2]
 * Output: [-2, -1, 1, 2]
 * Explanation:
 * The -2 and -1 are moving left, while the 1 and 2 are moving right.
 * Asteroids moving the same direction never meet, so no asteroids will meet each other.
 */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        // Input clarification
        if (asteroids == null || asteroids.length == 0) {
            return null;
        }

        // Stack
        Stack<Integer> stack = new Stack<>();
        // For loop
        for (int n: asteroids) {
            // Condition 1 : Positive value, push(n) to stack
            if (n > 0) {
                stack.push(n);
                continue;
            }

            // Condition 2 : Negative value
            while (!stack.empty() && stack.peek() > 0 && stack.peek() < Math.abs(n)) {
                // keep popping if stack is not empty and top value is positive && smaller than the absolute input value
                stack.pop();
            }

            if (stack.empty() || stack.peek() < 0) {
                // Condition 3 : stack is empty or top value is negative
                stack.push(n);
            } else if (stack.peek() + n == 0) {
                // Condition 3 : stack top value(+) plus input value(-) equal to 0
                stack.pop();
            }
        }

        int[] ans = new int[stack.size()];
        int i = stack.size() - 1;
        while (!stack.empty()) {
            ans[i] = stack.pop();
            i--;
        }

        return ans;
    }
}
