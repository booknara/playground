package com.booknara.problem.concurrent;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 1115. Print FooBar Alternately (Medium)
 * https://leetcode.com/problems/print-foobar-alternately/
 */
public class PrintFooBarAlternately {
    private int n;
    private final AtomicBoolean fooTrigger;

    public PrintFooBarAlternately(int n) {
        this.n = n;
        this.fooTrigger = new AtomicBoolean(true);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (!fooTrigger.get()) {
                Thread.sleep(1);
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            fooTrigger.set(false);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (fooTrigger.get()) {
                Thread.sleep(1);
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooTrigger.set(true);
        }
    }
}

//class PrintFooBarAlternately {
//    private int n;
//    private Semaphore bar;
//    private Semaphore foo;
//
//    public PrintFooBarAlternately(int n) {
//        this.n = n;
//        this.bar = new Semaphore(0);
//        this.foo = new Semaphore(1);
//    }
//
//    public void foo(Runnable printFoo) throws InterruptedException {
//
//        for (int i = 0; i < n; i++) {
//            foo.acquire();
//            // printFoo.run() outputs "foo". Do not change or remove this line.
//            printFoo.run();
//            bar.release();
//        }
//    }
//
//    public void bar(Runnable printBar) throws InterruptedException {
//
//        for (int i = 0; i < n; i++) {
//            bar.acquire();
//            // printBar.run() outputs "bar". Do not change or remove this line.
//            printBar.run();
//            foo.release();
//        }
//    }
//}