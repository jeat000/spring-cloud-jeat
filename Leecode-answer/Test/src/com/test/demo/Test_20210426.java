package com.test.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Test_20210426
 * @Author chenjian
 * @Date 2021-04-26 11:21
 */
public class Test_20210426 {
    private int n;
    AtomicInteger atomicInteger = new AtomicInteger(1);
    ReentrantLock reentrantLock = new ReentrantLock();
    Condition condition1 = reentrantLock.newCondition();
    Condition condition2 = reentrantLock.newCondition();

    public Test_20210426(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        reentrantLock.lock();
        try {
            for (int i = 0; i < n; i++) {
                if (atomicInteger.get()==0){
                    condition1.await();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                atomicInteger.set(0);
                condition2.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        reentrantLock.lock();
        try {
            for (int i = 0; i < n; i++) {
                if (atomicInteger.get()==1) {
                    condition2.await();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                atomicInteger.set(1);
                condition1.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }




    class Foo {
        CountDownLatch condition1;
        CountDownLatch condition2;
        public Foo() {
            condition1 = new CountDownLatch(1);
            condition2 = new CountDownLatch(1);
        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            condition1.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            condition1.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            condition2.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            condition2.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}


