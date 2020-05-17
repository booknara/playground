package com.booknara.problem.heap;

import java.util.PriorityQueue;

/**
 * 855. Exam Room (Medium)
 * https://leetcode.com/problems/exam-room/
 */
public class ExamRoom {
    PriorityQueue<Range> pq;
    int N;

    public ExamRoom(int N) {
        this.N = N;
        pq = new PriorityQueue<>((r1, r2) -> {
            if (r1.distance == r2.distance) {
                return Integer.compare(r1.start, r2.start);
            }
            return Integer.compare(r2.distance, r1.distance);
        });
        pq.offer(new Range(-1, N));
    }

    // T:O(1), S:O(1)
    public int seat() {
        Range r = pq.poll();
        int place = 0;
        if (r.start == -1) {
            pq.offer(new Range(0, r.end));
            place = 0;
        } else if (r.end == N) {
            pq.offer(new Range(r.start, N - 1));
            place = N - 1;
        } else {
            int mid = r.start + (r.end - r.start) / 2;
            pq.offer(new Range(r.start, mid));
            pq.offer(new Range(mid, r.end));
            place = mid;
        }

        return place;
    }

    // T:O(n), S:O(1)
    public void leave(int p) {
        Range front = null;
        Range back = null;

        // Setting -1, N before starting for convenience
        Range merged = new Range(-1, N);
        for (Range r: pq) {
            if (p == r.start) {
                merged.end = r.end;
                back = r;
            } else if (p == r.end) {
                merged.start = r.start;
                front = r;
            }
        }

        pq.remove(front);
        pq.remove(back);
        pq.offer(new Range(merged.start, merged.end));
    }

    class Range {
        int start;
        int end;
        int distance;
        Range(int start, int end) {
            this.start = start;
            this.end = end;

            // get a distance in advance
            if (start == -1) {
                distance = end;
            } else if (end == N) {
                distance = N - start - 1;
            } else {
                distance = (end - start) / 2;
            }
        }
    }
}
