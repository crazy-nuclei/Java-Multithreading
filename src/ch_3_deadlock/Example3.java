package ch_3_deadlock;

/*
use tryLock to acquire the locks on items.
 */

import java.util.concurrent.locks.ReentrantLock;

class Thing2 {
    public String name;
    public ReentrantLock lock;

    Thing2(String name) {
        this.name = name;
        lock = new ReentrantLock();
    }
}

public class Example3 {

    public static void main(String[] args) {
        Thing2 thing1 = new Thing2("one");
        Thing2 thing2 = new Thing2("two");

        Runnable task = () -> {
            try{
                if(thing1.lock.tryLock() && thing2.lock.tryLock()) {
                    System.out.println("Both thing locked by " + Thread.currentThread().getName());
                } else {
                    System.out.println("Failed to acquire lock by " + Thread.currentThread().getName());
                }
            } finally {
                if(thing1.lock.isHeldByCurrentThread()) thing1.lock.unlock();
                if(thing2.lock.isHeldByCurrentThread()) thing2.lock.unlock();
            }
        };

        Thread thread1 = new Thread(task, "thread1");
        Thread thread2 = new Thread(task, "thread2");

        thread1.start();
        thread2.start();
    }
}
