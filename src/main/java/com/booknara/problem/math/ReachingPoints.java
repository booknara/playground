package com.booknara.problem.math;

import java.util.HashSet;
import java.util.Set;

/**
 * Leet code : 780. Reaching Points (Hard)
 * https://leetcode.com/problems/reaching-points/
 *
 * digraph G {
 *   "(x,y)" -> "(x+y,y)"
 *   "(x,y)" -> "(x,x+y)"
 *
 *   "(x+y,y)" -> "(x+2y,y)"
 *   "(x+y,y)" -> "(x+y,x+2y)"
 *
 *   "(x,x+y)" -> "(2x+y,x+y)"
 *   "(x,x+y)" -> "(x,2x+y)"
 *
 *   "(x+2y,y)" -> "(x+3y,y)"
 *   "(x+2y,y)" -> "(x+2y,x+3y)"
 *
 *   "(x+y,x+2y)" -> "(2x+3y,x+2y)"
 *   "(x+y,x+2y)" -> "(x+y,2x+3y)"
 *
 *   "(2x+y,x+y)" -> "(3x+2y,x+y)"
 *   "(2x+y,x+y)" -> "(2x+y,3x+2y)"
 *
 *   "(x,2x+y)" -> "(3x+y,2x+y)"
 *   "(x,2x+y)" -> "(x,3x+y)"
 * }
 *
 */
public class ReachingPoints {
    // Time: O(2^tx+ty), Space: O(tx * ty)
    public boolean reachingPointsRecursive(int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) {
            return true;
        }

        if (sx > tx || sy > ty) {
            return false;
        }

        return reachingPointsRecursive(sx, sx + sy, tx, ty)
                || reachingPointsRecursive(sx + sy, sx, tx, ty);
    }

    // Time: O(), Space: O()
    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    Set<Point> seen = new HashSet<>();
    // Time: O(tx∗ty), Space: O(tx∗ty)
    public boolean reachingPointsDP(int sx, int sy, int tx, int ty) {
        return search(sx, sy, tx, ty);
    }

    public boolean search(int sx, int sy, int tx, int ty) {
        if (sx > tx || sy > ty) {
            return false;
        }

        if (seen.contains(new Point(sx, sy))) {
            return false;
        }

        seen.add(new Point(sx, sy));
        if (sx == tx && sy == ty) {
            return true;
        }

        return search(sx + sy, sy, tx, ty) || search(sx, sx + sy, tx, ty);
    }

    // Time: O(max(tx,ty)), Space: O(1)
    public boolean reachingPointsBackward(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx == sx && ty == sy) {
                return true;
            }

            if (tx > ty) {
                tx = tx - ty;
            } else {
                ty = ty - tx;
            }
        }

        return false;
    }

    public boolean reachingPointsBackwardModulo(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx == ty) {
                break;
            }

            if (tx > ty) {
                if (ty > sy) tx %= ty;
                else return (tx - sx) % ty == 0;
            } else {
                if (tx > sx) ty %= tx;
                else return (ty - sy) % tx == 0;
            }
        }

        return (tx == sx && ty == sy);
    }
}
