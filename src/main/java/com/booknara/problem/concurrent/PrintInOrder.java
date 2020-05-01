package com.booknara.problem.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1114. Print in Order (Easy)
 * https://leetcode.com/problems/print-in-order/
 */
public class PrintInOrder {
    private final AtomicInteger atomicInteger;
    public PrintInOrder() {
        atomicInteger = new AtomicInteger(3);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        while (atomicInteger.get() != 3);
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        atomicInteger.decrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (atomicInteger.get() != 2);
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        atomicInteger.decrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (atomicInteger.get() != 1);
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        atomicInteger.decrementAndGet();
    }

}
