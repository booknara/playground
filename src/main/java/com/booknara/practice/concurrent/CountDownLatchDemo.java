package com.booknara.practice.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        // Let us create task that is going to
        // wait for four threads before it starts
        CountDownLatch latch = new CountDownLatch(4);

        // Let us create four worker
        // threads and start them.
        Worker first = new Worker(1000, latch,
                "WORKER-1");
        Worker second = new Worker(2000, latch,
                "WORKER-2");
        Worker third = new Worker(3000, latch,
                "WORKER-3");
        Worker fourth = new Worker(4000, latch,
                "WORKER-4");
        first.start();
        second.start();
        third.start();
        fourth.start();

        // The main task waits for four threads
        latch.await();

        // Matrix thread has started
        System.out.println(Thread.currentThread().getName() +
                " has finished");
    }

    class Solution {
        public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
            int[] answer = new int[A.length];

            for (int i = 0; i < queries.length; i++) {
                int value = queries[i][0];
                int index = queries[i][1];
                if (index > A.length) {
                    // IndexOutofBound Exception
                } else {
                    A[index] = A[index] + value;
                }

                int sumEven = 0;
                for (int num: A) {
                    if (num / 2 == 0) {
                        sumEven += sumEven + num;
                    }
                }

                answer[i] = sumEven;
            }

            return answer;
        }
    }
}
